package com.hamidsultanzadeh.justblogapi.dao;

import com.hamidsultanzadeh.justblogapi.entity.Post;
import com.hamidsultanzadeh.justblogapi.entity.Status;
import com.hamidsultanzadeh.justblogapi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostDataInter extends CrudRepository<Post,Integer> {

    Page<Post> findAllByStatusIdOrderByInsertTimeDesc(Status statusId, Pageable pageable);

    List<Post> findAllByUserIdAndStatusId(User userId, Status statusId);

}
