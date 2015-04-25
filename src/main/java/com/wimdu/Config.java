package com.wimdu;

import com.typesafe.config.ConfigFactory;

import java.io.File;

public class Config {

    private static com.typesafe.config.Config config = ConfigFactory.parseFile(new File("test.conf"));

    public static String getBaseUrl() {
        String env = getFromEnvVar("base.url");
        String sys = getFromSysProp("base.url");
        if(!env.equals(""))
            return env;
        else if(!sys.equals(""))
            return sys;
        else
            return config.getString("selenium-tests.wimdu.base.url");
    }

    public static String getLogin() {
        return config.getString("selenium-tests.wimdu.users.registered.login");
    }

    public static String getPassword() {
        return config.getString("selenium-tests.wimdu.users.registered.password");
    }

    public static String getLoginUrl() {
        return getBaseUrl() + config.getString("selenium-tests.wimdu.urls.login");
    }

    public static String getRegistrationUrl() {
        return getBaseUrl() + config.getString("selenium-tests.wimdu.urls.registration");
    }

    private static String getFromEnvVar(String name) {
        String result;
        try {
            result = System.getenv(name).toString();
        } catch (NullPointerException e) {
            result = "";
        }
        return result;
    }

    private static String getFromSysProp(String name) {
        String result;
        try {
            result = System.getProperty(name).toString();
        } catch (NullPointerException e) {
            result = "";
        }
        return result;
    }

}
