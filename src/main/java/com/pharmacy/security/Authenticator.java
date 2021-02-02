package com.pharmacy.security;

import java.util.HashMap;
import java.util.Map;

public class Authenticator {

    private static final Map<String, String> USERS = new HashMap<>();
    static {
        USERS.put("demo", "demo");
        USERS.put("nas", "housni");
    }
    public static boolean validate(String user, String password){
        String validUserPassword = USERS.get(user);
        return validUserPassword != null && validUserPassword.equals(password);
    }
}
