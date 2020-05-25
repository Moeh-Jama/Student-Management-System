package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.exception.RegisteredUserNotFoundException;
import web.exception.StaffNotFoundException;
import web.exception.StudentNotFoundException;
import web.model.Util.RegisteredUser;
import web.model.Util.Staff;
import web.model.Util.Student;
import web.repository.RegisteredUserRepository;
import web.repository.StaffRepository;
import web.repository.StudentRepository;
import web.service.LoginAttemptService;
import web.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
//import web.service.LoginAttemptService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import java.util.logging.Logger;


@Controller
@SessionAttributes("name")
public class LoginController {

	// Logger to log login details
	public static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

	@Autowired
	LoginService service;

	@Autowired
	LoginAttemptService loginAttemptService;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	RegisteredUserRepository registeredUserRepository;

	@Autowired
	StaffRepository staffRepository;

	@RequestMapping(value="blocked", method=RequestMethod.GET)
	public String blockedPage(ModelMap model){
		model.addAttribute("ip", getIP());
		return "blocked";
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model,  @RequestParam(required = false) String error){
		System.out.println("Error message is "+error);
		System.out.println(model.keySet());
		return "login";
	}


	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password, HttpSession session) throws Exception {
		String ip = getIP();

		if(loginAttemptService.isBlocked(ip)){
			//go back
//			System.out.println("You are blocked")
			return new ModelAndView("redirect:/blocked", model);
		}

		int temp_person = -1;

		try{
			temp_person = Integer.parseInt(name);
		}catch(Exception nameNotNumerical){
			System.out.println("Entered Student ID is not numeric");
			LOGGER.info("Logger: Failed login attempt\n"); // Just added
			return new ModelAndView("redirect:/login", model);
		}
		int person_id = temp_person;
		RegisteredUser ru = null;
		boolean isStaff = false;
		try{
			System.out.println(person_id);
			System.out.println(password);
			isStaff = registeredUserRepository.isRegisteredUserStaffType(person_id);
			System.out.println("Staff is: "+isStaff);
			ru = registeredUserRepository.findById(person_id).orElseThrow(() -> new RegisteredUserNotFoundException(person_id));
			LOGGER.info("Logger: ID: " + Integer.toString(person_id) + "\n"); // Just added
			LOGGER.info("Logger: password logged " + "\n"); // Not supposed to log sensitive information

		}catch(RegisteredUserNotFoundException registeredUserException){
//			System.out.println("Exception: "+registeredUserException.getMessage());
			loginAttemptService.loginFailed(ip);
			return new ModelAndView("redirect:/login", model);
		}
		if(ru!=null){
			if(isStaff &&  ru.getPassword().equals(password)){
				Staff staff = staffRepository.findById(person_id).orElseThrow(()-> new StaffNotFoundException(person_id));
				session.setAttribute("staff", staff);
				session.setAttribute("userType","staff");
				loginAttemptService.loginSucceeded(ip);
				return new ModelAndView("redirect:/showStudents", model);
			}
			else if( !(isStaff) &&  ru.getPassword().equals(password)){
				Student student = studentRepository.findById(person_id).orElseThrow(() -> new StudentNotFoundException(person_id));
				System.out.println("User found: "+student.getFirstname());
				session.setAttribute("userType","student");
				session.setAttribute("student",student);
				loginAttemptService.loginSucceeded(ip);
				return new ModelAndView("redirect:/studentDetails/"+student.getStudentID(), model);
			}
			loginAttemptService.loginFailed(ip);
			return new ModelAndView("redirect:/login", model);
		}
		else{
			//go back to login again.
			loginAttemptService.loginFailed(ip);
			return new ModelAndView("redirect:/login", model);
		}
	}

	@RequestMapping("/showStudents")
	public String showAllStudents(ModelMap model){

		List<Student> studentList = studentRepository.findAll();
		System.out.println("Getting students");
		for(Student student: studentList){
			System.out.println(student.getFirstname()+" "+student.getSurname());
		}
		model.addAttribute("students", studentList);
		return "showStudents";
	}

	@RequestMapping(value ="/register", method = RequestMethod.GET)
	public String registerStudent(ModelMap model){
		model.put("new",true);
		return "register";
	}

	@PostMapping(value="/register")
	public String registerStudentPosted(@ModelAttribute("student") Student student, @RequestParam("password") String password,
										@RequestParam("student_id") int studentID,
										@RequestParam("DOB") String date,
										@RequestParam("firstname")String firstname, Model model){

		student.setFirstName(firstname);
		student.seStudentID(studentID);
		String[] dob = date.split("-");
		Date d  = new Date(Integer.parseInt(dob[0]),Integer.parseInt(dob[1]),Integer.parseInt(dob[2]));
		student.setDataOfBirth(d);


		RegisteredUser ru = new RegisteredUser(studentID,password,false);
//		List<RegisteredUser> registeredUsersList = registeredUserRepository.findAll();
		boolean otherFound= false;
		try{
			RegisteredUser other = registeredUserRepository.findById(studentID).orElseThrow(()-> new RegisteredUserNotFoundException(studentID));
			otherFound = true;
		}catch (Exception e){
			otherFound = false;
		}

		if(!otherFound){
			registeredUserRepository.save(ru);
			studentRepository.save(student);
			return "login";
		}


//		model.put("justRegistered",true);
		model.addAttribute("ErrorMessage", "Could not register user, ID is already used");

		return "register";
	}



	@RequestMapping(value ="/logout", method = RequestMethod.GET)
	public ModelAndView logout(ModelMap model,HttpSession session){
		String current  = (String) session.getAttribute("userType");
		session.removeAttribute("userType");
		return new ModelAndView("redirect:/login", model);
	}



	private String getIP() {
		String header = request.getHeader("X-Forwarded-For");
		String output = "";

		if (header == null){
			output =  request.getRemoteAddr();
		}
		else {
			// If the request does not have an IP, then we parse the header
			output =  header.split(",")[0];
		}

		return output;
	}

}
