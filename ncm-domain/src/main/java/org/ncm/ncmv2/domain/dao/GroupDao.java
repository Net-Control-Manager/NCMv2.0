package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.Group;
import org.ncm.ncmv2.domain.model.GroupClosing;
import org.ncm.ncmv2.domain.model.GroupPreamble;
import org.ncm.ncmv2.domain.model.GroupType;

import java.util.List;

public interface GroupDao {
    Group createGroup(Group group);

    Group getGroupById(Long id);
    Group getGroupByCallsign(String callsign);
    Group getGroupsOwnedByUserId(Long userId);

    Group updateGroupName(Long id, String name);
    Group updateGroupType(Long id, GroupType type);
    Group updateGroupCallsign(Long id, String callsign);
    Group updateGroupFrequency(Long id, String frequency);

    Group addGroupManager(Long id, Long userId);
    Group removeGroupManager(Long id, Long userId);

    boolean deleteGroup(Long id);

    // ====================

    GroupPreamble createGroupPreamble(GroupPreamble groupPreamble);

    GroupPreamble getGroupPreambleById(Long id);
    List<GroupPreamble> getGroupPreamblesByGroupId(Long groupId);

    GroupPreamble updateGroupPreambleName(Long id, String name);
    GroupPreamble updateGroupPreambleText(Long id, String text);

    boolean deleteGroupPreamble(Long id);

    // ====================

    GroupClosing createGroupClosing(GroupClosing groupClosing);

    GroupClosing getGroupClosingById(Long id);
    List<GroupClosing> getGroupClosingsByGroupId(Long groupId);

    GroupClosing updateGroupClosingName(Long id, String name);
    GroupClosing updateGroupClosingText(Long id, String text);

    boolean deleteGroupClosing(Long id);
}
