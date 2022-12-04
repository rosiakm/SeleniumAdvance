package providers;

import com.github.javafaker.Faker;
import models.builders.User;

public class UserBuilder {
    public static User createUser(){
        Faker faker = new Faker();
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .birthdate(String.valueOf(faker.date().birthday()))
                .build();
    }

    public static User getAlreadyRegisterUser(){
        return User.builder()
                .email(System.getProperty("email"))
                .password(System.getProperty("password"))
                .build();
    }
}
