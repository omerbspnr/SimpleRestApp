package org.csystem.app.service;

import org.csystem.app.entity.User;

import java.util.Optional;

public interface IUserService {
    User save(User s);
    Optional<User> controlForLogin(User u);
    boolean isUserExist(User u);
}
