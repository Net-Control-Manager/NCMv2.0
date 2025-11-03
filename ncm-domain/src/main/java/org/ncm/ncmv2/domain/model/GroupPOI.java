package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.Map;

@Entity
@Table(name = "group_poi")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupPOI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "geojson", columnDefinition = "jsonb", nullable = false)
    private Map<String, Object> geojson;

    @ManyToOne
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GroupPOIType poiType;

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
