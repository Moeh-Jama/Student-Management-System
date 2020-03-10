package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Util.Module;
import web.model.Util.Student;
import web.repository.ModuleRepository;
import web.exception.ModuleNotFoundException;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ModuleController {

    @Autowired
    ModuleRepository moduleRepository;

    // Get a single module
    @GetMapping("/module/{id}")
    public String getModuleById(ModelMap model, @PathVariable(value = "id") long moduleId) throws ModuleNotFoundException {
        Module module =  moduleRepository.findById(moduleId).orElseThrow(() -> new ModuleNotFoundException(moduleId));
        model.put("module", module);
        return "module";
    }

    // Get available modules for user
    @GetMapping("availableModules/")
    public ModelAndView getAllRegisteredModulesForUser(ModelMap model,HttpSession currentSession){
        System.out.println("Begn Find Available Modules");

            String c = (String) currentSession.getAttribute("userType");
            System.out.println("C IS: "+c);
            if(c==null){
                return new ModelAndView("redirect:/login", model);
            }


        if(currentSession.getAttribute("userType").equals("student")){
            Student student = (Student) currentSession.getAttribute("student");
            System.out.println(student+" "+student==null);
            System.out.println("Student id: "+student.getStudentID());
            List<Module> availableModules = moduleRepository.getAllAvailableModules(student.getStudentID());
            for(Module module: availableModules){
                System.out.println("Module id:"+module.getModuleId());
            }
            model.addAttribute("modules", availableModules);
            return new ModelAndView("redirect:/available_modules", model);
        }else if(currentSession.getAttribute("userType").equals("staff")){
            //go away
            return new ModelAndView("redirect:/available_modules", model);
        }

        return new ModelAndView("redirect:/available_modules", model);
    }
    // Get modules by topic

}
