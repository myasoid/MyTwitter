package com.miv.mytwitter.controller;

import com.miv.mytwitter.domain.Tweet;
import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.service.TweetService;
import com.miv.mytwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.security.Principal;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    TweetService tweetService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Transactional
    public String showIndex(final HttpServletRequest request, Principal principal, Model model, Pageable pageable) {
        final String currentUserLogin = principal.getName();
        User user = userService.findByLogin(currentUserLogin);
        model.addAttribute("userProfileCard", user);

        Page<Tweet> profileTweetsPage = tweetService.findTweetByOwnerIn(user.getFollowings(), pageable);
        PageWrapper<Tweet> page = new PageWrapper<Tweet>(profileTweetsPage, "/");
        model.addAttribute("tweets", page.getContent());
        model.addAttribute("page", page);
        model.addAttribute("userProfileCardTweetsSize", user.getTwits().size());
        model.addAttribute("userProfileCardFollowingsSize", user.getFollowings().size());
        model.addAttribute("userProfileCardFollowersSize", user.getFollowers().size());
        return "index";

    }
}
