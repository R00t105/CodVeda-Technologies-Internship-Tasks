import java.math.BigDecimal;

public class BankAccount {

    private String userName;
    private BigDecimal balance;

    public BankAccount() {}

    public BankAccount(String userName, BigDecimal balance) {
        this.userName = userName;
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "userName='" + userName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
            System.out.println("Deposited: " + amount + "\nBalance: " + getBalance());
        }
        else System.out.println("Money cannot be negative or zero");
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            System.out.println("Money cannot be negative or zero");

        else {
            if (amount.compareTo(getBalance()) > 0)
                System.out.println("Insufficient funds\nYour Balance is " + getBalance());
            else {
                setBalance(getBalance().subtract(amount));
                System.out.println("Withdrawn: " + amount + "\nBalance: " + getBalance());
            }
        }
    }
}
