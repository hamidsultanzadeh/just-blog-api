package com.hamidsultanzadeh.justblogapi.service.inter;

import com.hamidsultanzadeh.justblogapi.entity.Category;

import java.util.List;

public interface CategoryServiceInter {

    List<Category> findAllByOrder();

    List<Category> findAllByOrderByName();

    Category findById(Integer id);
}
