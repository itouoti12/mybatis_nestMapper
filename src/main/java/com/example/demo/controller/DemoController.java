package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "Hello! Thymleaf!!");
        return "index2";
    }
    
    @RequestMapping("/vueTest")
    public String vueTestIndex(Model model) {
        model.addAttribute("msg", "Hello! Vue.js!!");
        return "index";
    }

}
