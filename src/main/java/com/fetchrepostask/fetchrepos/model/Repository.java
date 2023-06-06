package com.fetchrepostask.fetchrepos.model;

import java.util.List;
import java.util.Map;

public class Repository {

    private String name;            // repository name
    private String login;           // github user login
    private String branches;


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

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
    }
}
