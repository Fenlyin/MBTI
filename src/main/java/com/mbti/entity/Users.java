package com.mbti.entity;

import java.util.Date;

public class Users {
    private int id;
    private String login;
    private String name;
    private String passwd;
    private int type;
    private int status;
    private Date last_login;

    public Users(){

    }

    public Users(int id, String login, String name, String passwd, int type, int status, Date last_login) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.passwd = passwd;
        this.type = type;
        this.status = status;
        this.last_login = last_login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }
}
