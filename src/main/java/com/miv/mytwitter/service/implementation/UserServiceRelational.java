package com.miv.mytwitter.service.implementation;

import com.miv.mytwitter.model.User;
import com.miv.mytwitter.model.enums.UserRoleEnum;
import com.miv.mytwitter.repository.UserRepository;
import com.miv.mytwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceRelational implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByLogin(String login) {
        List<User> list = userRepository.findByLogin(login);
        if (list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void deleteByLogin(String login) {
        User user = findByLogin(login);
        if (user != null) {
            userRepository.delete(user);
        }
    }

    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }

    @Override
    public User creatUser(String name, String login, String password) {
        User user = new User(name, login, password);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = findByLogin(login);
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);

        return userDetails;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}
