package com.hamidsultanzadeh.justblogapi.service.inter;

import com.hamidsultanzadeh.justblogapi.entity.AllLikes;
import com.hamidsultanzadeh.justblogapi.entity.Post;

public interface LikeServiceInter {

    boolean save(Post post, AllLikes like);

    AllLikes findByPostIdAndUserId(Post post);

    boolean delete(Post post, AllLikes like);
}
