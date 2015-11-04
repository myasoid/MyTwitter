package com.miv.mytwitter.service;


import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.domain.UserCreateForm;

import java.util.Optional;

public interface UserService extends BaseEntityService<User> {

    User findByLogin(String login);

    void deleteByLogin(String login);

    User creatUser(String name, String login, String password);

    User create(UserCreateForm form);

    Optional<User> getUserByLogin(String login);
}
