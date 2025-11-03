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

        List<NetTimelineEntry> timelineEntries = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            NetEntry netEntry = NetEntry.builder()
                    .id(Long.valueOf(1000))
                    .station(
                            Station.builder()
                                    .id(Long.valueOf(random.nextInt()))
                                    .callsign("KF0JQH")
                                    .firstName("Kevin")
                                    .lastName("McMilian")
                                    .build())
                    .checkInTime(OffsetDateTime.now())
                    .checkOutTime(OffsetDateTime.now())
                    .entryRole(EntryRole.PRIMARY)
                    .entryMode(EntryMode.VOICE)
                    .entryStatus(EntryStatus.IN)
                    .entryTraffic(EntryTraffic.TRAFFIC.getAbbrev())
                    .build();

            entries.add(netEntry);
        }

        Net net = new Net();
        net.setId(Long.valueOf(10000));
        net.setName("NCM Development Chat (2025-11-02 @ 13:42 CDT)");
        net.setEntries(entries);


        for (int i = 0; i < 20; i++) {
            timelineEntries.add(
                    NetTimelineEntry.builder()
                            .id(Long.valueOf(random.nextInt()))
                            .net(net)
                            .entryTime(OffsetDateTime.now())
                            .actor(Station.builder()
                                    .id(Long.valueOf(random.nextInt()))
                                    .callsign("ACT0R")
                                    .firstName(RandomStringUtils.randomAlphanumeric(6))
                                    .lastName("the Actor")
                                    .build())
                            .stationUpdated(Station.builder()
                                    .id(Long.valueOf(random.nextInt()))
                                    .callsign("UP0AT3D")
                                    .firstName(RandomStringUtils.randomAlphanumeric(6))
                                    .lastName("the Updated")
                                    .build())
                            .remarks(RandomStringUtils.randomAlphanumeric(30))
                            .build()
            );
        }

        net.setTimelineEntries(timelineEntries);

        if (id.equals(Long.valueOf(10000)))
            return net;

        return null;
    }
}
