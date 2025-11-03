package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name="net")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Net {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    private List<NetEntry> entries;

    @OneToMany(fetch =  FetchType.LAZY)
    private List<NetTimelineEntry> timelineEntries;

    @ManyToOne
    private NetType netType;

    private OffsetDateTime startTime;
    private OffsetDateTime endTime;

    private boolean isPreBuilt;
    private OffsetDateTime preBuiltTime;

    @ManyToOne(fetch =  FetchType.LAZY)
    private Net subNetParent;

    private boolean isPublic;

    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;
}
