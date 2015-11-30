package com.miv.mytwitter.service;


import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.domain.validator.UserCreateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService extends BaseEntityService<User> {

    User findByLogin(String login);

    void deleteByLogin(String login);

    User creatUser(String name, String login, String password);

    User create(UserCreateForm form);

    Optional<User> getUserByLogin(String login);

//    Page<User> getFollowersByUser(User user, Pageable page);
//
//    Page<User> getFollowingsByUser(User user, Pageable page);

}
