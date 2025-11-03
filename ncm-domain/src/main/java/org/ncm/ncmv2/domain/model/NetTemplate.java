package org.ncm.ncmv2.domain.model;

public class NetTemplate {
    private long id;
    private String name;
    private String netName;
    private NetType netType;
    private String netFrequency;

    private Group owner;
    private User addedBy;

    private boolean isDeleted;
}
