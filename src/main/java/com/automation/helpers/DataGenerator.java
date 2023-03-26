package com.automation.helpers;

import com.github.javafaker.Faker;

public class DataGenerator {

    public static String getFirstName() {        //library to generate fake data
        String firstName = Faker.instance().name().firstName();
        return firstName;
    }

    public static String getLastName() {
        String firstName = Faker.instance().name().lastName();
        return firstName;
    }

    public static String getPassword() {
        String password = Faker.instance().internet().password();
        return password;
    }

    public static String getEmailAddress() {
        return Faker.instance().internet().emailAddress();
    }

    public static String getFullName() {
        String fullName = Faker.instance().name().fullName();
        return fullName;
    }

    public static String getPhoneNumber() {
        String phoneNumber = Faker.instance().phoneNumber().cellPhone();
        return phoneNumber;
    }
    public static String generateRandomData(String value) {
        if (value.equalsIgnoreCase("${randomFirstName}")) {
            value = value.replace("${randomFirstName}", getFirstName());
        }
        if (value.equalsIgnoreCase("${randomLastName}")) {
            value = value.replace("${randomLastName}", getLastName());
        }
        return value;
    }
}

