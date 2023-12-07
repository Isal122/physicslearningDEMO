package Kelompok4.physicslearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/forum")
    public String index() {
        return "redirect:/index.html";
    }
}