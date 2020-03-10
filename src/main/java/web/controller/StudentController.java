package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.exception.StudentNotFoundException;
import web.model.Util.Student;
import web.repository.EnrolledModuleStudentRepository;
import web.repository.ModuleRepository;
import web.repository.StudentRepository;

import javax.servlet.http.HttpSession;

@Controller
public class StudentController {

    @Autowired
    StudentRepository studentRepository;


    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    EnrolledModuleStudentRepository enrolledModuleStudentRepository;

    @GetMapping("studentDetails/{student_id}")
    public String showStudentDetails(ModelMap model, @PathVariable(value="student_id") int student_id, HttpSession session){

        try{
            Student student = studentRepository.findById(student_id).orElseThrow(()->new StudentNotFoundException(student_id));

            model.addAttribute("student",student);
            return "studentDetails";

        }catch(Exception e){

        }

        return "welcome";
    }


    //pay fees
    @RequestMapping(value="/studentDetails/{student_id}/Fee", method = RequestMethod.GET)
    public ModelAndView seeFees(ModelMap model, HttpSession session, @PathVariable(name="student_id") Long student_id){

        String userType = (String) session.getAttribute("userType");

        if(userType!=null && !userType.equals("student")){
            //back to home
        }


        Student student =(Student) session.getAttribute("student");
        if(student.getStudentID()!=student_id){
            //incorrect user, send off
        }



        model.addAttribute("student", student);
        ModelAndView mam = new ModelAndView("payFees");
        mam.addObject(model);

        return mam;
    }


    @PostMapping("/studentDetails/{student_id}/Fee")
    public ModelAndView paidFees(ModelMap model, HttpSession session, @PathVariable(name="student_id") Long student_id){
        String userType = (String) session.getAttribute("userType");

        if(userType!=null && !userType.equals("student")){
            //back to home
        }


        Student student =(Student) session.getAttribute("student");
        if(student.getStudentID()!=student_id){
            //incorrect user, send off
        }

        student.setFees(0);
        studentRepository.save(student);
        ModelAndView mam = new ModelAndView("payFees");
        mam.addObject(model);
        return mam;
    }



//    studentDetails
}
