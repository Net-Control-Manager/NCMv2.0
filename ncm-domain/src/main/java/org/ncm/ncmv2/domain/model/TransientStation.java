package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transient_station")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransientStation extends Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Since Transient Stations are typically created by a net (eg: NONFCC stations),
     * homeNet allows a Transient Station to be optionally tied to a net so it is garbage-collected
     * when the net closes.
     * <p>
     * This has no impact on Transient Stations that are created from the login page, which are persisted by HTTP
     * session.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_net", nullable = true)
    @ToString.Exclude
    private Net homeNet;
}
