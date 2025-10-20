package org.ncm.ncmv2.domain.model;

public enum EntryStatus {
    IN("IN"),
    OUT("OUT"),
    INOUT("In-Out"),
    LEAVE("Leave?"),
    MOVED("Moved"),
    BRB("BRB"),
    ENROUTE("En Route"),
    ARRIVED("Arrived"),
    ASSIGNED("Assigned"),
    MISSING("MISSING");

    private final String abbreviation;

    EntryStatus(String description) {
        this.abbreviation = description;
    }

    public String getAbbrev() {
        return abbreviation;
    }
}
