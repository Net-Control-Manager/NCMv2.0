package org.ncm.ncmv2.domain.model;

import java.time.OffsetDateTime;

public class NetPOI {
    private long id;
    private Net net;
    private String geojson;

    private OffsetDateTime dateAdded;
    private User addedBy;

    private boolean isDeleted;
}
