package entity;

public class BankCustomer {

    private String accountNumber;
    private double balance;
    private String username;
    private String password;
    private long createAt;
    private int status;

    public BankCustomer() {
    }

    public BankCustomer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public BankCustomer(String accountNumber, double balance, String username, String password, long createAt, int status) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.username = username;
        this.password = password;
        this.createAt = createAt;
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String numberAccount) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
