package org.ncm.ncmv2.domain.model;

public enum GroupType {
    CLUB("Club"),
    SOCIAL("Social"),
    ARES_RACES("ARES/RACES"),
    EVENT("Event"),
    SCOUTS("Scouts"),
    MARS("Mars"),
    FACILITY("Facility"),
    OTHER("Other");

    private final String name;

    GroupType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
