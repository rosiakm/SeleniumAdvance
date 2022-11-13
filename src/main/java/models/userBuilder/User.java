package models.userBuilder;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String zipCode;
    private String city;
    private String password;

    public User(String firstName, String lastName, String email, String street, String zipCode, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
}
