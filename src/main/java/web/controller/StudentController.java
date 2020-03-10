package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import web.exception.StudentNotFoundException;
import web.model.Util.Student;
import web.repository.StudentRepository;

import javax.servlet.http.HttpSession;

@Controller
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

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

//    studentDetails
}
