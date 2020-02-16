package com.hamidsultanzadeh.justblogapi.dao;

import com.hamidsultanzadeh.justblogapi.entity.Photo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhotoDataInter extends CrudRepository<Photo, Integer> {

    List<Photo> findAll();

}
