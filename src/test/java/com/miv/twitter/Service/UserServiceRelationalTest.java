package com.miv.twitter.Service;

import com.miv.mytwitter.MyTwitterApplication;
import com.miv.mytwitter.model.User;
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
public class UserServiceRelationalTest {

    @Autowired
    UserService userService;

    @Test
    public void creatUser() {

        User user = userService.findByLogin("iii");
        if (user != null){
            userService.deleteByLogin("iii");
        }

        user = userService.creatUser("Ivanov ivan", "iii", "1234");

        User user1 = userService.findByLogin("miv");
        if (user1 != null){
            user.setFollower(user1);
        }

        userService.save(user);

    }


}
