package ex7_Collectors;

//7.1 Create a Transaction class with attributes like id, amount, and currency.

public class Transaction {

    //attributes
    private int id;
    private double amount;
    private String currency;

    //constructor
    public Transaction(int id, double amount, String currency) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
    }

    //no-args constructor
    public Transaction() {
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    //toString method
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}

