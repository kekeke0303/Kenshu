package com.example.kenshu2app.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.kenshu2app.dto.UsersDTO;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(Model model) {
    	model.addAttribute("usersDTO", new UsersDTO());
        return "login"; // templates/login.html を表示
    }
    
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("UsersDTO") @Valid UsersDTO usersDTO,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        }

        // Spring Security に任せるのでここでは認証処理は不要
        return "redirect:/home";
    }
}
