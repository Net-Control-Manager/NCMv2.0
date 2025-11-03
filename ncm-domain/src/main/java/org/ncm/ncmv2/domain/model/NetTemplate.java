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

    @Column(nullable = false)
    private String netName;

    @ManyToOne
    @Column(nullable = false)
    private NetType netType;

    private String netFrequency;

    @ManyToOne
    @Column(nullable = false)
    private Group owner;

    @ManyToOne
    @Column(nullable = false)
    private User addedBy;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "timestamptz")
    private OffsetDateTime createdDate;

    private boolean isDeleted = false;
}
