package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "group_poi_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupPOIType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "bytea")
    private byte[] image;

    @ManyToOne
    @Column(nullable = false)
    private Group owner;

    @ManyToOne
    @Column(nullable = false)
    private User addedBy;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "timestamptz")
    private OffsetDateTime dateAdded;

    private boolean isDeleted = false;
}
