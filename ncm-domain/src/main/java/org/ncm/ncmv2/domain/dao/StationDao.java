package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.LatLong;
import org.ncm.ncmv2.domain.model.Station;

public interface StationDao {


    Station getStationById(Long id);
    Station getStationByCallsign(String callsign);

    Station updateStationFirstName(Long id, String firstName);
    Station updateStationLastName(Long id, String lastName);
    Station updateStationLatLong(Long id, LatLong latLong);
    Station updateStationW3W(Long id, String w3w);
    Station updateStationEmail(Long id, String email);
    Station updateStationPhone(Long id, String phone);
    Station updateStationCredentials(Long id, String credentials);

    /**
     * This method permanently deletes a station from the database.  The station's ID and Callsign must
     * match for safety, or the call will fail.
     * @param id
     * @param callsign
     * @return
     */
    boolean permanentlyDeleteStation(Long id, String callsign);
}
