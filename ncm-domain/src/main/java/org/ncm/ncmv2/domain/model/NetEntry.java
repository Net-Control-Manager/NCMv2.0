package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.OffsetDateTime;

@Entity
@Table(name = "net_entry")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@ToString(exclude = {"net", "station"})
public class NetEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "net_id", nullable = false)
    @ToString.Exclude
    private Net net;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    @ToString.Exclude
    private Station station;
    @Column(name = "check_in_time", columnDefinition = "timestamptz")
    private OffsetDateTime checkInTime;
    @Column(name = "check_out_time", columnDefinition = "timestamptz")
    private OffsetDateTime checkOutTime;
    @Enumerated(EnumType.STRING)
    private EntryRole entryRole;
    @Enumerated(EnumType.STRING)
    private EntryMode entryMode;
    @Enumerated(EnumType.STRING)
    private EntryStatus entryStatus;
    @Enumerated(EnumType.STRING)
    private String entryTraffic;

    private String team;
    private String facility;
    private String district;
    private String aprsCall;
    private String aprsTT;
    private String tactical;
    @org.hibernate.annotations.Type(io.hypersistence.utils.hibernate.type.interval.PostgreSQLIntervalType.class)
    @Column(name = "time_on_duty", columnDefinition = "interval")
    private Duration timeOnDuty;
    private String band;
    private String onSite;

    //TODO: Fix Data Type
    private String latLong;
    private String city;
    private String county;
    private String state;
    private int zip;
    private String country;
    private String grid;
    private String w3w;

    private String email;
    private String phone;
}
