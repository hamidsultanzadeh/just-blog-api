package com.hamidsultanzadeh.justblogapi.service.inter;

import com.hamidsultanzadeh.justblogapi.entity.Post;
import com.hamidsultanzadeh.justblogapi.entity.Status;
import com.hamidsultanzadeh.justblogapi.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostServiceInter {

    Page<Post> findAll(Integer page);

    List<Post> findAllByUserIdAndStatusId(User userId);

    Post findById(Integer id);

    boolean save(Post post, String typeSubmit);

    boolean changeStatus(Post post, Status statusId);

    boolean update(Post update, Post post);

    boolean remove(Post post);

}
