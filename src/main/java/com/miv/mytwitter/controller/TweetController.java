package com.miv.mytwitter.controller;

import com.miv.mytwitter.model.Tweet;
import com.miv.mytwitter.model.User;
import com.miv.mytwitter.repository.TweetRepository;
import com.miv.mytwitter.service.TweetService;
import com.miv.mytwitter.service.implementation.TweetServiceRelational;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TweetController {

    @Autowired
    TweetService tweetService;


    @RequestMapping("/tweet/create")
    @ResponseBody
    public void create(String text) {

        TweetService tweetService = new TweetServiceRelational();
        tweetService.creatTweet(new User(), text);

    }

    @RequestMapping("/tweet/delete")
    @ResponseBody
    public String delete(String id) {
        try {
            tweetService.delete(id);
        } catch (Exception ex) {
            return "Error deleting the tweet:" + ex.toString();
        }
        return "Tweet succesfully deleted!";
    }

    @RequestMapping("/tweet/get-tweets")
    @ResponseBody
    public String get() {
        String userId;
        List<Tweet> list;
        try {
            //list = tweetService.findAll();
        } catch (Exception ex) {
            return "Tweet not found";
        }
        return "The tweet id is: ";//+ list.toString();
    }


    @RequestMapping("/tweet/update")
    @ResponseBody
    public String updateUser(String id, String text) {
        try {
//            //яяTweet tweet = tweetService.findOne(id);
//            tweet.setText(text);
//            tweetService.save(tweet);
        } catch (Exception ex) {
            return "Error updating the tweet: " + ex.toString();
        }
        return "Tweet succesfully updated!";
    }

}
