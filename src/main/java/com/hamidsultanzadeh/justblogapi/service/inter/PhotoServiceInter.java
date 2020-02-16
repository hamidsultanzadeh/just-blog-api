package com.hamidsultanzadeh.justblogapi.service.inter;

import com.hamidsultanzadeh.justblogapi.entity.Photo;

import java.util.List;

public interface PhotoServiceInter {

    List<Photo> findAll();

    Photo findById(Integer id);

}
