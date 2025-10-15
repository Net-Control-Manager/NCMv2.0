package org.ncm.ncmv2.util;

import org.ncm.ncmv2.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SampleData {
    public class Nets {
        public static Net BasicNet() {
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

            return net;
        }
    }
}
