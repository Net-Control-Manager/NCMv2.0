package org.ncm.ncmv2.domain.model;

import java.util.List;

public class Group {
    private long id;
    private String name;
    private GroupType type;
    private String callsign;
    private String defaultFrequency;
    private List<User> groupManagers;
}
