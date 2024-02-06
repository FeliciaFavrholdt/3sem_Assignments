package JsonExercise.entities;

//3.1 create a class Address with the following attributes: street, city, zipCode

import JsonExercise.AccountDTO;

public class Account {

    String firstName;
    String lastName;
    String birthDate;
    Address address;

    public Account(String firstName, String lastName, String birthDate, Address address, AccountInfo accountInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public AccountDTO getAddress() {
        return new AccountDTO(getFullName(), address.getCity(), address.getZipCode(), "isActive");
    }

    public String getIsActive() {
        return "isActive";
    }
}