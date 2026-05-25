package org.ncm.ncmv2.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ncm.ncmv2.domain.dao.NetDao;

@Controller
@RequestMapping("/net")
public class DashboardController {

    @Autowired
    NetDao netDao;

    @GetMapping({"", "/", "/{netId}"})
    public String dashboard(Model model, @PathVariable(required = false) Integer netId) {

        System.out.println(netId);

        if (netId != null) {
            model.addAttribute("net", netDao.getNetById(Long.valueOf(netId)));
        } else
            model.addAttribute("net", null);

        model.addAttribute("variable", "This is Net Control Manager Version 2.0!");

        return "dashboard";
    }

    @GetMapping("/{netId}/loadFragment/{fragment}")
    public String loadFragment(Model model, @PathVariable Integer netId, @PathVariable String fragment) {
        switch (fragment) {
            case "stations":
            case "timeline":
            case "map":
            case "weather":
            case "netInfo":
                if (netId != null) {
                    model.addAttribute("net", netDao.getNetById(Long.valueOf(netId)));
                } else
                    model.addAttribute("net", null);

                return "fragments/dashboard/" + fragment + " :: " + fragment;

            default:
                return null;
        }
    }

    @GetMapping("/{netId}/loadModal/{modal}")
    public String loadModal(Model model, @PathVariable Integer netId, @PathVariable String modal) {
        switch (modal) {
            case "editNet":
            case "announce":
            case "netOperators":
            case "reports":
            case "closeNet":
                if (netId != null) {
                    model.addAttribute("net", netDao.getNetById(Long.valueOf(netId)));
                } else
                    model.addAttribute("net", null);

                return "fragments/dashboard/" + modal + "Modal :: " + modal + "Modal";

            default:
                return null;
        }
    }
}
