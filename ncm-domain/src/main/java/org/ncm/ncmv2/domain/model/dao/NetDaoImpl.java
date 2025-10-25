package org.ncm.ncmv2.domain.model.dao;


import org.apache.commons.lang3.RandomStringUtils;
import org.ncm.ncmv2.domain.model.*;

import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Repository
public class NetDaoImpl implements NetDao {
    @Override
    public Net getNetById(int id) {
        //TODO:  THIS IS SAMPLE DATA FOR UI TESTING
        List<NetEntry> entries = new ArrayList<NetEntry>();

        for (int i = 0; i < 10; i++) {
            NetEntry netEntry = new NetEntry();
            netEntry.setId(Long.valueOf(1000));
            netEntry.setStation(new Station(10000, "KF0JQH", "Kevin", "McMilian"));
            netEntry.setCheckInTime(OffsetDateTime.now());
            netEntry.setCheckOutTime(OffsetDateTime.now());
            netEntry.setEntryRole(EntryRole.PRIMARY);
            netEntry.setEntryMode(EntryMode.VOICE);
            netEntry.setEntryStatus(EntryStatus.IN);
            netEntry.setEntryTraffic(EntryTraffic.TRAFFIC.getAbbrev());

            entries.add(netEntry);
        }

        Net net = new Net();
        net.setId(10000);
        net.setName("NCM Development Chat (2025-10-03 @ 13:42 CDT)");
        net.setEntries(entries);

        List<NetTimelineEntry> timelineEntries = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            timelineEntries.add(
                    new NetTimelineEntry(
                            random.nextInt(),
                            new Date(),
                            new Station(random.nextInt(), "ACT0R", RandomStringUtils.randomAlphanumeric(6), "the Actor"),
                            new Station(random.nextInt(), "UP0AT3D", RandomStringUtils.randomAlphanumeric(6), "the Updated"),
                            RandomStringUtils.randomAlphanumeric(30)

                    )
            );
        }

        net.setTimelineEntries(timelineEntries);

        if (id == 10000)
            return net;

        return null;
    }
}
