package org.ncm.ncmv2.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.ncm.ncmv2.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
            net.setTimelineEntries(Timelines.generateRandomTimelineEntries(net.getId()));

            return net;
        }
    }

    public class Timelines {
        public static List<NetTimelineEntry> generateRandomTimelineEntries(int netId) {
            List<NetTimelineEntry> entries = new ArrayList<>();
            Random random = new Random();

            for (int i = 0; i < 20; i++) {
                entries.add(
                        new NetTimelineEntry(
                                random.nextInt(),
                                new Date(),
                                new Station(random.nextInt(), "ACT0R", RandomStringUtils.randomAlphanumeric(6), "the Actor"),
                                new Station(random.nextInt(), "UP0AT3D", RandomStringUtils.randomAlphanumeric(6), "the Updated"),
                                RandomStringUtils.randomAlphanumeric(30)

                        )
                );
            }

            return entries;
        }
    }
}
