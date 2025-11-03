package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

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
    private String firstName;
    private String lastName;

    //TODO: Fix this datatype
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
    private OffsetDateTime dateCreated;

}
