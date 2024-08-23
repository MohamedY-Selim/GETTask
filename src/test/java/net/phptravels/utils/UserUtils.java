package net.phptravels.utils;

import com.github.javafaker.Faker;
import net.phptravels.objects.User;

public class UserUtils {
    Faker faker = new Faker();

    public static User generateRandomUser() {
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String email = new Faker().internet().emailAddress();
        String phone = ConfigUtils.generateRandomMobileNumber();
        return new User(firstName, lastName, email, phone);
    }
}