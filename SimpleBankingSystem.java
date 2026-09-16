import java.util.Random;
import java.util.Scanner;

class BankAccount {
    String name;
    int accountNumber;
    int pin;
    double balance;

    BankAccount(String name, int accountNumber, int pin, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    boolean checkPin(int enteredPin) {
        return pin == enteredPin;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    void displayDetails() {
        System.out.println("\n----- ACCOUNT DETAILS -----");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class SimpleBankingSystem {

    // Generate random 6-digit account number
    static int generateAccountNumber() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = null;

        System.out.println("<------SIMPLE BANKING SYSTEM------->");

        System.out.println("\nAre are you a new or existing customer?");
        System.out.println("1. New Customer");
        System.out.println("2. Existing Customer");

        System.out.print("Enter your choice: ");
        int customerChoice = sc.nextInt();

        if (customerChoice == 1) {

            System.out.println("\n----- CREATE NEW ACCOUNT -----");

            sc.nextLine();

            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.print("Create a 4-digit PIN: ");
            int pin = sc.nextInt();

            System.out.print("Enter initial deposit: ");
            double balance = sc.nextDouble();

            // Generate account number
            int accountNumber = generateAccountNumber();

            // Create account
            account = new BankAccount(
                name,
                accountNumber,
                pin,
                balance
            );

            // Show generated account number
            System.out.println("<-------ACCOUNT CREATED------->");
            System.out.println("Name           : " + name);
            System.out.println("Account Number : " + accountNumber);
            System.out.println("Initial Balance:" + balance);
            System.out.println("================================");

            System.out.println("\nIMPORTANT: Please remember your account number.");

        }

        
        else if (customerChoice == 2) {

            System.out.println("\n----- EXISTING CUSTOMER -----");

            System.out.print("Enter your account number: ");
            int enteredAccountNumber = sc.nextInt();

            System.out.print("Enter your PIN: ");
            int enteredPin = sc.nextInt();

            /*
             * Since this is a basic program without a database,
             * an example account is used for existing users.
             */
            if (enteredAccountNumber == 123456 &&
                enteredPin == 1234) {

                account = new BankAccount(
                    "Existing User",
                    123456,
                    1234,
                    5000
                );

                System.out.println("\nLogin successful!");

            } else {

                System.out.println("\nInvalid account number or PIN.");
                System.out.println("Access denied.");
                sc.close();
                return;
            }
        }

        else {
            System.out.println("Invalid choice.");
            sc.close();
            return;
        }

      

        int choice;

        do {

            System.out.println("\n========== BANKING MENU ==========");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.println("==================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();

                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();

                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayDetails();
                    break;

                case 5:
                    System.out.println("\nThank you for banking with us");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}