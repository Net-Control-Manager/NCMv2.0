package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.Map;

@Entity
@Table(name = "net_poi")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NetPOI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @Column(nullable = false)
    private Net net;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "geojson", columnDefinition = "jsonb", nullable = false)
    private Map<String, Object> geojson;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "timestamptz")
    private OffsetDateTime dateAdded;

    @ManyToOne
    @Column(nullable = false)
    private User addedBy;

    private boolean isDeleted = false;
}
