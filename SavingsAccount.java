public class SavingsAccount extends Account implements Transferable {

    public SavingsAccount(String accountNumber, double initialBalance, Client owner) {
        super(accountNumber, initialBalance, owner);
    }

    @Override
    public void transfer(Account destinationAccount, double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            destinationAccount.deposit(amount);
            System.out.println("Przelew " + amount + " z konta oszczednosciowego " + this.accountNumber + " na konto " + destinationAccount.getAccountNumber() + " zostal zrealizowany.");
        } else {
            System.out.println("Przelew nieudany. Niewystarczajace srodki lub nieprawidlowa kwota.");
        }
    }
}