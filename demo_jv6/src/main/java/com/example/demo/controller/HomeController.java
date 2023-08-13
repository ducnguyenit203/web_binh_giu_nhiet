package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
    @RequestMapping(value = {"/","/home/index"})
    public String home() {
        return "redirect:/web/menu";
    }
    @GetMapping("/test")
    public String test(Model model){
        return "/web/menu";
    }

    @RequestMapping(value = {"/admin","/admin/home/index"})
    public String admin() {
        return "redirect:/assets/admin/index.html";
    }

    @RequestMapping("/home/thymeleaf2")
    public String thymeleaf2(Model model) {
        model.addAttribute("message","Thymeleaf - With Extras");
        return "layout/thymeleaf2";
    }
}
