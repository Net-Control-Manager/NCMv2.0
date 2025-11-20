package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "net_id")
    private Net net;

    @CreationTimestamp
    @Column(name = "entry_time", nullable = false, updatable = false, columnDefinition = "timestamptz")
    private OffsetDateTime entryTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id", nullable = false)
    private Station actor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stationUpdated_Id")
    private Station stationUpdated;

    @Column(nullable = false)
    private String remarks;
}
