package org.ncm.ncmv2.domain.model;

public enum NetAclLevel {
    FULL_ACCESS("Full Access"),
    EDIT_NET("Edit Net"),
    EDIT_STATIONS("Edit Stations");

    private final String text;

    NetAclLevel(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
