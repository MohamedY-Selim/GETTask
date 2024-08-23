package com.codenboxautomationlab.utils;

import com.codenboxautomationlab.objects.User;
import com.github.javafaker.Faker;

public class UserUtils {
    static Faker faker = new Faker();

    public static User generateRandomUser() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phone = ConfigUtils.generateRandomMobileNumber();
        return new User(firstName, lastName, email, phone);
    }
}