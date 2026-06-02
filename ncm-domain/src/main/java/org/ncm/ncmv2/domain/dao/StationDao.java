package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.LatLong;
import org.ncm.ncmv2.domain.model.FCCStation;
import org.ncm.ncmv2.domain.model.Station;
import org.ncm.ncmv2.domain.model.TransientStation;

public interface StationDao {

    // TODO:  NEED TO DEVELOP LOGIC TO GRACEFULLY HANDLE TRANSIENT STATION EXPIRATION & SUBSEQUENT CALLSIGN REUSE

    TransientStation createTransientStation(String callsign);

    <T extends Station> T getStationById(Long id);
    <T extends Station> T getStationByCallsign(String callsign);

    FCCStation updateStationFirstName(Long id, String firstName);
    FCCStation updateStationLastName(Long id, String lastName);
    FCCStation updateStationLatLong(Long id, LatLong latLong);
    FCCStation updateStationW3W(Long id, String w3w);
    FCCStation updateStationEmail(Long id, String email);
    FCCStation updateStationPhone(Long id, String phone);
    FCCStation updateStationCredentials(Long id, String credentials);

    /**
     * This method permanently deletes a station from the database.  The station's ID and Callsign must
     * match for safety, or the call will fail.
     * @param id
     * @param callsign
     * @return
     */
    boolean permanentlyDeleteStation(Long id, String callsign);
}
