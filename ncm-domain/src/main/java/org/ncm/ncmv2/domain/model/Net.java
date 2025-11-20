package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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

    @Column(nullable = false)
    private String name;

    @OneToMany
    private List<NetEntry> entries;

    @OneToMany(fetch =  FetchType.LAZY)
    @JoinColumn(name="timeline_entries")
    private List<NetTimelineEntry> timelineEntries;

    @ManyToOne
    @JoinColumn(name="net_type", nullable = false)
    private NetType netType;

    @CreationTimestamp
    @Column(name="start_time", nullable = false, columnDefinition = "timestamptz")
    private OffsetDateTime startTime;

    @Column(name="end_time", columnDefinition = "timestamptz")
    private OffsetDateTime endTime;

    @Column(name="is_prebuilt")
    private boolean isPreBuilt = false;

    @Column(name="prebuilt_time", columnDefinition = "timestamptz")
    private OffsetDateTime preBuiltTime;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="subnet_parent")
    private Net subNetParent;

    @Column(name="is_public")
    private boolean isPublic;

    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;


    // Unowned nets should default to public, but
    // owned nets should default to private.
    @PrePersist
    public void prePersist() {
        isPublic = this.owner == null;
    }
}
