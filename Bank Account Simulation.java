import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Account Class
class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return;
        }
        balance += amount;
        addTransaction("Deposited: " + amount + ", Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount;
        addTransaction("Withdrew: " + amount + ", Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println("\nTransaction History for " + accountHolderName + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private void addTransaction(String detail) {
        transactionHistory.add(new Date() + " - " + detail);
    }
}

// Main Class
public class BankSimulation {
    public static void main(String[] args) {
        Account acc = new Account("1001", "John Doe", 5000);

        acc.deposit(1500);
        acc.withdraw(2000);
        acc.withdraw(6000); // Should show insufficient funds
        acc.deposit(2500);

        System.out.println("\nFinal Balance: " + acc.getBalance());
        acc.printTransactionHistory();
    }
}
