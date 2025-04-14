package com.example.kenshu2app.controller;

import com.example.kenshu2app.dto.UsersDTO;
import com.example.kenshu2app.entity.Groups;
import com.example.kenshu2app.entity.PrimarySkill;
import com.example.kenshu2app.entity.SecondarySkill;
import com.example.kenshu2app.service.UsersService;
import com.example.kenshu2app.repository.GroupsRepository;
import com.example.kenshu2app.repository.PrimarySkillRepository;
import com.example.kenshu2app.repository.SecondarySkillRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private GroupsRepository groupRepository;

    @Autowired
    private PrimarySkillRepository primarySkillRepository;

    @Autowired
    private SecondarySkillRepository secondarySkillRepository;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("usersDTO", new UsersDTO());
        model.addAttribute("groups", groupRepository.findAll());
        model.addAttribute("primarySkills", primarySkillRepository.findAll());
        model.addAttribute("secondarySkills", secondarySkillRepository.findAll());
        return "register"; // register.htmlに遷移
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("usersDTO") @Valid UsersDTO dto,
                           BindingResult bindingResult,
                           Model model) {
    	System.out.println("register メソッド呼ばれたよ");

        if (bindingResult.hasErrors()) {
            model.addAttribute("groups", groupRepository.findAll());
            model.addAttribute("primarySkills", primarySkillRepository.findAll());
            model.addAttribute("secondarySkills", secondarySkillRepository.findAll());
            System.out.println("しっぱいだよ");
            return "register"; // register.htmlに遷移
        }

        usersService.registerUser(dto);
        return "register_success"; // register_success.htmlに遷移
    }
}