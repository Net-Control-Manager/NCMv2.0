package org.ncm.ncmv2.dao;

import org.ncm.ncmv2.model.Net;
import org.springframework.stereotype.Component;

public interface NetDao {
    Net getNetById(int id);
}
