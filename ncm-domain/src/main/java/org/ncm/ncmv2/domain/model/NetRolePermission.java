package org.ncm.ncmv2.domain.model;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class NetRolePermission {
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Net net;

    private EntryRole role;

    private NetAclLevel level;

}
