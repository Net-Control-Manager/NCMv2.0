package org.ncm.ncmv2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Station {
    private int id;
    private String callsign;
    private String firstName;
    private String lastName;
}
