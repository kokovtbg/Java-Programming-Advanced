package DefiningClasses.lab;

public class BankAccount {
    private int id;
    private double balance;
    private double interestRate;

    public void setInterestRate(double interest) {
        this.interestRate = interest;
    }

    public double getInterest(int years) {
        return balance * years * interestRate;
    }

    public double deposit(double amount) {
        return this.balance += amount;
    }

    public BankAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.interestRate = 0.02;
    }


}
