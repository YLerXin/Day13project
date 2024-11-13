package vttp.batchb.ssf.day13project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.batchb.ssf.day13project.Task;

@Controller
@RequestMapping(path = {"/","/index.html"})
public class indexcontroller {

    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("task",new Task());
        model.addAttribute("isFree",true);
        return "index";
    }
    
}
