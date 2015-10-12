package com.miv.mytwitter.service.currentuser;


import com.miv.mytwitter.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, String userId);

}
