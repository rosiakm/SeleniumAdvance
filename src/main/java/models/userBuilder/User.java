package models.userBuilder;

import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private Date birthdate;
    private String password;

    public User(String firstName, String lastName, String email, String password, Date birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
}
