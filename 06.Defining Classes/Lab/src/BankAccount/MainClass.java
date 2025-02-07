package BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();
        String command = sc.nextLine();
        while (!command.equals("End")) {
            String[] commandData = command.split("\\s+");

            switch (commandData[0]) {
                case "Create" -> {
                    BankAccount account = new BankAccount();
                    bankAccounts.put(account.getId(), account);
                    System.out.println("Account ID" + account.getId() + " created");
                }
                case "Deposit" -> {
                    int accountId = Integer.parseInt(commandData[1]);
                    int amountToDeposit = Integer.parseInt(commandData[2]);

                    if (bankAccounts.containsKey(accountId)) {
                        bankAccounts.get(accountId).deposit(amountToDeposit);
                        System.out.println("Deposited " + amountToDeposit + " to ID" + accountId);
                    } else {
                        System.out.println("Account does not exist");
                    }
                }
                case "SetInterest" -> {
                    double interest = Double.parseDouble(commandData[1]);
                    BankAccount.setInterestRate(interest);
                }
                case "GetInterest" -> {
                    int accountId = Integer.parseInt(commandData[1]);
                    int years = Integer.parseInt(commandData[2]);

                    if (bankAccounts.containsKey(accountId)) {
                        System.out.printf("%.2f%n", bankAccounts.get(accountId).getInterest(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                }
            }
            command = sc.nextLine();
        }
    }
}
