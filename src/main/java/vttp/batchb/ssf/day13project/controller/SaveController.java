package vttp.batchb.ssf.day13project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import vttp.batchb.ssf.day13project.Task;
import java.util.*;

@Controller
@RequestMapping
public class SaveController {
    @PostMapping("/exit")
    public String postExit(HttpSession sess,Model model){
        List<Task> taskList = (List<Task>)sess.getAttribute(SubController.TASK_LIST);


        System.out.printf(">>> tasklist: %s\n", taskList);

        sess.invalidate();
        model.addAttribute("task", new Task());
        model.addAttribute("isFree",true);
        return "index";
    }

    
}
