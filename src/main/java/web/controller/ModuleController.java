package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Util.EnrolledModuleStudent;
import web.model.Util.Module;
import web.model.Util.Staff;
import web.model.Util.Student;
import web.repository.EnrolledModuleStudentRepository;
import web.repository.ModuleRepository;
import web.exception.ModuleNotFoundException;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ModuleController {

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    EnrolledModuleStudentRepository enrolledModuleStudentRepository;

    // Get a single module
    @GetMapping("/module/{id}")
    public String getModuleById(ModelMap model, @PathVariable(value = "id") long moduleId) throws ModuleNotFoundException {
        Module module =  moduleRepository.findById(moduleId).orElseThrow(() -> new ModuleNotFoundException(moduleId));
        model.put("module", module);
        return "module";
    }

    // Get available modules for user
    @GetMapping("available_modules/")
    public String getAllRegisteredModulesForUser(ModelMap model,HttpSession currentSession){
        System.out.println("Begn Find Available Modules");

        String c = (String) currentSession.getAttribute("userType");
        System.out.println("C IS: "+c);
        if(c==null){
//                return new ModelAndView("redirect:/login", model);
            return "login";
        }


        if(currentSession.getAttribute("userType").equals("student")){

            Student student = (Student) currentSession.getAttribute("student");
            if(student==null){
                System.out.println("Student deosn't exist");
//                return new ModelAndView("redirect:/login", model);
                return "login";
            }
            System.out.println("foudn student:"+student);
            System.out.println(student+" is null[?] "+student==null);
//            System.out.println("Student id: "+student.getStudentID());
            List<Module> availableModules = moduleRepository.getAllAvailableModules(student.getStudentID());
            List<EnrolledModuleStudent> enrolledModuleStudents = enrolledModuleStudentRepository.findAll();
            List<Module> notEnrolled = new ArrayList<>();
            for(Module module: availableModules){
                System.out.println("Module id:"+module.getModuleId());
                boolean found = false;
                for(EnrolledModuleStudent ems: enrolledModuleStudents){
                    if(ems.getEms_module_id()==module.getModuleId() && student.getStudentID()==ems.getEms_student_id())
                        found = true;
                }
                if(!found){
                    notEnrolled.add(module);
                }

            }
            ModelAndView mam = new ModelAndView("available_modules");
            model.addAttribute("modules", notEnrolled);
            mam.addObject(mam);
            mam.addObject(currentSession);
            return "available_modules";
//            return mam;
        }else {
            //go away
//            return new ModelAndView("redirect:/login", model);
            return "login";
        }

//        return new ModelAndView("redirect:/login", model);
//        return "login";
    }
    // Get modules by topic


    @GetMapping("enroll/{module_id}")
    public String getEnrollModel(ModelMap model, @PathVariable(value="module_id") Long module_id, HttpSession session){
        String userType = (String) session.getAttribute("userType");
        if(userType==null || !userType.equals("student")){
            System.out.println("Is not student");
            return "welcome";
        }
//        Student student = (Student) session.getAttribute("student");
        System.out.println("Check for module");
        Module module = null;


//            module = moduleRepository.findById(module.getModuleId()).orElseThrow(()-> new ModuleNotFoundException(module_id));
        for(Module mod: moduleRepository.findAll()){
            if(mod.getModuleId()==module_id){
                module = mod;
                break;
            }
        }

        System.out.println("Acces completed "+module==null);

        model.put("module", module);
        return "enroll";
    }

    @PostMapping("enroll/{module_id}")
    public ModelAndView postEnrollModule(ModelMap model, HttpSession session, @PathVariable(value="module_id") long module_id){
        String userType = (String) session.getAttribute("userType");
        if(userType==null || !userType.equals("student")){
            return new ModelAndView("redirect:/login", model);
        }

        Student student = (Student) session.getAttribute("student");
        Module module = null;
        try{
            module = moduleRepository.findById(module_id).orElseThrow(() -> new ModuleNotFoundException(module_id));
        }
        catch(Exception e){
            return new ModelAndView("redirect:/login", model);
        }

//       int a = (int) module_id;
        if(student!=null){

            List<EnrolledModuleStudent> enrolledModuleStudentList = enrolledModuleStudentRepository.findAll();
            boolean alreadyExists = false;
            for(EnrolledModuleStudent ems: enrolledModuleStudentList){
                if(ems.getEms_student_id()==student.getStudentID() && ems.getEms_module_id()==module_id){
                    alreadyExists = true;
                    break;
                }
            }

            if(!alreadyExists){
                EnrolledModuleStudent ems = new EnrolledModuleStudent((int) module_id,(int) student.getStudentID(), module.getEndDate(), 0);
                enrolledModuleStudentRepository.save(ems);
                System.out.println("DONEW");
                return new ModelAndView("redirect:/available_modules", model);
            }
            System.out.println("Bad workl");
            return new ModelAndView("redirect:/available_modules", model);

        }
        else{
            System.out.println("Done bad");
            return new ModelAndView("redirect:/available_modules", model);
        }

    }

    public boolean validateStaffIsInModule(Module module, Staff staff){
        if(staff==null)
            return false;
        if(module==null)
            return false;

        if(staff.getID()==module.getStaff_coordinator_ID()){
            return true;
        }
        else{

        }

        return false;
    }


    @GetMapping("edit/{module_id}")
    public ModelAndView editModule(ModelMap model,@PathVariable(value="module_id") Long module_id, HttpSession currentSesssion) throws ModuleNotFoundException {
        System.out.println("GEtt this and post");
        String currentUserType =(String) currentSesssion.getAttribute("userType");
        System.out.println("user type "+currentUserType);
        if(currentUserType==null){
            //TODO return to login page with some message
            model.addAttribute("ErrorMessage", "cannot edit modules when not logged in");
            return new ModelAndView("redirect:/login", model);
        }
        else if(currentUserType.equals("student")){
            //TODO student cannot edit modules, show blank and tell them to go away
            return new ModelAndView("redirect:/availableModules", model);
        }
        else if(currentUserType.equals("staff")){

            System.out.println("User is staff correct!");
            Module module = moduleRepository.findById(module_id).orElseThrow(()-> new ModuleNotFoundException(module_id));
            System.out.println(module);
            Staff staff = (Staff) currentSesssion.getAttribute("staff");
            if (validateStaffIsInModule(module, staff)) {
                model.addAttribute("module",module);
                return new ModelAndView("editModule", model);

            }
            return new ModelAndView("welcome");

//          return new ModelAndView("redirect:/edit/"+module_id, model);
        }
        else{
            // Some user is messing with sessions some how, big yikes.
            return new ModelAndView("redirect:/availableModules", model);
        }
    }


    @PostMapping("edit/{module_id}")
    public ModelAndView postEditModule(ModelMap model,Module editedModule, @PathVariable(value="module_id") Long module_id,  HttpSession currentSesssion,
                                       @RequestParam(value="module_name") String module_name,
                                       @RequestParam(value="start_date") String startDate,
                                       @RequestParam(value="end_date") String endDate,
                                       @RequestParam(value="staff_coordinator_ID") int coordID,
                                       @RequestParam(value="module_description") String moduleDescription,
                                       @RequestParam(value="capacity") int capacity,
                                       @RequestParam(value="num_of_students") int enrolled_students
    ) throws ModuleNotFoundException {
        System.out.println("Posted yaay");
        String currentUserType =(String) currentSesssion.getAttribute("userType");
        if(currentUserType==null){
            //TODO return to login page with some message
            model.addAttribute("ErrorMessage", "cannot edit modules when not logged in");
            return null;
        }
        else if(currentUserType.equals("student")){
            //TODO student cannot edit modules, show blank and tell them to go away
            return new ModelAndView("redirect:/login", model);
        }
        else if(currentUserType.equals("staff")){
            Module module = null;
            try{
                module = moduleRepository.findById(module_id).orElseThrow(()-> new ModuleNotFoundException(module_id));
            }catch(Exception e){
                return new ModelAndView("redirect:/login", model);
            }

            System.out.println("Module to change");
            System.out.println(module.toString());
            System.out.println(editedModule.toString());
            System.out.println("THIS ONE HERE: "+capacity+","+module_name+","+coordID+","+enrolled_students+","+startDate+","+endDate);
            Module newModule = new Module();
            module.setCapacity(capacity);
            module.setModuleName(module_name);
            module.setStaff_coordinator_ID(coordID);
            module.setNum_of_students(enrolled_students);
            module.setModuleDescription(moduleDescription);

            String[] startDateArr = startDate.split("-");
            String[] endDateArr = endDate.split("-");
            Date newStartDate = new Date();

//            newModule.setCapacity(capacity);


            moduleRepository.save(module);
            return new ModelAndView("redirect:/edit/"+module_id, model);
        }
        else{
            // Some user is messing with sessions some how, big yikes.
            return new ModelAndView("redirect:/login", model);
        }
    }

}
