package org.ncm.ncmv2.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.locationtech.jts.geom.Geometry;

import java.time.OffsetDateTime;
import java.util.Map;

@Entity
@Table(name = "system_poi")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@ToString(exclude = {"poiType","geom"})
@ToString
public class SystemPOI {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    /** GeoJSON Feature (validated; DB trigger builds geom) */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "geojson", columnDefinition = "jsonb", nullable = false)
    private Map<String,Object> geojson;

    /** Real geometry for spatial index/queries (not returned directly). */
    @JsonIgnore
    @Column(name = "geom", columnDefinition = "geometry")
    private Geometry geom;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "poi_type_id")
    @ToString.Exclude
    private SystemPOIType poiType;

    @Builder.Default
    @Column(name = "date_added", columnDefinition = "timestamptz", nullable = false)
    private OffsetDateTime dateAdded = OffsetDateTime.now();

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;
}