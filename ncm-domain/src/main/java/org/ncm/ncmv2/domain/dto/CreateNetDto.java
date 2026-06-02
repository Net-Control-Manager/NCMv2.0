package org.ncm.ncmv2.domain.dto;

import lombok.*;
import org.ncm.ncmv2.domain.model.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNetDto {
    private FCCStation owner;
    private String name;
    private boolean publicNet = true;
    private NetType netType;
    private String frequency;
    private Group group;
}
