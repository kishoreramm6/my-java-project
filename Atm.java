import java.util.*;

public class Atm {

    private static int[] pin = {6, 7, 7, 6};
    private static int balance = 1000000;
    private static List<String> transactionHistory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("WELCOME TO KRM BANK:");
        backToMenu();
    }

    public static void backToMenu() {
        System.out.println("PLEASE INSERT YOUR ATM CARD");

        try {
            System.out.println("PLEASE ENTER YOUR PIN NUMBER ");
            int enteredPin = scanner.nextInt();
            if (Arrays.equals(pin, new int[]{enteredPin / 1000, (enteredPin / 100) % 10, (enteredPin / 10) % 10, enteredPin % 10})) {
                showMenu();
            } else {
                System.out.println("Incorrect PIN. Try again.");
                backToMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("PIN MUST BE A 4-DIGIT NUMBER.");
            scanner.next(); // Clear the buffer
            backToMenu();
        }
    }

    public static void showMenu() {
        System.out.println("1. ADD AMOUNT\n2. CASH WITHDRAWAL\n3. CHECK BALANCE\n4. VIEW TRANSACTION HISTORY\n5. EXIT");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addAmount();
                break;
            case 2:
                withdrawAmount();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                viewTransactionHistory();
                break;
            case 5:
                System.out.println("THANKS FOR COMING!");
                break;
            default:
                System.out.println("Invalid option. Try again.");
                showMenu();
                break;
        }
    }

    public static void addAmount() {
        System.out.println("ENTER THE AMOUNT TO ADD IN YOUR BANK:");
        int add = scanner.nextInt();
        balance += add;
        String transaction = String.format("Added: %d, New Balance: %d, Date: %s", add, balance, new Date());
        transactionHistory.add(transaction);
        System.out.println("YOUR MONEY HAS BEEN SUCCESSFULLY ADDED: " + add);
        System.out.println("TOTAL BALANCE: " + balance);
        System.out.println("THANKS FOR COMING!");
        showMenu();
    }

    public static void withdrawAmount() {
        System.out.println("ENTER THE AMOUNT TO WITHDRAW:");
        int withdrawal = scanner.nextInt();
        if (withdrawal <= balance) {
            balance -= withdrawal;
            String transaction = String.format("Withdrawn: %d, New Balance: %d, Date: %s", withdrawal, balance, new Date());
            transactionHistory.add(transaction);
            System.out.println("YOUR MONEY HAS BEEN SUCCESSFULLY WITHDRAWN: " + withdrawal);
            System.out.println("TOTAL BALANCE: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
        System.out.println("THANKS FOR COMING!");
        showMenu();
    }

    public static void checkBalance() {
        System.out.println("YOUR TOTAL BALANCE: " + balance);
        System.out.println("THANKS FOR COMING!");
        showMenu();
    }

    public static void viewTransactionHistory() {
        System.out.println("TRANSACTION HISTORY:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
        System.out.println("THANKS FOR COMING!");
        showMenu();
    }
}
