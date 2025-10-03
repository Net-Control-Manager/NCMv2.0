package org.ncm.ncmv2.controller;

import org.ncm.ncmv2.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class DashboardController {

    @GetMapping
    public String dashboard(Model model) throws InterruptedException {

        // BUILD SAMPLE DATA FOR MOCKUPS
        List<NetEntry> entries = new ArrayList<NetEntry>();

        for (int i = 0; i < 10; i++) {
            NetEntry netEntry = new NetEntry();
            netEntry.setId(1000);
            netEntry.setStation(new Station(10000, "KF0JQH", "Kevin", "McMilian"));
            netEntry.setCheckInTime(new Date());
            netEntry.setCheckOutTime(new Date());
            netEntry.setRole(EntryRole.PRIMARY);
            netEntry.setMode(EntryMode.VOICE);
            netEntry.setStatus(EntryStatus.IN);
            netEntry.setTraffic(EntryTraffic.TRAFFIC);

            entries.add(netEntry);
        }

        Net net = new Net();
        net.setId(10000);
        net.setName("NCM Development Chat (2025-10-03 @ 13:42 CDT)");
        net.setEntries(entries);

        model.addAttribute(net);
        model.addAttribute("variable", "This is Net Control Manager Version 2.0!");

        return "dashboard";
    }
}
