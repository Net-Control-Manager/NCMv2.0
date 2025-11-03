package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.Map;

@Entity
@Table(name = "weather_alert")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WeatherAlertType type;

    @Column(columnDefinition = "timestamptz", nullable = false)
    private OffsetDateTime effectiveTime;

    @Column(columnDefinition = "timestamptz", nullable = false)
    private OffsetDateTime expiryTime;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "alertPolygon", columnDefinition = "jsonb", nullable = false)
    private Map<String, Object> alertPolygon;
}
