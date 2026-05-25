package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.LatLong;
import org.ncm.ncmv2.domain.model.Station;
import org.springframework.stereotype.Repository;

@Repository("stationDao")
public class StationDaoImpl implements StationDao {
    @Override
    public Station getStationById(Long id) {
        return null;
    }

    @Override
    public Station getStationByCallsign(String callsign) {
        return null;
    }

    @Override
    public Station updateStationFirstName(Long id, String firstName) {
        return null;
    }

    @Override
    public Station updateStationLastName(Long id, String lastName) {
        return null;
    }

    @Override
    public Station updateStationLatLong(Long id, LatLong latLong) {
        return null;
    }

    @Override
    public Station updateStationW3W(Long id, String w3w) {
        return null;
    }

    @Override
    public Station updateStationEmail(Long id, String email) {
        return null;
    }

    @Override
    public Station updateStationPhone(Long id, String phone) {
        return null;
    }

    @Override
    public Station updateStationCredentials(Long id, String credentials) {
        return null;
    }

    @Override
    public boolean permanentlyDeleteStation(Long id, String callsign) {
        return false;
    }
}
