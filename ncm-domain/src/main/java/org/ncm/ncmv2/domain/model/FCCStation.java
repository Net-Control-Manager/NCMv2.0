package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.OffsetDateTime;

@Entity
@Table(name = "fcc_station")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FCCStation extends Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
