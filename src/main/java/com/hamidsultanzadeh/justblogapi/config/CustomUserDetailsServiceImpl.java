package com.hamidsultanzadeh.justblogapi.config;

import com.hamidsultanzadeh.justblogapi.bean.CustomUserDetail;
import com.hamidsultanzadeh.justblogapi.dao.UserDataInter;
import com.hamidsultanzadeh.justblogapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDataInter userDataInter;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = null;

        if(s.contains("@")){
            user = userDataInter.findByMail(s);
        } else {
            user = userDataInter.findByUsername(s);
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        user.getRoles().forEach(r -> {
            GrantedAuthority a = new SimpleGrantedAuthority(r.getName());
            roles.add(a);
        });

        UserDetails userDetails = new CustomUserDetail(
                user,
                user.getMail(),
                user.getPassword(),
                roles
        );

        return userDetails;
    }
}
