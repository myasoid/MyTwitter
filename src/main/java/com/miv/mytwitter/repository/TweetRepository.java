package com.miv.mytwitter.repository;


import com.miv.mytwitter.domain.Tweet;
import com.miv.mytwitter.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, String> {

    List<Tweet> findAll();

    @Query("select u from Tweet u where u.firstname = :user")
    Page<Tweet> findByLastnameOrFirstname(@Param("user") User user, Pageable page);

}
