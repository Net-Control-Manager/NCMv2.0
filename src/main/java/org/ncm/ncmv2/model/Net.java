package org.ncm.ncmv2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Net {
    private int id;
    private String name;
    private List<NetEntry> entries;
    private List<NetTimelineEntry> timelineEntries;
}
