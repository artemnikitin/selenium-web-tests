package com.artemnikitin;

import com.typesafe.config.ConfigFactory;

import java.io.File;

public class Config {

    private static com.typesafe.config.Config config = ConfigFactory.parseFile(new File("test.conf"));

    public static String getUrl() {
        return config.getString("selenium-tests.blog.url");
    }

    public static String getPostUrl() {
        return config.getString("selenium-tests.blog.post");
    }

}
