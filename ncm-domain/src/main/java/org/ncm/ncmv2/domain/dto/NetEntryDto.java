package org.ncm.ncmv2.domain.dto;

import lombok.*;
import org.ncm.ncmv2.domain.model.Net;
import org.ncm.ncmv2.domain.model.FCCStation;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NetEntryDto {
    private Net net;
    private String callsign;
    private String name;
    private String traffic;
    private FCCStation actor;
}
