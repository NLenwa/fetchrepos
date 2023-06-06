package com.fetchrepostask.fetchrepos.authentificator;

public class Authenticator {
    private final static String authKey = "...";          // authorization key

    private final static String login = "";         // login credentials
    public static String getAuthKey() {
        return authKey;
    }

    public static String getLogin() {
        return login;
    }
}
