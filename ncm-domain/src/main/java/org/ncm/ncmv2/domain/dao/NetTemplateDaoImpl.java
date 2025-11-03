package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.NetTemplate;
import org.ncm.ncmv2.domain.model.NetType;
import org.springframework.stereotype.Repository;

@Repository("netTemplateDao")
public class NetTemplateDaoImpl implements NetTemplateDao {
    @Override
    public NetTemplate createNetTemplate(NetTemplate netTemplate) {
        return null;
    }

    @Override
    public NetTemplate getNetTemplateById(Long id) {
        return null;
    }

    @Override
    public NetTemplate updateNetTemplateName(Long id, String name) {
        return null;
    }

    @Override
    public NetTemplate updateNetTemplateNetName(Long id, String netName) {
        return null;
    }

    @Override
    public NetTemplate updateNetTemplateType(Long id, NetType type) {
        return null;
    }

    @Override
    public NetTemplate updateNetTemplateFrequency(Long id, String frequency) {
        return null;
    }

    @Override
    public boolean deleteNetTemplate(Long id) {
        return false;
    }
}
