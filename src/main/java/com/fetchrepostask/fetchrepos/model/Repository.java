package com.fetchrepostask.fetchrepos.model;

public class Repository {

    private String name;            // repository name
    private String login;           // github user login


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
