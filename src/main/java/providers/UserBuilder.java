package providers;

import com.github.javafaker.Faker;
import models.userBuilder.User;

public class UserBuilder {
    public User createUser(){
        Faker faker = new Faker();
        return new User(faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.address().city(),
                faker.address().streetName(),
                faker.address().zipCode());
    }
}
