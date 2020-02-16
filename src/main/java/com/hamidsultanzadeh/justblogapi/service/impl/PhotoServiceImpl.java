package com.hamidsultanzadeh.justblogapi.service.impl;

import com.hamidsultanzadeh.justblogapi.dao.PhotoDataInter;
import com.hamidsultanzadeh.justblogapi.entity.Photo;
import com.hamidsultanzadeh.justblogapi.service.inter.PhotoServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoServiceInter {

    @Autowired
    PhotoDataInter photoDataInter;

    @Override
    public List<Photo> findAll() {
        return photoDataInter.findAll();
    }

    @Override
    public Photo findById(Integer id){
        Optional photo = photoDataInter.findById(id);
        return photo.isPresent() ? (Photo) photo.get() : null;
    }
}
