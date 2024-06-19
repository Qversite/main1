package com.example.preddema.Controller;

import com.example.preddema.Dto.UserDto;
import com.example.preddema.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthController {
    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @GetMapping("signup")
    public String signUpPage(){
        return "signUp";
    }
    @PostMapping("signup")
    public String signUp(UserDto userDto){
        service.signUp(userDto);
        return "redirect:/login";
    }
}
