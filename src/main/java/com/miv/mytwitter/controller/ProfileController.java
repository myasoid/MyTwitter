package com.miv.mytwitter.controller;


import com.miv.mytwitter.domain.Tweet;
import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.service.TweetService;
import com.miv.mytwitter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;

@Controller
public class ProfileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    UserService userService;

    @Autowired
    TweetService tweetService;

    @RequestMapping(value = "/{username}/", method = RequestMethod.GET)
    //  @PreAuthorize("@userService.canAccessUser(principal, #username)")
    public String getProfile(@PathVariable("username") String userName, HttpServletRequest request, Principal principal, Model model, Pageable pageable) {
        setModelAttribute(userName, request, principal, model, pageable, "tweets");
        return "profile";
    }

    @RequestMapping(value = "/{username}/following", method = RequestMethod.GET)
    public String getProfileFollowing(@PathVariable("username") String userName, HttpServletRequest request, Principal principal, Model model, Pageable pageable) {
        setModelAttribute(userName, request, principal, model, pageable, "followings");
        return "profile";
    }

    @RequestMapping(value = "/{username}/followers", method = RequestMethod.GET)
    public String getProfileFollowers(@PathVariable("username") String userName, HttpServletRequest request, Principal principal, Model model, Pageable pageable) {
        setModelAttribute(userName, request, principal, model, pageable, "followers");
        return "profile";
    }

    @Transactional
    public void setModelAttribute(String userName, HttpServletRequest request, Principal principal, Model model, Pageable pageable, String activeTab) {

        model.addAttribute("activeTab", activeTab);

        User currentUser = userService.findByLogin(principal.getName());
        User profile = userService.findByLogin(userName);
        currentUser.getFollowings().contains(profile);
        model.addAttribute("userProfileCard", profile);
        model.addAttribute("userProfileFollowed", currentUser.getFollowings().contains(profile));

        model.addAttribute("profileTwits", new ArrayList<Tweet>());
        model.addAttribute("profileFollowings", profile.getFollowings());
        model.addAttribute("profileFollowers", profile.getFollowers());

        model.addAttribute("userProfileCardTweetsSize", profile.getTwits().size());
        model.addAttribute("userProfileCardFollowingsSize", profile.getFollowings().size());
        model.addAttribute("userProfileCardFollowersSize", profile.getFollowers().size());
        model.addAttribute("page", new PageRequest(0, PageWrapper.MAX_PAGE_ITEM_DISPLAY));
        if ("tweets".equalsIgnoreCase(activeTab)) {
            Page<Tweet> profileTweetsPage = tweetService.findTweetByOwner(profile, pageable);
            PageWrapper<Tweet> page = new PageWrapper<Tweet>(profileTweetsPage, "/" + userName + "/");
            model.addAttribute("profileTwits", page.getContent());
            model.addAttribute("page", page);
        }

    }

}
