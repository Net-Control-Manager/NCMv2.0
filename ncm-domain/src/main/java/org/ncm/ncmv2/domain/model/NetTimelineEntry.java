package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NetTimelineEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "entry_time", columnDefinition = "timestamptz")
    private OffsetDateTime entryTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id")
    private Station actor;
    @ManyToOne
    @JoinColumn(name = "stationUpdated_Id")
    private Station stationUpdated;
    private String remarks;
}
