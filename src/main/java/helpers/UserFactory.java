package helpers;

import models.userBuilder.User;
import providers.UserBuilder;

public class UserFactory {
    UserBuilder userBuilder;

    public User getRandomUser(){
        return userBuilder.createUser();
    }

    public User getAlreadyRegisteredUser(){
        return new User(System.getProperty("email"),
                System.getProperty("password"));
    }
}
