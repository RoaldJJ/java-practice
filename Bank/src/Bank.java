import java.util.ArrayList;

public class Bank {

    ArrayList<BankAccount> BankAccounts = new ArrayList<BankAccount>();;

//    public void Bank () {
//        ArrayList<BankAccount> this.BankAccounts=new ArrayList<>();
//    }
public void createAccount (String number, Double balance, boolean negativeBalance) {
    BankAccount account = new BankAccount(number, balance, negativeBalance);
    this.BankAccounts.add(account);
}
    public void createAccount (String number, Double balance) {
        BankAccount account = new BankAccount(number, balance);
        this.BankAccounts.add(account);
    }

    public void createAccount (Double balance) {
        double randomDouble  = Math.random() * Math.pow(10,9);
        int randomInt = (int) randomDouble;
        String accountSuffix = String.format("%09d", randomInt);
        String number = "BANK" + accountSuffix;
        BankAccount account = new BankAccount(number, balance);
        this.BankAccounts.add(account);
    }

    public void createAccount () {
        double randomDouble  = Math.random() * Math.pow(10,9);
        int randomInt = (int) randomDouble;
        String accountSuffix = String.format("%09d", randomInt);
        String number = "BANK" + accountSuffix;
        BankAccount account = new BankAccount(number, 0.00);
        this.BankAccounts.add(account);
    }

    public BankAccount getAccount (String number) {
        for (BankAccount account : this.BankAccounts) {
            if (number.equals(account.accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public Integer getIndex (String number) {
        for (BankAccount account : this.BankAccounts) {
            if (number.equals(account.accountNumber)) {
                return this.BankAccounts.indexOf(account);
            }
        }
        return null;
    }
//
    public void deposit (String number, double amount) {
        BankAccount account = this.getAccount(number);
        int index = this.getIndex(number);
        account.deposit(amount);
        this.BankAccounts.set(index, account);
    }
//
    public void withdraw (String number, double amount) {
        BankAccount account = this.getAccount(number);
        int index = this.getIndex(number);
        account.withdraw(amount);
        this.BankAccounts.set(index, account);
    }

    public void printBalance (String number) {
        int index = this.getIndex(number);
        System.out.println(this.BankAccounts.get(index).balance);
    }

    public String getLastAccountString () {
        return this.BankAccounts.get(this.BankAccounts.size()-1).accountNumber;
    }

    public static void main(String[] args) {

        Bank bank = new Bank();
        bank.createAccount("BANK662948306", 500.00);
        bank.createAccount("BANK900268306", 800.00);
        bank.createAccount("BANK862949300", 580.00);

        //System.out.println(bank.BankAccounts);
//        for (BankAccount accounts : bank.BankAccounts) {
//            System.out.println(accounts);
//        }
        bank.printBalance("BANK862949300");
        bank.deposit("BANK862949300", 110.00);
        bank.printBalance("BANK862949300");
        bank.withdraw("BANK862949300", 1000.00);
        bank.printBalance("BANK862949300");

        bank.createAccount();
        System.out.println(bank.getLastAccountString());



//        bank.BankAccounts.indexOf("BANK662948306");
//        double someNumber = 0.99428*Math.pow(10,9);
//        int someNumber2 = (int) someNumber;
//        System.out.println(String.format("%09d", someNumber2));

    }
}
