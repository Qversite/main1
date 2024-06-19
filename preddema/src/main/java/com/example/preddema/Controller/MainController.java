package com.example.preddema.Controller;

import com.example.preddema.Model.Statements;
import com.example.preddema.Service.StatementsService;
import com.example.preddema.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final StatementsService service;
    private final UserService userService;


    @GetMapping("main")
    public String main(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("statements", service.getAllByUsername(user.getUsername()));
        model.addAttribute("user", userService.getUser(user.getUsername()));
        return "main";
    }
    @PostMapping("addStatement")
    public String addStatement(Statements statements, @AuthenticationPrincipal User user){
        service.saveStatements(statements, user.getUsername());
        return "redirect:/main";
    }
}
