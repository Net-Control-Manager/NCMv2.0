package org.ncm.ncmv2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping
    public String dashboard(Model model) {

        model.addAttribute("variable", "This is Net Control Manager Version 2.0!");



        return "dashboard";
    }
}
