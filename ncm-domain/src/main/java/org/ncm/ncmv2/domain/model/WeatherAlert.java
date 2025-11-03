package org.ncm.ncmv2.domain.model;

import java.time.OffsetDateTime;

public class WeatherAlert {
    private long id;
    private WeatherAlertType type;
    private OffsetDateTime effectiveTime;
    private OffsetDateTime expiryTime;
    private String alertPolygon;
}
