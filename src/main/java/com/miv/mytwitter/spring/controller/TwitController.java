package com.miv.mytwitter.spring.controller;

import com.miv.mytwitter.model.Twit;
import com.miv.mytwitter.spring.data.TwitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TwitController {

    @Autowired
    TwitRepository repository;


    @RequestMapping("/twit/create")
    @ResponseBody
    public String create(String text) {
        Twit twit = null;
        try {
            twit = new Twit();
            twit.setText(text);
            repository.save(twit);
        }
        catch (Exception ex) {
            return "Error creating the twit: " + ex.toString();
        }
        return "User succesfully created! (id = " + twit.getId() + ")";
    }

    @RequestMapping("/twit/delete")
    @ResponseBody
    public String delete(String id) {
        try {
            repository.delete(id);
        }
        catch (Exception ex) {
            return "Error deleting the twit:" + ex.toString();
        }
        return "Twit succesfully deleted!";
    }

    @RequestMapping("/twit/get-twits")
    @ResponseBody
    public String get() {
        String userId;
        List<Twit> list;
        try {
            list = repository.findAll();
        }
        catch (Exception ex) {
            return "Twit not found";
        }
        return "The twit id is: " + list.toString();
    }


    @RequestMapping("/twit/update")
    @ResponseBody
    public String updateUser(String id, String text) {
        try {
            Twit twit = repository.findOne(id);
            twit.setText(text);
            repository.save(twit);
        }
        catch (Exception ex) {
            return "Error updating the twit: " + ex.toString();
        }
        return "Twit succesfully updated!";
    }

}
