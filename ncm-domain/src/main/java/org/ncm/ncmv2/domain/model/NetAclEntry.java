package org.ncm.ncmv2.domain.model;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class NetAclEntry {
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Net net;

    @ManyToOne(fetch = FetchType.LAZY)
    private Station station;

    private NetAclLevel level;

}
