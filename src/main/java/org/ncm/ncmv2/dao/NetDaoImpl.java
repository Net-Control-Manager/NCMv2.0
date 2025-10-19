package org.ncm.ncmv2.dao;

import org.ncm.ncmv2.domain.model.Net;
import org.ncm.ncmv2.util.SampleData;
import org.springframework.stereotype.Repository;

@Repository
public class NetDaoImpl implements NetDao {
    @Override
    public Net getNetById(int id) {
        //TODO:  THIS IS SAMPLE DATA FOR UI TESTING
//        Net net = SampleData.Nets.BasicNet();
//
//        if (id == 10000)
//            return net;

        return null;
    }
}
