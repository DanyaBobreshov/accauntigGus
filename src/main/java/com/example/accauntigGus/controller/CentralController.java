package com.example.accauntigGus.controller;

import com.example.accauntigGus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CentralController {
    private final UserService userService;

    @GetMapping("/")
    public String central(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "central";
    }
}
