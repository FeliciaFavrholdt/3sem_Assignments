package ex7_Collectors;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Examples {

    public static void main(String[] args) {
        System.out.println(createTransactions());

        //7.3 Use the Collectors class to perform the following operations on the list of transactions:
        //7.4 Use the collect method with different Collectors to aggregate and collect the results of your operations.

        //Calculate the total sum of all transaction amounts.
        Collection<Transaction> transactions = createTransactions();
        double totalSum = transactions.stream().mapToDouble(Transaction::getAmount).sum();
        System.out.println("Total sum of all transactions: " + totalSum);
        System.out.println("---------------------");

        //Group transactions by currency and calculate the sum of amounts for each currency.
        System.out.println("Group transactions by currency and calculate the sum of amounts for each currency:");
        transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency, Collectors.summingDouble(Transaction::getAmount)))
                .forEach((currency, sum) -> System.out.println("Currency: " + currency + " Sum: " + sum));
        System.out.println("---------------------");

        //Find the highest transaction amount.
        transactions.stream()
                .collect(Collectors.maxBy((transaction1, transaction2) -> Double.compare(transaction1.getAmount(), transaction2.getAmount())))
                .ifPresent(transaction -> System.out.println("Highest transaction amount: " + transaction.getAmount()));
        System.out.println("---------------------");

        //Find the average transaction amount.
        double averageTransactionAmount = transactions.stream()
                .collect(Collectors.averagingDouble(Transaction::getAmount));
        System.out.println("Average transaction amount: " + averageTransactionAmount);
        System.out.println("---------------------");

        //Use the collect method with different Collectors to aggregate and collect the results of your operations.
        //Collect the transaction amounts in a list.
        List<Double> transactionAmounts = transactions.stream()
                .map(Transaction::getAmount)
                .toList();
        System.out.println("Transaction amounts: " + transactionAmounts);
    }

    //7.2 Create a collection of Transaction objects to work with. You can either create a sample dataset or read data from a file or database.
    private static Collection<Transaction> createTransactions() {
        return List.of(
                new Transaction(1, 100.0, "USD"),
                new Transaction(2, 100.0, "USD"),
                new Transaction(3, 150.0, "EUR"),
                new Transaction(4, 200.0, "DKK"),
                new Transaction(5, 75.0, "GBP"),
                new Transaction(6, 75.0, "GBP"),
                new Transaction(7, 120.0, "EUR"),
                new Transaction(8, 300.0, "GBP"),
                new Transaction(9, 300.0, "GBP")
        );
    }
}