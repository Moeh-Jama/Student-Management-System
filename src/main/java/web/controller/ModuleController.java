package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Util.Module;
import web.repository.ModuleRepository;
import web.exception.ModuleNotFoundException;
import java.util.List;

@Controller
public class ModuleController {

    @Autowired
    ModuleRepository moduleRepository;

    // Get a single module
    @GetMapping("/module/{id}")
    public String getModuleById(ModelMap model, @PathVariable(value = "id") Long moduleId) throws ModuleNotFoundException {

        Module module =  moduleRepository.findById(moduleId).orElseThrow(() -> new ModuleNotFoundException(moduleId));

        model.put("model", module);
        return "module";
    }

    // Get modules by topic

}
