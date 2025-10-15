import java.util.*;
import java.util.random.*;

public class BankAccount {
    //Attributes
    private final Person accountHolder;
    private String accountNumber;
    private double currentBalance;

    //Getters and Setters

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //Constructors
    public BankAccount(Person accountHolder, double currentBalance){
        this.accountNumber=generateaccountnum();
        this.accountHolder=accountHolder;
        if (currentBalance >= 0){
            this.currentBalance=currentBalance;
        }else{
            this.currentBalance= 0.0;
        }
    }

    public BankAccount(String accHolder, double currentBalance){
        this.accountNumber = generateaccountnum();
        this.accountHolder = new Person(accHolder);
        if (currentBalance >= 0) {
            this.currentBalance = currentBalance;
        } else {
            this.currentBalance = 0.0;
        }
    }


    //Methods
    private String generateaccountnum(){
        int random = 100000 + (int)(Math.random() * 900000);
        return String.valueOf(random);
    }

    public void deposit(double cash){
        if(cash > 0){
            System.out.println("\nOld Balance : " + currentBalance + " EGP");
            this.currentBalance += cash;
            System.out.println("Deposit Amount: " + cash + " EGP");
            System.out.println("New Balance: " + currentBalance + " EGP\n");
        } else {
            System.out.println("\nInvalid deposit amount. Amount must be positive.");
        }
    }

    public void withdraw(double cash){
        if (cash <= 0){
            System.out.println("Insufficient funds. Withdrawal failed, NO BALANCE");
        }else if (cash <=currentBalance){
            this.currentBalance -= cash;
            System.out.println("Successful Withdrawl : " +cash + "EGP");
            System.out.println("New Balance : " + currentBalance);
        }else if ( cash > currentBalance){
            System.out.println("Withdraw Attempt : " + cash + "EGP");
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void checkBalance(){
        System.out.println("\nCurrent Balance: " + currentBalance + " EGP\n");
    }

    public void displayFullAccountInfo() {
        System.out.println("\n===================================");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + accountHolder.getName());
        System.out.println("Initial Balance: " + currentBalance + " EGP");
        System.out.println("===================================");
    }

}