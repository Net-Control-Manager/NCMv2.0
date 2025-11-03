package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

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
}
