package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.EntryRole;
import org.ncm.ncmv2.domain.model.NetAclEntry;
import org.ncm.ncmv2.domain.model.NetAclLevel;
import org.ncm.ncmv2.domain.model.NetRolePermission;

import java.util.List;

public class NetAclDaoImpl implements NetAclDao{
    @Override
    public boolean setNetRolePermissions(Long netId, EntryRole entryRole, NetAclLevel netAclLevel) {
        return false;
    }

    @Override
    public NetRolePermission getNetRolePermission(Long netId, EntryRole entryRole) {
        return null;
    }

    @Override
    public NetAclEntry addNetOperator(NetAclEntry netACLEntry) {
        return null;
    }

    @Override
    public NetAclEntry updateNetOperator(Long netAclEntryId, NetAclLevel netAclLevel) {
        return null;
    }

    @Override
    public boolean deleteNetOperator(Long netAclEntryId) {
        return false;
    }

    @Override
    public NetAclEntry getNetAclEntryById(Long netAclEntryId) {
        return null;
    }

    @Override
    public List<NetAclEntry> getNetAclEntriesByNetId(Long netId) {
        return List.of();
    }
}
