package org.ncm.ncmv2.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

import java.time.OffsetDateTime;

@Entity
@Table(name = "station")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Station {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String callsign;
    private String grid;
    private String email;
    private String firstName;
    private String lastName;

    @JsonIgnore
    @Column(name = "lat_long", columnDefinition = "geography(Point,4326)")
    private Point latLong;

    @Builder.Default
    @Column(name = "date_created", columnDefinition = "timestamptz", nullable = false)
    private OffsetDateTime dateCreated = OffsetDateTime.now();
}