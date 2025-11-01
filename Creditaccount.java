public class Creditaccount extends Account {
    private double creditLimit;

    public Creditaccount(String accountNumber, double initialBalance, Client owner, double creditLimit) {
        super(accountNumber, initialBalance, owner);
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (this.balance + this.creditLimit) >= amount) {
            this.balance -= amount;
            System.out.println("Wyplata (kredytowa) " + amount + " z konta " + accountNumber + " zakonczona pomyslnie. Nowe saldo: " + balance);
        } else {
            System.out.println("Przekroczono limit kredytowy lub nieprawidlowa kwota.");
        }
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}