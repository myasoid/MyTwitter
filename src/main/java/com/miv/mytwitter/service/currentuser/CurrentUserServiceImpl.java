package com.miv.mytwitter.service.currentuser;

import com.miv.mytwitter.domain.CurrentUser;
import com.miv.mytwitter.domain.enums.UserRoleEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

    @Override
    public boolean canAccessUser(CurrentUser currentUser, String userId) {
        LOGGER.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && (currentUser.getRole() == UserRoleEnum.ADMIN || currentUser.getId().equals(userId));
    }

}
