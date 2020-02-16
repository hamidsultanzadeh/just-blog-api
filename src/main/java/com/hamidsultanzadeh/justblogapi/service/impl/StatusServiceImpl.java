package com.hamidsultanzadeh.justblogapi.service.impl;

import com.hamidsultanzadeh.justblogapi.dao.StatusDataInter;
import com.hamidsultanzadeh.justblogapi.entity.Status;
import com.hamidsultanzadeh.justblogapi.service.inter.StatusServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusServiceInter {

    @Autowired
    StatusDataInter statusDataInter;

    @Override
    public Status findById(Integer id) {
        Optional status = statusDataInter.findById(id);
        return status.isPresent() ? (Status) status.get() : null;
    }
}
