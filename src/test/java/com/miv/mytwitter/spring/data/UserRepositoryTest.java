//package com.miv.mytwitter.spring.data;
//
//import com.miv.mytwitter.MyTwitterApplication;
//import com.miv.mytwitter.model.Twit;
//import com.miv.mytwitter.model.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import javax.transaction.Transactional;
//import java.util.Set;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = MyTwitterApplication.class)
//@WebAppConfiguration
//public class UserRepositoryTest {
//
//    @Autowired
//    UserRepository repository;
//
//    @Autowired
//    TwitRepository twitRepository;
//
//    @Test
//    @Transactional(Transactional.TxType.REQUIRED)
//    public void testWithPublicConstrucor() {
//
//        String login = "miv";
//        User user, user2;
//        user = repository.findByLogin(login);
//        if (user != null) {
//            repository.delete(user);
//        }
//        user = repository.findByLogin("miv7");
//        if (user != null) {
//            repository.delete(user);
//        }
//        user = new User("Ivan Myasoid", login, "123");
//        user2 = new User("Ivan Myasoid", "miv7", "321");
//        user.setFollowing(user2);
//        repository.save(user);
//
//        Twit twit = new Twit(user, "Test twit : " + System.currentTimeMillis());
//        twitRepository.save(twit);
//
//        twit = new Twit(user, "Test twit : " + System.currentTimeMillis());
//        twitRepository.save(twit);
//
//        user = repository.findByLogin(login);
//
//        Set<User> fol = user.getFollowings();
//
//        for (User u : fol) {
//            System.out.println(u);
//        }
//        System.out.println(user);
//
//    }
//}
