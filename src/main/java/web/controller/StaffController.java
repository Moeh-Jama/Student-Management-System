package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.exception.StudentNotFoundException;
import web.model.Util.EnrolledModuleStudent;
import web.model.Util.Staff;
import web.model.Util.Student;
import web.repository.EnrolledModuleStudentRepository;
import web.repository.ModuleRepository;
import web.repository.StaffRepository;
import web.repository.StudentRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StaffController {

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    EnrolledModuleStudentRepository enrolledModuleStudentRepository;


    @GetMapping("module/{module_id}/grades")
    public ModelAndView getStudentsInModuleDisplayed(ModelMap model,
        @PathVariable(value = "module_id") int module_id,
                                               HttpSession session) {
        String userType = (String) session.getAttribute("userType");
        System.out.println("USER ENTERED!!!");
        if(userType==null || !userType.equals("staff")){
            return new ModelAndView("redirect:/login", model);
        }

        Staff staff  =(Staff) session.getAttribute("staff");
        List<EnrolledModuleStudent> enrolledModuleStudentsFound = null;
        List<Student> studentsList = new ArrayList<>();
        try{
//            enrolledModuleStudentsFound= enrolledModuleStudentRepository.getAllGradesOfModule(module_id);
              enrolledModuleStudentsFound = enrolledModuleStudentRepository.findAll();
//            for(EnrolledModuleStudent ems: enrolledModuleStudentsFound){
//                Student student = studentRepository.findById(ems.getEms_student_id()).orElseThrow(()-> new StudentNotFoundException(ems.getEms_student_id()));
//                System.out.println("Is Student null? "+student==null );
//                if(student!=null)
//                    studentsList.add(student);
//            }

        }catch(Exception e){
//            e.printStackTrace();
            System.out.println("Could not access the Enrolled Module studens!");
        }

        if(enrolledModuleStudentsFound!=null && !enrolledModuleStudentsFound.isEmpty()){
            List<EnrolledModuleStudent> finalOutput = new ArrayList<>();
            for(EnrolledModuleStudent ems: enrolledModuleStudentsFound){
                if(ems.getEms_module_id()==module_id)
                    finalOutput.add(ems);
            }
            System.out.println("Finishing up lool"+finalOutput.size());
            model.addAttribute("moduleGrades", finalOutput);model.addAttribute("moduleID", module_id);
        }
        ModelAndView mam = new ModelAndView("moduleGrades");
//        return new ModelAndView("redirect:/module/"+module_id+"/grades", model);
        return mam;
    }



    @RequestMapping(value="module/{module_id}/grades/{student_id}", method=RequestMethod.GET)
    public ModelAndView editStudentGrade(ModelMap model, @PathVariable(value = "module_id")
            Long module_id, @PathVariable(value = "student_id") Long student_id, HttpSession session) {

        String userType = (String) session.getAttribute("userType");
        System.out.println("get editStudentGrade");
        if(userType==null || !userType.equals("staff")){
            //direct to another place
            return new ModelAndView("redirect:/studentDetails/"+student_id, model);
        }
        EnrolledModuleStudent gradeDetails = null;
        try{
//            Student student = EnrolledModuleStudentRepository.findByStudentID
            List<EnrolledModuleStudent> emsList = enrolledModuleStudentRepository.findAll();
            for(EnrolledModuleStudent ems: emsList){
                if(ems.getEms_module_id()==module_id && ems.getEms_student_id()==student_id){
                    gradeDetails = ems;
                    break;
                }
            }
//            gradeDetails = EnrolledModuleStudentRepository.findByStudentID(student);
        }catch(Exception e){

        }
        ModelAndView mam = new ModelAndView("editStudentGrade");
        model.addAttribute("gradeDetails", gradeDetails);
        mam.addObject(model);
//        return new ModelAndView("redirect:/module/"+module_id+"/grades/"+student_id, model);
        return mam;
    }


    @PostMapping("module/{module_id}/grades/{student_id}")
    public ModelAndView postStudentGrade(ModelMap model, @PathVariable(value = "module_id")
            Long module_id, @PathVariable(value = "student_id") Long student_id, HttpSession session, @RequestParam("grade") float grade){

        System.out.println("post editStudentGrade");
        List<EnrolledModuleStudent> allEnrolled = new ArrayList<>();
        allEnrolled = enrolledModuleStudentRepository.findAll();
        EnrolledModuleStudent real = null;
        for(EnrolledModuleStudent ems: allEnrolled){
            if(ems.getEms_student_id()==student_id && ems.getEms_module_id()==module_id){
                real = ems;
                break;

            }
        }
        System.out.println("HMMMMM");
        if(real!=null){
            System.out.println("Saving user details");
            real.setGrade(grade);
            enrolledModuleStudentRepository.save(real);
        }

        return new ModelAndView("redirect:/module/{module_id}/grades", model);
    }
}

