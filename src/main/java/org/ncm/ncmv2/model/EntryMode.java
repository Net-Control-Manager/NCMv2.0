package org.ncm.ncmv2.model;

public enum EntryMode {
    VOICE("Voice"),
    AM("AM"),
    FM("FM"),
    SSB("SSB"),
    C4FM("C4FM"),
    PORTABLE("Port"),
    MOBILE("Mobile"),
    HT("HT"),
    CW("CW"),
    DIGITAL("Dig"),
    FT8("FT8"),
    FSQ("FSQ"),
    DSTAR("D-Star"),
    ECHOLINK("Echo"),
    DMR("DMR"),
    FUSION("Fusion"),
    WINLINK("Win"),
    VD("V&D"),
    ONLINE("Online"),
    PISTAR("Pi");

    private final String abbreviation;

    EntryMode(String description) {
        this.abbreviation = description;
    }

    public String getAbbrev() {
        return abbreviation;
    }
}
