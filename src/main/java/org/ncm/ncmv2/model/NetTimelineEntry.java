package org.ncm.ncmv2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NetTimelineEntry {
    private int id;
    private Date entryTime;
    private Station actor;
    private Station stationUpdated;
    private String remarks;
}
