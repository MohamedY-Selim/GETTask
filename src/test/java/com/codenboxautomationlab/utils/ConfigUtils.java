package com.codenboxautomationlab.utils;

import com.github.javafaker.Faker;

import java.util.Properties;
import java.util.Random;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;
    private static final Random random = new Random();
    private static final Faker faker = new Faker();

    private ConfigUtils() {
        String env = System.getProperty("env", "TESTING");
        switch (env) {
            case "TESTING" ->
                    properties = PropertiesUtils.loadProperties("src/test/java/com/codenboxautomationlab/config/testing.properties");
            case "PRODUCTION" ->
                    properties = PropertiesUtils.loadProperties("src/test/java/com/codenboxautomationlab/config/production.properties");
            default -> throw new RuntimeException("Environment isn't supported");
        }
    }

    public static ConfigUtils getInstance() {
        if (configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        throw new RuntimeException("Couldn't find the base url in the property file");
    }

    public String getEmail() {
        String prop = properties.getProperty("email");
        if (prop != null) return prop;
        throw new RuntimeException("Couldn't find the UserName in the property file");
    }

    public String getPassword() {
        String prop = properties.getProperty("password");
        if (prop != null) return prop;
        throw new RuntimeException("Couldn't find the password in the property file");
    }

    public void setNewUserData(String email, String password) {
        setNewUserEmail(email);
        setNewUserPassword(password);
    }

    public void setNewUserEmail(String email) {
        properties.setProperty("email", email);
        PropertiesUtils.updateProperties("src/test/java/com/codenboxautomationlab/config/testing.properties");
    }

    public void setNewUserPassword(String password) {
        properties.setProperty("password", password);
        PropertiesUtils.updateProperties("src/test/java/com/codenboxautomationlab/config/testing.properties");
    }


    public static String generateRandomMobileNumber() {
        String[] validFifthDigits = {"0", "1", "2", "5"};
        String fifthDigit = validFifthDigits[random.nextInt(validFifthDigits.length)];
        StringBuilder mobileNumber = new StringBuilder("+201" + fifthDigit);

        for (int i = 0; i < 8; i++) {
            mobileNumber.append(faker.number().digit());
        }

        return mobileNumber.toString();
    }

}
