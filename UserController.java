package com.flightreservation.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.flightreservation.model.User;
import com.flightreservation.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signupPage(Model model) {

        model.addAttribute("user", new User());

        return "signup";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult result) {

        if(result.hasErrors()) {

            return "signup";

        }

        userService.registerUser(user);

        return "redirect:/user/login";

    }

    @GetMapping("/login")
    public String loginPage() {

        return "login";

    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        User user =
                userService.login(email, password);

        if(user == null) {

            model.addAttribute("error",
                    "Invalid Email or Password");

            return "login";

        }

        session.setAttribute("loggedInUser", user);

        if(user.getRole().equalsIgnoreCase("ADMIN")) {

            return "redirect:/admin/dashboard";

        }

        return "redirect:/user/dashboard";

    }

    @GetMapping("/dashboard")
    public String dashboard() {

        return "user/userDashboard";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/";

    }

}
