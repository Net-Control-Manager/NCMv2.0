package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.NetTemplate;
import org.ncm.ncmv2.domain.model.NetType;

public interface NetTemplateDao {
    NetTemplate createNetTemplate(NetTemplate netTemplate);

    NetTemplate getNetTemplateById(Long id);

    NetTemplate updateNetTemplateName(Long id, String name);
    NetTemplate updateNetTemplateNetName(Long id, String netName);
    NetTemplate updateNetTemplateType(Long id, NetType type);
    NetTemplate updateNetTemplateFrequency(Long id, String frequency);

    boolean deleteNetTemplate(Long id);
}
