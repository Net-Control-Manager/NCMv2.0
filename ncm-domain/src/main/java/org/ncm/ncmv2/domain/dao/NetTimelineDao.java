package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.NetTimelineEntry;

import java.util.List;

public interface NetTimelineDao {
    NetTimelineEntry createTimelineEntry(NetTimelineEntry netTimelineEntry);

    NetTimelineEntry getTimelineEntryById(Long id);
    List<NetTimelineEntry> getTimelineEntriesByNetId(Long netId);

    // STOP: By NCM design, timeline entries are considered immutable once created.
    //       Functions that allow updating or deleting timeline entries would be a violation
    //       of this design principle.
}
