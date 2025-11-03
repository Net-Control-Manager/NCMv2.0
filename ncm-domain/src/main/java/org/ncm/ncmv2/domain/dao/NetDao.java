package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.Net;
import org.ncm.ncmv2.domain.model.NetEntry;
import org.ncm.ncmv2.domain.model.NetType;
import org.ncm.ncmv2.domain.model.User;

import java.time.OffsetDateTime;
import java.util.List;

public interface NetDao {
    Net createNet(Net net);
    OffsetDateTime closeNet(Long netId);
    OffsetDateTime reopenNet(Long netId);

    Net getNetById(Long id);
    List<Net> getNetsByOwnerId(Long ownerId);
    List<Net> getNetsByOpenStatus(boolean isOpen);

    boolean updateNetName(Long netId, String newName);
    boolean updateNetType(Long netId, NetType newType);
    boolean updatePublicStatus(Long netId, boolean isPublic);
    boolean setAnnouncement(Long netId, String announcement);

    boolean convertToPreBuilt(Long netId, boolean isPreBuilt);

    OffsetDateTime archiveNet(Long netId);
}
