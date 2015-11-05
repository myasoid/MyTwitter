package com.miv.mytwitter.service.implementation;

import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.domain.validator.UserCreateForm;
import com.miv.mytwitter.repository.UserRepository;
import com.miv.mytwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceRelational implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByLogin(String login) {
        Optional<User> userOptional = userRepository.findOneByLogin(login);

        if (userOptional.isPresent()) {
            return userOptional.get();
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
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return userRepository.findOneByLogin(login);
    }

    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        String[] names = form.getName().split(" ");
        if(names.length > 0){
            user.setFirstName(names[0]);
        }
        if(names.length > 1){
            user.setLastName(names[1]);
        }
        user.setLogin(form.getLogin());
        user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }
}
