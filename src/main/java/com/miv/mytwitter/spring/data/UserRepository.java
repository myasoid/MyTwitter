package com.miv.mytwitter.spring.data;


import com.miv.mytwitter.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String>{

    public List<User> findAll();
    public User findByLogin(String login);

}
