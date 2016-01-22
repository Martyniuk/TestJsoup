package com.jsoup.tools;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by vladimir on 21.01.16.
 */
public class Configuration {
    private Properties parameters;
    private static Configuration instance = null;

    private Configuration() {
        parameters = new Properties();
        try {
            parameters.load(getClass().getClassLoader().getResourceAsStream("config.prooperties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Configuration getInstance() {
        return instance == null ? new Configuration() : instance;
    }

    public String getParameter(String name) {
        return parameters.getProperty(name);
    }
    public void setParameters(String name, String value) {
        parameters.setProperty(name, value);
    }
}

