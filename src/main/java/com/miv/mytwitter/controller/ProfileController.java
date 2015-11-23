package com.miv.mytwitter.controller;


import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    UserService userService;

    //  @PreAuthorize("@userService.canAccessUser(principal, #username)")
    @RequestMapping(value = "/{username}\b(?<!/login|/signup)", method = RequestMethod.GET)
    @Transactional
    public String getProfile(@PathVariable("username") String userName, HttpServletRequest request, Principal principal, Model model) {
        setModelAttribute(userName, request, principal, model, "tweets");
        return "profile";
    }

    @RequestMapping(value = "/{username}/following\b(?<!/login|/signup)", method = RequestMethod.GET)
    @Transactional
    public String getProfileFollowing(@PathVariable("username") String userName, HttpServletRequest request, Principal principal, Model model) {
        setModelAttribute(userName, request, principal, model, "following");
        return "profile";
    }

    @RequestMapping(value = "/{username}/followers\b(?<!/login|/signup)", method = RequestMethod.GET)
    @Transactional
    public String getProfileFollowers(@PathVariable("username") String userName, HttpServletRequest request, Principal principal, Model model) {
        setModelAttribute(userName, request, principal, model, "followers");
        return "profile";
    }

    public void setModelAttribute(String userName, HttpServletRequest request, Principal principal, Model model, String activeTab) {
        final String currentUserLogin = principal.getName();
        User currentUser = userService.findByLogin(currentUserLogin);
        model.addAttribute("profile", userName);
        model.addAttribute("user", currentUser);
        model.addAttribute("tweetssize", currentUser.getTwits().size());
        model.addAttribute("followingssize", currentUser.getFollowings().size());
        model.addAttribute("followerssize", currentUser.getFollowers().size());
    }

}
