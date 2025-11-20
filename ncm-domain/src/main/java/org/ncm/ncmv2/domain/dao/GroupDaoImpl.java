package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.Group;
import org.ncm.ncmv2.domain.model.GroupClosing;
import org.ncm.ncmv2.domain.model.GroupPreamble;
import org.ncm.ncmv2.domain.model.GroupType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("groupDao")
public class GroupDaoImpl implements GroupDao {
    @Override
    public Group createGroup(Group group) {
        return null;
    }

    @Override
    public Group getGroupById(Long id) {
        return null;
    }

    @Override
    public Group getGroupByCallsign(String callsign) {
        return null;
    }

    @Override
    public Group getGroupsOwnedByUserId(Long userId) {
        return null;
    }

    @Override
    public Group updateGroupName(Long id, String name) {
        return null;
    }

    @Override
    public Group updateGroupType(Long id, GroupType type) {
        return null;
    }

    @Override
    public Group updateGroupCallsign(Long id, String callsign) {
        return null;
    }

    @Override
    public Group updateGroupFrequency(Long id, String frequency) {
        return null;
    }

    @Override
    public Group addGroupManager(Long id, Long userId) {
        return null;
    }

    @Override
    public Group removeGroupManager(Long id, Long userId) {
        return null;
    }

    @Override
    public boolean deleteGroup(Long id) {
        return false;
    }

    @Override
    public GroupPreamble createGroupPreamble(GroupPreamble groupPreamble) {
        return null;
    }

    @Override
    public GroupPreamble getGroupPreambleById(Long id) {
        return null;
    }

    @Override
    public List<GroupPreamble> getGroupPreamblesByGroupId(Long groupId) {
        return List.of();
    }

    @Override
    public GroupPreamble updateGroupPreambleName(Long id, String name) {
        return null;
    }

    @Override
    public GroupPreamble updateGroupPreambleText(Long id, String text) {
        return null;
    }

    @Override
    public boolean deleteGroupPreamble(Long id) {
        return false;
    }

    @Override
    public GroupClosing createGroupClosing(GroupClosing groupClosing) {
        return null;
    }

    @Override
    public GroupClosing getGroupClosingById(Long id) {
        return null;
    }

    @Override
    public List<GroupClosing> getGroupClosingsByGroupId(Long groupId) {
        return List.of();
    }

    @Override
    public GroupClosing updateGroupClosingName(Long id, String name) {
        return null;
    }

    @Override
    public GroupClosing updateGroupClosingText(Long id, String text) {
        return null;
    }

    @Override
    public boolean deleteGroupClosing(Long id) {
        return false;
    }
}
