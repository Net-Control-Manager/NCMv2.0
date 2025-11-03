package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.NetTimelineEntry;

import java.util.List;

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
