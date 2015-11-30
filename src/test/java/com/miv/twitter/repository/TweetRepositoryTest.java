package com.miv.twitter.repository;

import com.miv.mytwitter.MyTwitterApplication;
import com.miv.mytwitter.domain.Tweet;
import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.repository.TweetRepository;
import com.miv.mytwitter.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyTwitterApplication.class)
@WebAppConfiguration
public class TweetRepositoryTest {

    private TweetRepository tweetRepository;
    private UserRepository userRepository;

    @Autowired
    public void setTweetRepository(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void testFindTweetByFollowing() {

        Optional<User> user = userRepository.findOneByLogin("miv");
        assertTrue(user.isPresent());
//        Page<Tweet> tweets = tweetRepository.findTweetsByFollowing(user.get(), new PageRequest(0, 20));
//        boolean b = true;


    }
}
