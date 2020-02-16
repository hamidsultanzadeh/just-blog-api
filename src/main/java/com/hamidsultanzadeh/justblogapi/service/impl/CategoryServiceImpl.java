package com.hamidsultanzadeh.justblogapi.service.impl;

import com.hamidsultanzadeh.justblogapi.dao.CategoryDataInter;
import com.hamidsultanzadeh.justblogapi.entity.Category;
import com.hamidsultanzadeh.justblogapi.service.inter.CategoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryServiceInter {

    @Autowired
    CategoryDataInter categoryDataInter;

    @Override
    @Cacheable("categoriesNavbar")
    public List<Category> findAllByOrder() {
        return categoryDataInter.findAllByOrder(PageRequest.of(0,10));
    }

    @Override
    @Cacheable("categoriesWrite")
    public List<Category> findAllByOrderByName() {
        return categoryDataInter.findAllByOrderByName();
    }

    @Override
    public Category findById(Integer id) {
        Optional category = categoryDataInter.findById(id);
        return category.isPresent() ? (Category) category.get() : null;
    }
}
