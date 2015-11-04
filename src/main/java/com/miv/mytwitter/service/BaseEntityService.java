package com.miv.mytwitter.service;

public interface BaseEntityService<T> {

    T save(T t);

    void delete(String id);

}
