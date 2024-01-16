package com.amogoscode.enno.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.amogoscode.enno.GlobalExceptionHandler.GlobalExceptionHandler;
import com.amogoscode.enno.Service.CustomUserDetailsService;

@Controller
public class m_c {
    @Autowired
    GlobalExceptionHandler globalExceptionHandler;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @GetMapping("/")
    public String Home(Model model) {
        return "Home";
    }

    @GetMapping("/login")
    public String Home2(Model model) {
        model.addAttribute("message", "Welcome :]");
        return "redirect:/";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    @GetMapping("/logout")
    public String logout() {
        // Logic to perform logout actions if needed (invalidate session, clear cookies,
        // etc.)
        // You can add custom logout logic here

        // Redirect to the logout success page
        return "redirect:/logout-success";
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        // Render the logout success page
        return "logout";
    }

}
