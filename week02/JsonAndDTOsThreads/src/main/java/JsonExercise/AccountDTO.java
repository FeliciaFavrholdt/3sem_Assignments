package JsonExercise;

import JsonExercise.entities.AccountInfo;

public class AccountDTO {

    String fullName;
    String city;
    String zipCode;

    String isActive;

    AccountInfo accountInfo;

    public AccountDTO(String fullName, String city, String zipCode, String isActive) {
        this.fullName = fullName;
        this.city = city;
        this.zipCode = zipCode;
        this.isActive = isActive;
    }


    public String getFullName() {
        return fullName;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public boolean getIsActive() {
        return Boolean.parseBoolean(isActive);
    }
}
