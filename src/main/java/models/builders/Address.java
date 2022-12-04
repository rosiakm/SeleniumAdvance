package models.builders;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {
    private String address;
    private String zipCode;
    private String city;

    public Address(String address, String zipCode, String city) {
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
    }
}
