package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.*;

import java.time.OffsetDateTime;
import java.util.List;

public interface NetEntryDao {
    NetEntry createNetEntry(NetEntry netEntry);

    NetEntry getNetEntryById(Long netEntryId);
    List<NetEntry> getNetEntriesByNetId(Long netId);

    boolean updateRole(Long entryId, EntryRole entryRole);
    boolean updateMode(Long entryId, EntryMode entryMode);
    boolean updateStatus(Long entryId, EntryStatus entryStatus);
    boolean updateTraffic(Long entryId, EntryTraffic entryTraffic);

    boolean updateCheckInTime(Long entryId, OffsetDateTime checkinTime);
    boolean updateCheckOutTime(Long entryId, OffsetDateTime checkOutTime);

    boolean updateTeam(Long entryId, String team);
    boolean updateFacility(Long entryId, String facility);
    boolean updateDistrict(Long entryId, String district);
    boolean updateAprsCall(Long entryId, String aprsCall);
    boolean updateAprsTT(Long entryId, int aprsTT);
    boolean updateTactical(Long entryId, String tactical);
    boolean updateTimeOnDuty(Long entryId, String timeOnDuty);
    boolean updateBand(Long entryId, String band);
    boolean updateOnSite(Long entryId, String onSite);

    boolean updateLatLong(Long entryId, LatLong latLong);
    boolean updateCity(Long entryId, String city);
    boolean updateCounty(Long entryId, String county);
    boolean updateState(Long entryId, String state);
    boolean updateZip(Long entryId, int zip);
    boolean updateCountry(Long entryId, String country);
    boolean updateGrid(Long entryId, String grid);
    boolean updateW3w(Long entryId, String w3w);

    OffsetDateTime deleteNetEntryById(Long netEntryId);
}
