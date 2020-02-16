package com.hamidsultanzadeh.justblogapi.dto;

public class Role {

    private Integer id;
    private String name;

    public Role() {
    }

    public Role(com.hamidsultanzadeh.justblogapi.entity.Role role){
        this.id = role.getId();
        this.name = role.getName();
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
