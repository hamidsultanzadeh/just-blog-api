package com.hamidsultanzadeh.justblogapi.dao;

import com.hamidsultanzadeh.justblogapi.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDataInter extends CrudRepository<Role,Integer> {
}
