package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.GroupPOI;
import org.ncm.ncmv2.domain.model.GroupPOIType;
import org.ncm.ncmv2.domain.model.NetPOI;

import java.util.List;

public interface PoiDao {
    NetPOI createNetPOI(NetPOI netPOI);

    NetPOI getNetPOIById(Long id);
    List<NetPOI> getNetPOIsByNetId(Long netId);

    boolean updateNetPOIGeoJson(Long id, String geoJson);

    boolean deleteNetPOI(Long id);

    // =======

    GroupPOI createGroupPOI(GroupPOI groupPOI);

    GroupPOI getGroupPOIById(Long id);
    List<GroupPOI> getGroupPOIsByGroupId(Long groupId);

    boolean updateGroupPOIGeoJson(Long id, String geoJson);
    boolean updateGroupPOIType(Long id, GroupPOIType groupPOIType);

    boolean deleteGroupPOI(Long id);


    // =======

    GroupPOIType createGroupPOIType(GroupPOIType groupPOIType);

    GroupPOIType getGroupPOITypeById(Long id);
    List<GroupPOIType> getGroupPOITypesByGroupId(Long groupId);

    boolean updateGroupPOITypeName(Long id, String name);
    boolean updateGroupPOITypeImage(Long id, String image);

    boolean deleteGroupPOIType(Long id);
}
