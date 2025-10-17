package org.ncm.ncmv2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {

        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {

        return "create";
    }

    @GetMapping("/search")
    public String search(Model model) {

        return "search";
    }

    @GetMapping("/help")
    public String help(Model model) {

        return "redirect:https://github.com/Net-Control-Manager/NCMv2.0/wiki";
    }
}
