package org.ncm.ncmv2.domain.dto;

import lombok.*;
import org.ncm.ncmv2.domain.model.Net;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StationLookupDto {
    private String callsign;
    private String name;
    private Net net; // used for looking up net-specific transient stations
}
