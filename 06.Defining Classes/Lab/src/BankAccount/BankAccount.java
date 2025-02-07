package BankAccount;

public class BankAccount {
    private static int createdAccounts = 1;
    private static double interestRate = 0.02;
    private int id;
    private double balance;

    public BankAccount() {
        this.balance = 0;
        this.id = createdAccounts++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public double getInterest(int years) {
        return years * (interestRate * balance);
    }

    public void deposit(double amount) {
        if (amount < 0) {
            amount = 0;
        }
        this.balance += amount;
    }
}
