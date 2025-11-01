public class Account {
    protected String accountNumber;
    protected double balance;
    private Client owner;

    public Account(String accountNumber, double initialBalance, Client owner) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Client getOwner() {
        return owner;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Wplata " + amount + " na konto " + accountNumber + " zakonczona pomyslnie. Nowe saldo: " + balance);
        } else {
            System.out.println("Kwota wplaty musi byc dodatnia!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Wyplata " + amount + " z konta " + accountNumber + " zakonczona pomyslnie. Nowe saldo: " + balance);
        } else {
            System.out.println("Nieprawidlowa kwota wyplaty lub niewystarczajace srodki na koncie! " + accountNumber + ".");
        }
    }
} 