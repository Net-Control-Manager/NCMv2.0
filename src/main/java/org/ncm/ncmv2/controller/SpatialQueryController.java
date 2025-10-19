package org.ncm.ncmv2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.ncm.ncmv2.domain.model.Station;
import org.ncm.ncmv2.domain.model.SystemPOI;
import org.ncm.ncmv2.domain.repo.StationRepository;
import org.ncm.ncmv2.domain.repo.SystemPOIRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/controller/spatial")
@RequiredArgsConstructor
@Slf4j
public class SpatialQueryController {
    private final SystemPOIRepository poiRepo;
    private final StationRepository stationRepo;
    private final ObjectMapper om;

    @GetMapping("/pois/nearby")
    public List<SystemPOI> poisNearby(@RequestParam double lat, @RequestParam double lon, @RequestParam(defaultValue = "1000") double meters) {
        return poiRepo.findWithin(lat, lon, meters);
    }

    @GetMapping("/pois/nearest")
    public List<SystemPOI> poisNearest(@RequestParam double lat, @RequestParam double lon, @RequestParam(defaultValue = "10") int limit) {
        return poiRepo.nearest(lat, lon, Math.max(1, limit));
    }

    @GetMapping("/pois/bbox")
    public List<SystemPOI> poisWithinBbox(@RequestParam double minLon, @RequestParam double minLat, @RequestParam double maxLon, @RequestParam double maxLat) {
        return poiRepo.withinBbox(minLon, minLat, maxLon, maxLat);
    }

    @PostMapping("/pois/within-polygon")
    public List<SystemPOI> poisWithinPolygon(@RequestBody Map<String, Object> feature) {
        validateFeatureWithGeometry(feature);
        return poiRepo.withinPolygon(toJson(feature.get("geometry")));
    }

    @PostMapping("/pois/along-route")
    public List<SystemPOI> poisAlongRoute(@RequestParam double meters, @RequestBody Map<String, Object> feature) {
        validateFeatureWithGeometry(feature);
        ensureLineGeometry(feature);
        return poiRepo.alongRoute(toJson(feature.get("geometry")), meters);
    }

    @GetMapping("/stations/nearby")
    public List<Station> stationsNearby(@RequestParam double lat, @RequestParam double lon, @RequestParam(defaultValue = "1000") double meters) {
        return stationRepo.findWithin(lat, lon, meters);
    }

    @GetMapping("/stations/nearest")
    public List<Station> stationsNearest(@RequestParam double lat, @RequestParam double lon, @RequestParam(defaultValue = "10") int limit) {
        return stationRepo.nearest(lat, lon, Math.max(1, limit));
    }

    @GetMapping("/stations/bbox")
    public List<Station> stationsWithinBbox(@RequestParam double minLon, @RequestParam double minLat, @RequestParam double maxLon, @RequestParam double maxLat) {
        return stationRepo.withinBbox(minLon, minLat, maxLon, maxLat);
    }

    @PostMapping("/stations/within-polygon")
    public List<Station> stationsWithinPolygon(@RequestBody Map<String, Object> feature) {
        validateFeatureWithGeometry(feature);
        return stationRepo.withinPolygon(toJson(feature.get("geometry")));
    }

    @PostMapping("/stations/along-route")
    public List<Station> stationsAlongRoute(@RequestParam double meters, @RequestBody Map<String, Object> feature) {
        validateFeatureWithGeometry(feature);
        ensureLineGeometry(feature);
        return stationRepo.alongRoute(toJson(feature.get("geometry")), meters);
    }

    private static void validateFeatureWithGeometry(Map<String, Object> feature) {
        if (!"Feature".equals(feature.get("type")))
            throw new IllegalArgumentException("Body must be a GeoJSON Feature");
        if (!(feature.get("geometry") instanceof Map<?, ?>))
            throw new IllegalArgumentException("Feature.geometry must be a GeoJSON geometry object");
    }

    private static void ensureLineGeometry(Map<String, Object> feature) {
        var g = (Map<?, ?>) feature.get("geometry");
        var t = String.valueOf(g.get("type"));
        if (!"LineString".equalsIgnoreCase(t) && !"MultiLineString".equalsIgnoreCase(t))
            throw new IllegalArgumentException("geometry.type must be LineString or MultiLineString");
    }

    @SneakyThrows
    private String toJson(Object obj) {
        return om.writeValueAsString(obj);
    }
}
