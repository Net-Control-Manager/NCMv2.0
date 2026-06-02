package org.ncm.ncmv2.api.controller;

import jakarta.servlet.http.HttpSession;
import org.ncm.ncmv2.api.service.NetService;
import org.ncm.ncmv2.domain.dto.CreateNetDto;
import org.ncm.ncmv2.domain.model.Net;
import org.ncm.ncmv2.domain.model.FCCStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    NetService netService;

    @GetMapping("/")
    public String home(Model model) {

        return "home";
    }

    @GetMapping("/create")
    public String create(Model model, HttpSession session) {
        CreateNetDto netDto = new CreateNetDto();
        netDto.setOwner((FCCStation) session.getAttribute("station"));
        model.addAttribute("netDto", netDto);

//        model.addAttribute("netTypes", netService.getNetTypes());

        return "create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute CreateNetDto netDto, Model model, HttpSession session) {

        Net newNet = netService.createNewNet(netDto);

        return "redirect:/net/" + newNet.getId();
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
