package org.ncm.ncmv2.domain.model;

public enum EntryRole {
    PRIMARY("PRM"),
    SECOND("2nd"),
    LOGGER("Log"),
    LSN("LSN"),
    EM("EM"),
    PIO("PIO"),
    SEC("SEC"),
    RELAY("RELAY"),
    CMD("CMD"),
    TL("TL"),
    CAPTAIN("Capt");

    private final String abbreviation;

    EntryRole(String description) {
        this.abbreviation = description;
    }

    public String getAbbrev() {
        return abbreviation;
    }
}
