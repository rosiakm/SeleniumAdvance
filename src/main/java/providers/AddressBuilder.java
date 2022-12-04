package providers;

import com.github.javafaker.Faker;
import models.builders.Address;

import java.util.Locale;

public class AddressBuilder {

    public static Address newAddress(){
        Faker faker = new Faker(new Locale("pl_PL"));
        return Address.builder()
                .address(faker.address().fullAddress())
                .zipCode(faker.address().zipCode())
                .city(faker.address().city())
                .build();
    }
}
