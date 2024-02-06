package JsonExercise.entities;

//3.1 create a class Address with the following attributes: street, city, zipCode

public class Address {

    String street;
    String city;
    int zipCode;

    public Address(String street, String city, int zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return String.valueOf(zipCode);
    }

    public String getCity() {
        return city;
    }
}