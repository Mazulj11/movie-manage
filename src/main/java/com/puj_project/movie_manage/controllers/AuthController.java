package com.puj_project.movie_manage.controllers;

import com.puj_project.movie_manage.models.User;
import com.puj_project.movie_manage.repository.UserRepository;
import com.puj_project.movie_manage.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService, UserRepository userRepo) {
        this.userService = userService;
    }

    @GetMapping("/auth/register")
    public String add(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            return "redirect:/";
        } else {
            model.addAttribute("user", new User());
            return "register";
        }
    }

    @PostMapping("/auth/register")
    public String newUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        try {
            userService.registerUser(user);
            return "redirect:/auth/login";
        } catch (Exception e) {
            model.addAttribute("saveError", "Error saving user: " + e.getMessage());
            model.addAttribute("user", user);
            return "register";
        }
    }

    @PostMapping("/auth/login")
    public String loginUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "login";
        }
        try {
            userService.authenticateUser(user.getEmail(), user.getPassword());
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("saveError", "Error saving user: " + e.getMessage());
            model.addAttribute("user", user);
            return "login";
        }
    }

    @GetMapping("/auth/login")
    public String login(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            return "redirect:/";
        } else {
            model.addAttribute("user", new User());
            return "login";
        }
    }

    @GetMapping("/auth/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }
}
