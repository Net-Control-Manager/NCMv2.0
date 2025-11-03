package org.ncm.ncmv2.domain.model;

import java.time.OffsetDateTime;

public class GroupPOIType {
    private long id;
    private String name;
    private byte[] image;

    private Group owner;
    private User addedBy;
    private OffsetDateTime dateAdded;
    private boolean isDeleted;
}
