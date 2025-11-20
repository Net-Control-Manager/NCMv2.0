package org.ncm.ncmv2.service;

import org.ncm.ncmv2.domain.dao.NetDao;
import org.ncm.ncmv2.domain.dao.NetTimelineDao;
import org.ncm.ncmv2.domain.model.NetTimelineEntry;
import org.ncm.ncmv2.domain.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.Logger;

import java.time.OffsetDateTime;


public class TimelineService {
    @Autowired
    private NetDao netDao;

    @Autowired
    private NetTimelineDao timelineDao;

    @Autowired
    private Logger logger;

    public NetTimelineEntry addEntry(Long netId, Station actor, Station stationUpdated, String remarks) {
        NetTimelineEntry entry = NetTimelineEntry.builder()
                .net(netDao.getNetById(netId))
                .entryTime(OffsetDateTime.now())
                .actor(actor)
                .stationUpdated(stationUpdated)
                .remarks(remarks)
                .build();

        logger.debug("Timeline Entry Created.  NET ID: {}; Entry: {}", netId, entry.toString());

        return timelineDao.createTimelineEntry(entry);
    }
}
