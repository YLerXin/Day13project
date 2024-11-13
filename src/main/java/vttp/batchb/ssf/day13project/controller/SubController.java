package vttp.batchb.ssf.day13project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vttp.batchb.ssf.day13project.Task;

import java.util.*;

@Controller
@RequestMapping("/submit")
public class SubController {

    public static final String TASK_LIST = "taskList";

    @PostMapping
    public String postSubmit(@Valid @ModelAttribute("task") Task task,
    BindingResult binding,Model model,HttpSession sess){
        if (binding.hasErrors()){
            List<Task> tasks = (List<Task>)sess.getAttribute(TASK_LIST);
            if (tasks ==null){
                tasks=new LinkedList<>();
                sess.setAttribute(TASK_LIST, tasks);
            }
            model.addAttribute("tasks",tasks);
            model.addAttribute("isFree",tasks.isEmpty());
            return "index";
        }



        List<Task> tasks = (List<Task>)sess.getAttribute(TASK_LIST);

        if(tasks == null){
            tasks = new LinkedList<>();
            sess.setAttribute(TASK_LIST,tasks);
        }

        tasks.add(task);
        model.addAttribute("isFree",false);
        model.addAttribute("tasks",tasks);
        model.addAttribute("task", new Task());//empty the task for the form

        return "index.html";
    }

    
}
