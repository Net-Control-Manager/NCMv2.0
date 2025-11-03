package org.ncm.ncmv2.domain.model;

import java.time.OffsetDateTime;

public class GroupPOI {
    private long id;
    private String geojson;
    private GroupPOIType poiType;

    private Group owner;
    private User addedBy;
    private OffsetDateTime dateAdded;

    private boolean isDeleted;
}
