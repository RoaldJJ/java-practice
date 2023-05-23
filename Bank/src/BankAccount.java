public class BankAccount {

    String accountNumber;
    Double balance;
    boolean negativeBalance;

    public BankAccount (String accountNumber, Double balance, boolean negativeBalance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.negativeBalance = negativeBalance;
    }

    public BankAccount (String accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.negativeBalance = false;
    }
    public BankAccount (String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.00;
        this.negativeBalance = false;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    //deposit absolute values
    public void deposit (Double amount) {
        this.balance += Math.abs(amount);
    }

    //withdraw absolute values, checking if negative balance is allowed
    public void withdraw (Double amount) {

        if (this.balance < amount && !this.negativeBalance) {
            System.out.printf("Error: %.2f not withdrawn from %s, balance insufficient\n", amount, this.accountNumber);
        } else {
            this.balance -= Math.abs(amount);
        }
    }

    public String toString () {
        String numberString = String.valueOf(this.accountNumber);
        String balanceString = String.valueOf(this.balance);
        String accountString = numberString + ": " + balance;
        return accountString;
    }

    public void enableNegativeBalance () {
        this.negativeBalance = true;
    }


    public static void main(String[] args) {

        String number = "ddfgw422";
        Double amount = Double.valueOf(500);
        BankAccount account = new BankAccount(number, amount);
        System.out.println(account.getAccountNumber());
        System.out.println(account.getBalance());
        System.out.println(account.toString());
        account.deposit(500.00);
        account.withdraw(300.00);
        System.out.println(account.toString());

        account.withdraw(1000.00);

    }
}

