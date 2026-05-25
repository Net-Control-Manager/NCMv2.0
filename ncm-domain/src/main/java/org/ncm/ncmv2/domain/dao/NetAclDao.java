package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.EntryRole;
import org.ncm.ncmv2.domain.model.NetAclEntry;
import org.ncm.ncmv2.domain.model.NetAclLevel;
import org.ncm.ncmv2.domain.model.NetRolePermission;

import java.util.List;

public interface NetAclDao {
    //TODO: Decide if we want to pass in parameters and build the object, or pass in the object pre-made.
    //TODO: I think we want to pass in parameters, because the object won't already exist until a user makes a change.
    boolean setNetRolePermissions(Long netId, EntryRole entryRole, NetAclLevel netAclLevel);
    NetRolePermission getNetRolePermission(Long netId, EntryRole entryRole);

    NetAclEntry addNetOperator(NetAclEntry netACLEntry);
    NetAclEntry updateNetOperator(Long netAclEntryId, NetAclLevel netAclLevel);
    boolean deleteNetOperator(Long netAclEntryId);

    NetAclEntry getNetAclEntryById(Long netAclEntryId);
    List<NetAclEntry> getNetAclEntriesByNetId(Long netId);
}
