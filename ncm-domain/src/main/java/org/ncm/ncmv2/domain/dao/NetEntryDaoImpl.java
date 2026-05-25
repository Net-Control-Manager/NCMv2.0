package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.*;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository("netEntryDao")
public class NetEntryDaoImpl implements NetEntryDao {
    @Override
    public NetEntry createNetEntry(NetEntry netEntry) {
        return null;
    }

    @Override
    public NetEntry getNetEntryById(Long netEntryId) {
        return null;
    }

    @Override
    public List<NetEntry> getNetEntriesByNetId(Long netId) {
        return List.of();
    }

    @Override
    public boolean updateRole(Long entryId, EntryRole entryRole) {
        return false;
    }

    @Override
    public boolean updateMode(Long entryId, EntryMode entryMode) {
        return false;
    }

    @Override
    public boolean updateStatus(Long entryId, EntryStatus entryStatus) {
        return false;
    }

    @Override
    public boolean updateTraffic(Long entryId, EntryTraffic entryTraffic) {
        return false;
    }

    @Override
    public boolean updateCheckInTime(Long entryId, OffsetDateTime checkinTime) {
        return false;
    }

    @Override
    public boolean updateCheckOutTime(Long entryId, OffsetDateTime checkOutTime) {
        return false;
    }

    @Override
    public boolean updateTeam(Long entryId, String team) {
        return false;
    }

    @Override
    public boolean updateFacility(Long entryId, String facility) {
        return false;
    }

    @Override
    public boolean updateDistrict(Long entryId, String district) {
        return false;
    }

    @Override
    public boolean updateAprsCall(Long entryId, String aprsCall) {
        return false;
    }

    @Override
    public boolean updateAprsTT(Long entryId, int aprsTT) {
        return false;
    }

    @Override
    public boolean updateTactical(Long entryId, String tactical) {
        return false;
    }

    @Override
    public boolean updateTimeOnDuty(Long entryId, String timeOnDuty) {
        return false;
    }

    @Override
    public boolean updateBand(Long entryId, String band) {
        return false;
    }

    @Override
    public boolean updateOnSite(Long entryId, String onSite) {
        return false;
    }

    @Override
    public boolean updateLatLong(Long entryId, LatLong latLong) {
        return false;
    }

    @Override
    public boolean updateCity(Long entryId, String city) {
        return false;
    }

    @Override
    public boolean updateCounty(Long entryId, String county) {
        return false;
    }

    @Override
    public boolean updateState(Long entryId, String state) {
        return false;
    }

    @Override
    public boolean updateZip(Long entryId, int zip) {
        return false;
    }

    @Override
    public boolean updateCountry(Long entryId, String country) {
        return false;
    }

    @Override
    public boolean updateGrid(Long entryId, String grid) {
        return false;
    }

    @Override
    public boolean updateW3w(Long entryId, String w3w) {
        return false;
    }

    @Override
    public OffsetDateTime deleteNetEntryById(Long netEntryId) {
        return null;
    }
}
