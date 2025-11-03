package org.ncm.ncmv2.domain.dao;


import org.apache.commons.lang3.RandomStringUtils;
import org.ncm.ncmv2.domain.model.*;

import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository("netDao")
public class NetDaoImpl implements NetDao {
    @Override
    public Net createNet(Net net) {
        return null;
    }

    @Override
    public OffsetDateTime closeNet(Long netId) {
        return null;
    }

    @Override
    public OffsetDateTime reopenNet(Long netId) {
        return null;
    }

    @Override
    public Net getNetById(Long id) {
        return getSampleNet(id); //TODO: THIS IS SAMPLE DATA
    }

    @Override
    public List<Net> getNetsByOwnerId(Long ownerId) {
        return List.of();
    }

    @Override
    public List<Net> getNetsByOpenStatus(boolean isOpen) {
        return List.of();
    }

    @Override
    public boolean updateNetName(Long netId, String newName) {
        return false;
    }

    @Override
    public boolean updateNetType(Long netId, NetType newType) {
        return false;
    }

    @Override
    public boolean updatePublicStatus(Long netId, boolean isPublic) {
        return false;
    }

    @Override
    public boolean setAnnouncement(Long netId, String announcement) {
        return false;
    }

    @Override
    public boolean convertToPreBuilt(Long netId, boolean isPreBuilt) {
        return false;
    }

    @Override
    public OffsetDateTime archiveNet(Long netId) {
        return null;
    }




    // TODO:  THIS IS A TEST FUNCTION FOR UI TESTING
    private Net getSampleNet(Long id) {
        //TODO:  THIS IS SAMPLE DATA FOR UI TESTING
        List<NetEntry> entries = new ArrayList<NetEntry>();

        for (int i = 0; i < 10; i++) {
            NetEntry netEntry = new NetEntry();
            netEntry.setId(Long.valueOf(1000));
            netEntry.setStation(new Station(Long.valueOf(10000), "KF0JQH", "Kevin", "McMilian"));
            netEntry.setCheckInTime(OffsetDateTime.now());
            netEntry.setCheckOutTime(OffsetDateTime.now());
            netEntry.setEntryRole(EntryRole.PRIMARY);
            netEntry.setEntryMode(EntryMode.VOICE);
            netEntry.setEntryStatus(EntryStatus.IN);
            netEntry.setEntryTraffic(EntryTraffic.TRAFFIC.getAbbrev());

            entries.add(netEntry);
        }

        Net net = new Net();
        net.setId(Long.valueOf(10000));
        net.setName("NCM Development Chat (2025-11-02 @ 13:42 CDT)");
        net.setEntries(entries);

        List<NetTimelineEntry> timelineEntries = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            timelineEntries.add(
                    new NetTimelineEntry(
                            Long.valueOf(random.nextInt()),
                            net,
                            OffsetDateTime.now(),
                            new Station(Long.valueOf(random.nextInt()), "ACT0R", RandomStringUtils.randomAlphanumeric(6), "the Actor"),
                            new Station(Long.valueOf(random.nextInt()), "UP0AT3D", RandomStringUtils.randomAlphanumeric(6), "the Updated"),
                            RandomStringUtils.randomAlphanumeric(30)

                    )
            );
        }

        net.setTimelineEntries(timelineEntries);

        if (id.equals(Long.valueOf(10000)))
            return net;

        return null;
    }
}
