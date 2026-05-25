package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.NetTimelineEntry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("netTimelineDao")
public class NetTimelineDaoImpl implements NetTimelineDao {
    @Override
    public NetTimelineEntry createTimelineEntry(NetTimelineEntry netTimelineEntry) {
        return null;
    }

    @Override
    public NetTimelineEntry getTimelineEntryById(Long id) {
        return null;
    }

    @Override
    public List<NetTimelineEntry> getTimelineEntriesByNetId(Long netId) {
        return List.of();
    }
}
