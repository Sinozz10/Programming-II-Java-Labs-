import java.util.*;

public class Lab3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;
        String input ;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    double balance = 0.0;
                    account = new BankAccount(name, balance);
                    System.out.println("Account created!");
                    account.displayFullAccountInfo();
                    break;

                case "2":
                    if (account == null) {
                        System.out.println("Please create an account first!");
                    } else {
                        System.out.print("Enter deposit amount: ");
                        input = sc.nextLine();
                        double depositAmount = Double.parseDouble(input);
                        account.deposit(depositAmount);
                    }
                    break;

                case "3":
                    if (account == null) {
                        System.out.println("Please create an account first!");
                    } else {
                        System.out.print("Enter withdrawal amount: ");
                        input = sc.nextLine();
                        double withdrawAmount = Double.parseDouble(input);
                        account.withdraw(withdrawAmount);
                    }
                    break;

                case "4":
                    if (account == null) {
                        System.out.println("Please create an account first!");
                    } else {
                        account.checkBalance();
                    }
                    break;

                case "5":
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        } while(!input.equals("5"));
        sc.close();
    }
}