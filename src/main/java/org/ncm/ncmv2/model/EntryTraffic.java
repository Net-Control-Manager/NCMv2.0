package org.ncm.ncmv2.model;

public enum EntryTraffic {
    TRAFFIC("Traffic"),
    ROUTINE("Routine"),
    WELFARE("Welfare"),
    PRIORITY("Priority"),
    EMERGENCY("Emergency"),
    QUESTION("Question"),
    ANNOUCNEMENT("Announcement"),
    BULLETIN("Bulletin"),
    COMMENT("Comment"),
    STANDBY("Standby"),
    REQUEST("Request"),
    RESOLVED("Resolved"),
    IMAGE("Image"),
    SENT("Sent");

    private final String abbreviation;

    EntryTraffic(String description) {
        this.abbreviation = description;
    }

    public String getAbbrev() {
        return abbreviation;
    }
}
