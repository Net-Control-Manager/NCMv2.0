package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.GroupPOI;
import org.ncm.ncmv2.domain.model.GroupPOIType;
import org.ncm.ncmv2.domain.model.NetPOI;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("poiDao")
public class PoiDaoImpl implements PoiDao {
    @Override
    public NetPOI createNetPOI(NetPOI netPOI) {
        return null;
    }

    @Override
    public NetPOI getNetPOIById(Long id) {
        return null;
    }

    @Override
    public List<NetPOI> getNetPOIsByNetId(Long netId) {
        return List.of();
    }

    @Override
    public boolean updateNetPOIGeoJson(Long id, String geoJson) {
        return false;
    }

    @Override
    public boolean deleteNetPOI(Long id) {
        return false;
    }

    @Override
    public GroupPOI createGroupPOI(GroupPOI groupPOI) {
        return null;
    }

    @Override
    public GroupPOI getGroupPOIById(Long id) {
        return null;
    }

    @Override
    public List<GroupPOI> getGroupPOIsByGroupId(Long groupId) {
        return List.of();
    }

    @Override
    public boolean updateGroupPOIGeoJson(Long id, String geoJson) {
        return false;
    }

    @Override
    public boolean updateGroupPOIType(Long id, GroupPOIType groupPOIType) {
        return false;
    }

    @Override
    public boolean deleteGroupPOI(Long id) {
        return false;
    }

    @Override
    public GroupPOIType createGroupPOIType(GroupPOIType groupPOIType) {
        return null;
    }

    @Override
    public GroupPOIType getGroupPOITypeById(Long id) {
        return null;
    }

    @Override
    public List<GroupPOIType> getGroupPOITypesByGroupId(Long groupId) {
        return List.of();
    }

    @Override
    public boolean updateGroupPOITypeName(Long id, String name) {
        return false;
    }

    @Override
    public boolean updateGroupPOITypeImage(Long id, String image) {
        return false;
    }

    @Override
    public boolean deleteGroupPOIType(Long id) {
        return false;
    }
}
