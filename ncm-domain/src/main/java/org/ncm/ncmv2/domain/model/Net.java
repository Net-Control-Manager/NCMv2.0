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
    private List<NetTimelineEntry> timelineEntries;

    @ManyToOne
    @Column(nullable = false)
    private NetType netType;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "timestamptz")
    private OffsetDateTime startTime;

    @Column(columnDefinition = "timestamptz")
    private OffsetDateTime endTime;

    private boolean isPreBuilt = false;

    @Column(columnDefinition = "timestamptz")
    private OffsetDateTime preBuiltTime;

    @ManyToOne(fetch =  FetchType.LAZY)
    private Net subNetParent;

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
