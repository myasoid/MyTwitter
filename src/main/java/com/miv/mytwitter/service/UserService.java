package com.miv.mytwitter.service;


import com.miv.mytwitter.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends BaseEntityService<User>, UserDetailsService {

    User findByLogin(String login);

    void deleteByLogin(String login);

    User creatUser(String name, String login, String password);

}
