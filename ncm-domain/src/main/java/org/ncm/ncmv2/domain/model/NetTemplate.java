package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "net_template")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NetTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name="net_name", nullable = false)
    private String netName;

    @ManyToOne
    @JoinColumn(name="net_type", nullable = false)
    private NetType netType;

    @Column(name="net_frequency")
    private String netFrequency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Group owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="added_by", nullable = false)
    private User addedBy;

    @CreationTimestamp
    @Column(name="created_date", nullable = false, updatable = false, columnDefinition = "timestamptz")
    private OffsetDateTime createdDate;

    @Column(name="is_deleted")
    private boolean isDeleted = false;
}
