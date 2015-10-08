package com.miv.twitter.Service;

import com.miv.mytwitter.MyTwitterApplication;
import com.miv.mytwitter.model.Tweet;
import com.miv.mytwitter.model.User;
import com.miv.mytwitter.service.TweetService;
import com.miv.mytwitter.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyTwitterApplication.class)
@WebAppConfiguration
public class TweetServiceRelationalTest {

    @Autowired
    TweetService tweetService;

    @Autowired
    UserService userService;

    @Test
    public void test() {

        User user = userService.findByLogin("iii");
        if (user == null) {
            user = userService.save(new User("iii", "iii", "iii"));
        }
        Tweet tweet = tweetService.creatTweet(user, "gkadhasgfh #dwerwer#asfdadf @miv");
    }
}
