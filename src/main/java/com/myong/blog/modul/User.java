package com.myong.blog.modul;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息缓存模块
 */
public class User {
    private int id;
    private String name;
    private String token;
    private String currentTime;
    private String CURRENT_ADDRESS;
    private String accoutId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getCurrentAddress() {
        return CURRENT_ADDRESS;
    }

    public void setCurrentAddress(String currentAddress) {
        this.CURRENT_ADDRESS = currentAddress;
    }

    public String getAccoutId() {
        return accoutId;
    }

    public void setAccoutId(String accoutId) {
        this.accoutId = accoutId;
    }

}
