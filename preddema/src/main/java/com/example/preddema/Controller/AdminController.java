package com.example.preddema.Controller;

import com.example.preddema.Service.StatementsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final StatementsService service;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("statements")
    public String allStatements(Model model){
        model.addAttribute("statements", service.getAll());
        return "statements";
    }
    @PostMapping("/statusTrue")
    public String statusTrue(Long id){
        System.out.println(id);
        service.changeStatus(true, id);
        return "redirect:/admin/statements";
    }

    @PostMapping("/statusFalse")
    public String statusFalse(Long id){
        service.changeStatus(false, id);
        return "redirect:/admin/statements";
    }
}
