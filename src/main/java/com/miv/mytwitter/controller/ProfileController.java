package com.miv.mytwitter.controller;


import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.security.Principal;

@Controller
public class ProfileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{username}/", method = RequestMethod.GET)
    //  @PreAuthorize("@userService.canAccessUser(principal, #username)")
    public String getProfile(@PathVariable("username") String userName, HttpServletRequest request, Principal principal, Model model) {
        setModelAttribute(userName, request, principal, model, "tweets");
        return "profile";
    }

    @RequestMapping(value = "/{username}/following", method = RequestMethod.GET)
    public String getProfileFollowing(@PathVariable("username") String userName, HttpServletRequest request, Principal principal, Model model) {
        setModelAttribute(userName, request, principal, model, "followings");
        return "profile";
    }

    @RequestMapping(value = "/{username}/followers", method = RequestMethod.GET)
    public String getProfileFollowers(@PathVariable("username") String userName, HttpServletRequest request, Principal principal, Model model) {
        setModelAttribute(userName, request, principal, model, "followers");
        return "profile";
    }

    @Transactional
    public void setModelAttribute(String userName, HttpServletRequest request, Principal principal, Model model, String activeTab) {

        model.addAttribute("activeTab", activeTab);

        User profile = userService.findByLogin(userName);
        model.addAttribute("userProfileCard", profile);
        model.addAttribute("userProfileCardTweetsSize", profile.getTwits().size());
        model.addAttribute("userProfileCardFollowingsSize", profile.getFollowings().size());
        model.addAttribute("userProfileCardFollowersSize", profile.getFollowers().size());

        model.addAttribute("profileTwits", profile.getTwits());
        model.addAttribute("profileFollowings", profile.getFollowings());
        model.addAttribute("profileFollowers", profile.getFollowers());
    }

}
