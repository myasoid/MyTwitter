package com.miv.mytwitter.spring.service;

import com.miv.mytwitter.model.User;
import com.miv.mytwitter.spring.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(String login) {


        return userRepository.findByLogin(login);
    }

}
