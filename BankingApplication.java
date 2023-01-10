import java.util.Scanner;

public class BankingApplication {
  public static void main(String[] args) {
    BankAccount b = new BankAccount("Rajkumar", "XY8873");
    b.showMenu();
  }
}

class BankAccount {
  private int balance;
  private int previousTransaction;
  private String customerName;
  private String customerID;

  public BankAccount(String customerName, String customerID) {
    this.customerName = customerName;
    this.customerID = customerID;
  }

  public void deposit(int amount) {
    if (amount != 0) {
      balance += amount;
      previousTransaction = amount;
    }
  }

  public void withdraw(int amount) {
    if (amount != 0) {
      balance -= amount;
      previousTransaction -= amount;
    }
  }

  public void getPreviousTransaction() {
    if (previousTransaction > 0)
      System.out.println("Deposited: " + previousTransaction);
    else if (previousTransaction < 0)
      System.out.println("Withdrawn: " + Math.abs(previousTransaction));
    else
      System.out.println("No transaction occured");
  }

  public void showMenu() {

    System.out.println("Welcome " + customerName);
    System.out.println("Your ID is " + customerID);
    System.out.println("\n");

    while (true) {
      System.out.println("1. Check Balance");
      System.out.println("2. Deposit");
      System.out.println("3. Withdraw");
      System.out.println("4. Previous transaction");
      System.out.println("5. Exit");

      int option;
      Scanner sc = new Scanner(System.in);
      System.out.println("====================================================");
      System.out.print("Enter an option: ");
      option = sc.nextInt();
      System.out.println("====================================================");

      switch (option) {
        case 1:
          System.out.println("Balance = " + balance);
          System.out.println("\n");
          break;

        case 2:
          System.out.print("Enter an amount to deposit:");
          int amount = sc.nextInt();
          deposit(amount);
          System.out.println("\n");
          break;

        case 3:
          System.out.print("Enter an amount to withdraw:");
          int amount2 = sc.nextInt();
          withdraw(amount2);
          System.out.println("\n");
          break;

        case 4:
          getPreviousTransaction();
          System.out.println("\n");
          break;

        case 5:
          System.exit(0);
          break;

        default:
          System.out.println("Invalid option!! Please enter again");

      }
    }
  }
}
