package org.ncm.ncmv2.api.service;

import org.ncm.ncmv2.domain.dao.StationDao;
import org.ncm.ncmv2.domain.dto.StationLookupDto;
import org.ncm.ncmv2.domain.model.FCCStation;
import org.ncm.ncmv2.domain.model.Net;
import org.ncm.ncmv2.domain.model.Station;
import org.ncm.ncmv2.domain.model.TransientStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService<T extends Station> {

    @Autowired
    StationDao stationDao;

    /**
     * This function provides a standardized method to check if a "real" station
     * already exists in the database for a given callsign, and if not, generates
     * a transient station based on the provided callsign.
     *<p>
     * Also contains logic to dynamically assign NONFCC callsigns to stations in the event
     * that multiple NONFCC stations are in a single net together.
     *
     * @param lookupDto
     * @return
     */
    public Station lookupOrCreateStation(StationLookupDto lookupDto) {
        T lookupStation = stationDao.getStationByCallsign(lookupDto.getCallsign());

        Station station = null;
        Net transientStationNet = null;

        // If station is FCC station, return it.
        if (lookupStation instanceof FCCStation) {
            return (Station) lookupStation;

        // If station is a transient station, run some checks to handle duplicate transient callsigns gracefully
        } else if (lookupStation instanceof TransientStation) {
            station = (Station) lookupStation;
            transientStationNet = ((TransientStation) lookupStation).getHomeNet();

        // Or, if Lookup Station is null, we need to create a brand-new transient station.
        } else if (lookupStation == null) {

        }

        return null;
    }
}
