package ru.basov.springcourse.springapp1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class Calculator {
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value="a", required = false) String a,
                             @RequestParam(value = "b", required = false) String b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model){
        switch (action){
            case "multiplication":
                model.addAttribute("calculator", Integer.parseInt(a)*Integer.parseInt(b));
                break;
            case "addition":
                model.addAttribute("calculator", Integer.parseInt(a)+Integer.parseInt(b));
                break;
            case "subtraction":
                model.addAttribute("calculator", Integer.parseInt(a)-Integer.parseInt(b));
                break;
            case "division":
                model.addAttribute("calculator", (double)Integer.parseInt(a)/Integer.parseInt(b));
            default:
        }
    return "first/calculator";
    }
}
