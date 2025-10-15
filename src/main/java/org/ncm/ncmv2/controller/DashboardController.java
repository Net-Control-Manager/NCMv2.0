package org.ncm.ncmv2.controller;

import org.ncm.ncmv2.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.ncm.ncmv2.util.SampleData;

@Controller
@RequestMapping("/net")
public class DashboardController {

    @GetMapping({"" , "/", "/{netId}"})
    public String dashboard(Model model, @PathVariable(required = false) Integer netId) {

        Net net = SampleData.Nets.BasicNet();

        if (netId == null) {
            return "redirect:/";
        }

        if (netId == 10000)
            model.addAttribute(net);
        else
            model.addAttribute("net", null);

        model.addAttribute("variable", "This is Net Control Manager Version 2.0!");

        return "dashboard";
    }
}
