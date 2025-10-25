package org.ncm.ncmv2.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.SqlTypes;
import org.locationtech.jts.geom.Geometry;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "system_poi")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class SystemPOI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "geojson", columnDefinition = "jsonb", nullable = false)
    private Map<String, Object> geojson;
    @JsonIgnore
    @Column(name = "geom", columnDefinition = "geometry")
    private Geometry geom;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poi_type_id")
    @ToString.Exclude
    private SystemPOIType poiType;
    @Builder.Default
    @Column(name = "date_added", columnDefinition = "timestamptz", nullable = false)
    private OffsetDateTime dateAdded = OffsetDateTime.now();
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        SystemPOI systemPOI = (SystemPOI) o;
        return getId() != null && Objects.equals(getId(), systemPOI.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
