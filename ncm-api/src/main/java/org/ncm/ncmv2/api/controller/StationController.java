package org.ncm.ncmv2.api.controller;

import lombok.RequiredArgsConstructor;
import org.ncm.ncmv2.domain.model.Station;
import org.ncm.ncmv2.domain.repo.StationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
@RequiredArgsConstructor
public class StationController {

    private final StationRepository repo;

    @GetMapping("/nearby")
    public List<Station> nearby(@RequestParam double lat,
                                @RequestParam double lon,
                                @RequestParam(defaultValue = "10000") double meters) {
        return repo.findWithin(lat, lon, meters);
    }
}