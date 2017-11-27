package com.finance.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping(path="/welcome")
    public String getStartPage(Model model){
        model.addAttribute("name", "Frank");
        return "welcome";
    }
}
