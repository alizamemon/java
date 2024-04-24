package exception;

class BalanceOutException extends Exception {
    public BalanceOutException() {
        super("Balance not found");
    }

    public BalanceOutException(String a) {
        super(a);
    }
}

class Account {
    private int balance;

    public Account(int b) {
        balance = b;
    }

    public void withdraw(int amount) throws BalanceOutException {
        if (amount > balance) {
            throw new BalanceOutException();
        } else {
            balance = balance - amount;
        }
    }
}

public class test {
    public static void main(String[] args) {
        Account a = new Account(5000);
        try {
            a.withdraw(6000);
        } 
        catch (BalanceOutException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
