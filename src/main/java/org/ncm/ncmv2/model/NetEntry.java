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
public class NetEntry {
    private int id;
    private Station station;
    private Date checkInTime;
    private Date checkOutTime;
    private EntryRole role;
    private EntryMode mode;
    private EntryStatus status;
    private EntryTraffic traffic;

    private String team;
    private String facility;
    private String district;
    private String aprsCall;
    private String aprsTT;
    private String tactical; private String timeOnDuty;
    private String band;
    private String onSite;

    // The following properties are copied from the Station record at construction time, then persist for this net only:
    private String city;
    private String county;
    private String state;
    private String country;
    private String grid;
    private String latitude;
    private String longitude;
    private String w3w;
}
