package com.miv.mytwitter.controller;

import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class FollowController {
    @Autowired
    UserService userService;

//    @RequestMapping(value = "/{username}/follow/{followBy}", method = RequestMethod.POST)
//    public String followProfile(@PathVariable("login") String login, final HttpServletRequest request, Principal principal, Model model) {
//        final String currentUserLogin = principal.getName();
//        User currentUser = userService.findByLogin(currentUserLogin);
//        User user = userService.findByLogin(login);
//
//        if (currentUser.getFollowings().contains(user)) {
//            currentUser.removeFollowing(user);
//        } else {
//            currentUser.setFollowing(user);
//        }
//
//        userService.save(currentUser);
//
//        return "redirect:" + request.getHeader("Referer");
//    }
}
