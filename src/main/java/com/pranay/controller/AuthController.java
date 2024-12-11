package com.pranay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.pranay.model.User;
import com.pranay.service.UserService;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("/signin")
    public String signupPage() {
        return "signin";
    }

    @PostMapping("/signin")
    public ModelAndView signup(User user) {
        userService.registerUser(user);
        return new ModelAndView("redirect:/getin");
    }

    @GetMapping("/getin")
    public String loginPage() {
        return "getin";
    }

    @PostMapping("/getin")
    public ModelAndView login(String username, String password, Model model) {
        if (userService.validateUser(username, password)) {
            return new ModelAndView("redirect:job-list");
        }
        model.addAttribute("error", "Invalid credentials");
        return new ModelAndView("getin");
    }
}
