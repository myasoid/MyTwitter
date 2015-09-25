package com.miv.mytwitter.spring.service;


import com.miv.mytwitter.model.User;

public interface UserService {

    User getUser(String login);

}
