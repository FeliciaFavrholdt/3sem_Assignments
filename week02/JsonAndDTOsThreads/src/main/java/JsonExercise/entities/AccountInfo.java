package JsonExercise.entities;

//3.1 create a class Account with the following attributes: id, balance, isActive

public class AccountInfo {

    String id;
    String balance;
    boolean isActive;

    public AccountInfo(String id, String balance, boolean isActive) {
        this.id = id;
        this.balance = balance;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public String getBalance() {
        return balance;
    }
}