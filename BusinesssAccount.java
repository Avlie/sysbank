public class BusinesssAccount extends Account implements Transferable {
    private String companyName;

    public BusinesssAccount(String accountNumber, double initialBalance, Client owner, String companyName) {
        super(accountNumber, initialBalance, owner);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public void transfer(Account destinationAccount, double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            destinationAccount.deposit(amount);
            System.out.println("Przelew biznesowy " + amount + " z konta " + this.accountNumber + " na konto " + destinationAccount.getAccountNumber() + " zostal zrealizowany.");
        } else {
            System.out.println("Przelew nieudany. Niewystarczajace srodki lub nieprawidlowa kwota.");
        }
    }
}
