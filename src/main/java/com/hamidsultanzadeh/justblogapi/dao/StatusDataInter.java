package com.hamidsultanzadeh.justblogapi.dao;

import com.hamidsultanzadeh.justblogapi.entity.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusDataInter extends CrudRepository<Status, Integer> {
}
