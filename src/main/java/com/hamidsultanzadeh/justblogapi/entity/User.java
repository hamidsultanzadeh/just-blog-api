package com.hamidsultanzadeh.justblogapi.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Table(name = "user")
@XmlRootElement
@Entity
public class User implements Serializable {

    private static final Long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Basic(optional = false)
    private Integer id;
    @Size(min=5,max=30,message = "Use your real name and surname")
    @Column(name = "name_surname")
    @Basic(optional = false)
    private String nameSurname;
    @Size(min=10,max=300,message = "Use minimum 10 and maximum 300 symbols")
    @Column(name = "description")
    @Basic(optional = false)
    private String description;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
    @Column(name = "mail")
    @Basic(optional = false)
    private String mail;
    @Size(min=5,max=30,message = "Use minimum 5 and maximum 30 symbols")
    @Column(name = "username")
    @Basic(optional = false)
    private String username;
    @Size(min=5,max=255,message = "Use minimum 5 symbols")
    @Column(name = "password")
    @Basic(optional = false)
    private String password;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "youtube")
    private String youtube;

    @ManyToOne
    @JoinColumn(name = "photo_id",nullable = false)
    private Photo photoId;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Post> posts;
    @OneToMany(mappedBy = "userId")
    private List<AllComments> comments;
    @OneToMany(mappedBy = "userId")
    private List<AllLikes> likes;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String nameSurname, String description, Photo photoId, String mail,String username, String password, String facebook, String youtube, List<Post> posts, List<AllComments> comments, List<AllLikes> likes,Set<Role> roles) {
        this.nameSurname = nameSurname;
        this.description = description;
        this.photoId = photoId;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.facebook = facebook;
        this.youtube = youtube;
        this.posts = posts;
        this.comments = comments;
        this.likes = likes;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Photo getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Photo photoId) {
        this.photoId = photoId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<AllComments> getComments() {
        return comments;
    }

    public void setComments(List<AllComments> comments) {
        this.comments = comments;
    }

    public List<AllLikes> getLikes() {
        return likes;
    }

    public void setLikes(List<AllLikes> likes) {
        this.likes = likes;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nameSurname='" + nameSurname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
