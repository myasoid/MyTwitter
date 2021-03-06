package com.miv.mytwitter.service.currentuser;

import com.miv.mytwitter.domain.CurrentUser;
import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);
    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String login) throws UsernameNotFoundException {
        LOGGER.debug("Authenticating user with login={}", login);
        User user = userService.getUserByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with login=%s was not found", login)));
        return new CurrentUser(user);
    }

}
