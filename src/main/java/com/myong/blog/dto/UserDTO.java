package com.myong.blog.dto;

public class UserDTO {
    private String id;
    private String avatar_url;//头像
    private String name;//昵称
    private String bio;//简介

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
