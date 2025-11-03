package org.ncm.ncmv2.domain.model;

import java.time.OffsetDateTime;

public class GroupPreamble {
    private long id;
    private String name;
    private String text;

    private Group owner;
    private User addedBy;
    private OffsetDateTime dateAdded;

    private boolean isDeleted;
}
