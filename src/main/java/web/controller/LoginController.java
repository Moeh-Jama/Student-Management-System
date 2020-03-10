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
import web.service.LoginService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
    LoginService service;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	RegisteredUserRepository registeredUserRepository;

	@Autowired
	StaffRepository staffRepository;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password, HttpSession session) throws Exception {
		int temp_person = -1;

		try{
			temp_person = Integer.parseInt(name);
		}catch(Exception nameNotNumerical){
			System.out.println("Entered Student ID is not numeric");
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

		}catch(RegisteredUserNotFoundException registeredUserException){
			System.out.println("Exception: "+registeredUserException.getMessage());
		}
		if(ru!=null){
			if(isStaff){
				Staff staff = staffRepository.findById(person_id).orElseThrow(()-> new StaffNotFoundException(person_id));
				session.setAttribute("staff", staff);
				session.setAttribute("userType","staff");
				return new ModelAndView("redirect:/showStudents", model);
			}
			else{
				Student student = studentRepository.findById(person_id).orElseThrow(() -> new StudentNotFoundException(person_id));
				System.out.println("User found: "+student.getFirstname());
				session.setAttribute("userType","student");
				session.setAttribute("student",student);
				return new ModelAndView("redirect:/studentDetails/"+student.getStudentID(), model);
			}
		}
		else{
			//go back to login again.
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
		System.out.println("Student Registered");
		System.out.println("Student Id: "+student.getStudentID());
		System.out.println("User entered Password"+password);
		System.out.println("firstName "+student.getFirstname());
		System.out.println("surname "+student.getSurname());
		System.out.println("Address: "+student.getAddress());
		System.out.println("Nationality: "+student.getNationality());
		System.out.println("DOB: "+student.getDateOfBirth());
		System.out.println("Gender: "+student.getGender());
		System.out.println("Stage: "+student.getStage());



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

}
