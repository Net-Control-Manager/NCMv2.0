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
    @JoinColumn(name="poi_type", nullable = false)
    private GroupPOIType poiType;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Group owner;

    @ManyToOne
    @JoinColumn(name="added_by", nullable = false)
    private User addedBy;

    @CreationTimestamp
    @Column(name="date_added", nullable = false, updatable = false, columnDefinition = "timestamptz")
    private OffsetDateTime dateAdded;

    @Column(name="is_deleted")
    private boolean isDeleted = false;
}
