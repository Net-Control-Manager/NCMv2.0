package org.ncm.ncmv2.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class LatLong {
    private double latitude;
    private double longitude;

    @Override
    public String toString() {
        return latitude + ", " + longitude;
    }
}
