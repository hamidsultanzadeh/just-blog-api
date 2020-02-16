package com.hamidsultanzadeh.justblogapi.dao;

import com.hamidsultanzadeh.justblogapi.entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryDataInter extends CrudRepository<Category,Integer> {

    @Query(
            value = "select c from Category c join c.posts ps  where c.posts.size > 0 group by c Order By c.posts.size desc",
            countQuery = "select count(c) from Category c"
    )
    List<Category> findAllByOrder(Pageable pageable);

    List<Category> findAllByOrderByName();
}
