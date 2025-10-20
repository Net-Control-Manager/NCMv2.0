package org.ncm.ncmv2.domain.model;

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
}
