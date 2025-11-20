package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "station")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String callsign;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    //TODO: Fix this datatype
    @Column(name="lat_long")
    private String latLong;
    private String city;
    private String county;
    private String district;
    private String state;
    private int zip;
    private String country;
    private String grid;
    private String w3w;

    private String email;
    private String phone;

    private String credentials;

    @CreationTimestamp
    @Column(name="date_created", nullable = false, updatable = false, columnDefinition = "timestamptz")
    private OffsetDateTime dateCreated;

}
