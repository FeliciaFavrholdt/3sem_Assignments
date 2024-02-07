package JsonExercise;

import JsonExercise.entities.Account;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
            // 1. Java object to JSON file
            Object obj;
            gson.toJson(obj, new FileWriter("C:\\Users\\user\\Desktop\\file.json"));

            // 2. Java object to JSON string
            String json = gson.toJson(obj)

            // 1. JSON file to Java object
            Object object = gson.fromJson(new FileReader("account.json"), Object.class);

            // 2. JSON string to Java object
            String json = "{'name' : 'mkyong'}";
            Object object = gson.fromJson(json, Staff.class);

         */

        // Read accounts from JSON file
        Account[] accounts = readAccountsFromFile("/Users/fefav/Desktop/3sem/3sem_Assignments/week02/JsonAndDTOsThreads/src/main/java/JsonExercise/account.json");

        // Convert Account objects to DTO objects
        AccountDTO[] accountDTOs = convertToDTO(accounts);

        // Print DTO objects in a nice format
        printDTOs(accountDTOs);
    }

    // Method to read accounts from JSON file and return an array of Account objects
    public static Account[] readAccountsFromFile(String fileName) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileName)) {
            Type type = new TypeToken<List<Account>>() {
            }.getType();
            List<Account> accounts = gson.fromJson(reader, type);
            return accounts.toArray(new Account[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to convert an Account object to a DTO object
    public static AccountDTO convertToDTO(Account account) {
        return new AccountDTO(account.getFullName(), account.getAddress().getCity(), account.getAddress().getZipCode(), account.getIsActive());
    }

    // Method to convert an array of Account objects to an array of DTO objects
    public static AccountDTO[] convertToDTO(Account[] accounts) {
        return Arrays.stream(accounts)
                .map(account -> new AccountDTO(account.getFullName(), account.getAddress().getCity(), account.getAddress().getZipCode(), account.getIsActive()))
                .toArray(AccountDTO[]::new);
    }

    // Method to print DTO objects in a nice format
    public static void printDTOs(AccountDTO[] dtos) {
        Arrays.stream(dtos)
                .forEach(dto -> {
                    System.out.println("Full name: " + dto.getFullName());
                    System.out.println("City: " + dto.getCity());
                    System.out.println("Zip code: " + dto.getZipCode());
                    System.out.println("IsActive: " + dto.getIsActive());
                    System.out.println();
                });
    }
}