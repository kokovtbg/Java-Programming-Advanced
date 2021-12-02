package DefiningClasses.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBankAccount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<BankAccount> accounts = new ArrayList<>();
        int countAccounts = 0;
        String command = scan.nextLine();
        while (!command.equals("End")) {
            String[] data = command.split("\\s+");
            if (command.equals("Create")) {
                countAccounts++;
                BankAccount bankAccount = new BankAccount(countAccounts, 0);
                accounts.add(bankAccount);
                System.out.printf("Account ID%d created%n", countAccounts);
            }
            if (data[0].equals("Deposit")) {
                int id = Integer.parseInt(data[1]);
                int amount = Integer.parseInt(data[2]);
                if (id <= countAccounts) {
                    BankAccount bankAccount = accounts.get(id - 1);
                    bankAccount.deposit(amount);
                    accounts.set(id - 1, bankAccount);
                    System.out.printf("Deposited %d to ID%d%n", amount, id);
                } else {
                    System.out.printf("Account does not exist%n");
                }
            }
            if (data[0].equals("SetInterest")) {
                for (BankAccount account : accounts) {
                    account.setInterestRate(Double.parseDouble(data[1]));
                }
            }
            if (data[0].equals("GetInterest")) {
                int id = Integer.parseInt(data[1]);
                int years = Integer.parseInt(data[2]);
                if (id <= countAccounts) {
                    BankAccount bankAccount = accounts.get(id - 1);
                    System.out.printf("%.2f%n", bankAccount.getInterest(years));
                } else {
                    System.out.printf("Account does not exist%n");
                }
            }

            command = scan.nextLine();
        }
    }
}
