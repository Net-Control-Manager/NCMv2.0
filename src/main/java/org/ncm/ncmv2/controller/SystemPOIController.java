package org.ncm.ncmv2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ncm.ncmv2.domain.model.SystemPOI;
import org.ncm.ncmv2.domain.repo.SystemPOIRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/pois")
@RequiredArgsConstructor
public class SystemPOIController {

    private final SystemPOIRepository repo;

    @PostMapping
    public SystemPOI create(@RequestBody @Valid Map<String, Object> feature) {
        if (!"Feature".equals(feature.get("type")))
            throw new IllegalArgumentException("Payload must be a GeoJSON Feature");
        var poi = SystemPOI.builder().geojson(feature).build();
        return repo.save(poi);
    }
}
