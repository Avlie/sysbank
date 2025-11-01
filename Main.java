import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Transferable {
    void transfer(Account destinationAccount, double amount);
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client1 = new Client("Piotr Nowak", "ul. Zgierska 67, Lodz");
        Client client2 = new Client("Firma Szympans", "ul. Puszkowo 7, Pies");

        SavingsAccount savings = new SavingsAccount("SUS-123", 5000.00, client1);
        CheckingAccount checking = new CheckingAccount("CH-456", 1200.50, client1);
        BusinesssAccount business = new BusinesssAccount("BU-789", 25000.00, client2, "Firma Szympans");
        Creditaccount credit = new Creditaccount("CR-666", 0, client1, 2000.00);

        List<Account> allAccounts = new ArrayList<>();
        allAccounts.add(savings);
        allAccounts.add(checking);
        allAccounts.add(business);
        allAccounts.add(credit);

        boolean running = true;

        while (running) {
            System.out.println("═════ MENU BANKOWE ═════ ");
            System.out.println("1. Sprawdz saldo konta");
            System.out.println("2. Wplata");
            System.out.println("3. Wyplata");
            System.out.println("4. Przelew");
            System.out.println("5. Wyjscie");
            System.out.print("Wybierz opcje: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Podaj numer konta: ");
                    String accountNumber = scanner.nextLine();
                    Account acc = findAccount(allAccounts, accountNumber);
                    if (acc != null) {
                        System.out.println("Saldo konta " + acc.getAccountNumber() + ": " + acc.getBalance());
                    } else {
                        System.out.println("Nie znaleziono konta o takim numerze.");
                    }
                    break;

                case 2:
                    System.out.print("Podaj numer konta do wplaty: ");
                    accountNumber = scanner.nextLine();
                    acc = findAccount(allAccounts, accountNumber);
                    if (acc != null) {
                        System.out.print("Podaj kwote: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        acc.deposit(amount);
                    } else {
                        System.out.println("Nie znaleziono konta.");
                    }
                    break;

                case 3:
                    System.out.print("Podaj numer konta do wyplaty: ");
                    accountNumber = scanner.nextLine();
                    acc = findAccount(allAccounts, accountNumber);
                    if (acc != null) {
                        System.out.print("Podaj kwote: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        acc.withdraw(amount);
                    } else {
                        System.out.println("Nie znaleziono konta.");
                    }
                    break;

                case 4:
                    System.out.print("Podaj numer konta zrodlowego: ");
                    String source = scanner.nextLine();
                    Account sourceAcc = findAccount(allAccounts, source);

                    System.out.print("Podaj numer konta docelowego: ");
                    String target = scanner.nextLine();
                    Account targetAcc = findAccount(allAccounts, target);

                    if (sourceAcc instanceof Transferable) {
                        System.out.print("Podaj kwote przelewu: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        ((Transferable) sourceAcc).transfer(targetAcc, amount);
                    } else {
                        System.out.println("Wybrane konto nie obsluguje przelewow.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Do widzenia!");
                    break;

                default:
                    System.out.println("Niepoprawna opcja.");
            }
        }

        scanner.close();
    }

    private static Account findAccount(List<Account> accounts, String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }
}