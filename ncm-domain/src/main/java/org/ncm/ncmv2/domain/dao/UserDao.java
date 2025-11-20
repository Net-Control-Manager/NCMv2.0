package org.ncm.ncmv2.domain.dao;

import org.ncm.ncmv2.domain.model.User;

public interface UserDao {
    User createUser(User user);

    User getUserById(Long id);
    User getUserByEmail(String email);

    //TODO: Flesh out the rest of these methods
}
