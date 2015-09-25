package com.miv.mytwitter.spring.data;


import com.miv.mytwitter.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {

    List<User> findAll();

    User findByLogin(String login);

}
