package com.miv.mytwitter.service;


import com.miv.mytwitter.model.Tag;

public interface TagService extends BaseEntityService<Tag> {

    Tag save(String text);


}
