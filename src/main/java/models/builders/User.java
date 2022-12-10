package models.builders;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthdate;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
    public User(String firstName, String lastName, String email, String password, String birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }
}
