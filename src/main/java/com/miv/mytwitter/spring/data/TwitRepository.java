package com.miv.mytwitter.spring.data;



import com.miv.mytwitter.model.Twit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TwitRepository extends CrudRepository<Twit, String> {

    public List<Twit> findAll();

}
