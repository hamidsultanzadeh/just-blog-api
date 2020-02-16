package com.hamidsultanzadeh.justblogapi.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;

@XmlRootElement
@Table(name = "role")
@Entity
public class Role implements Serializable {

    private static final long serialVersionLong = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Basic(optional = false)
    private Integer id;
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch=FetchType.EAGER,mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(String name, Set<User> users) {
        this.name = name;
        this.users = users;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
