class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " đã được nạp vào tài khoản. Số dư hiện tại: " + balance);
        } else {
            System.out.println("Số tiền nạp phải lớn hơn 0.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Số dư không đủ.");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println(amount + " đã được rút. Số dư hiện tại: " + balance);
        } else {
            System.out.println("Số tiền rút phải lớn hơn 0.");
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if (amount > balance) {
            System.out.println("Số dư không đủ để chuyển khoản.");
        } else if (amount > 0) {
            this.balance -= amount;
            recipient.balance += amount;
            System.out.println(amount + " đã được chuyển tới " + recipient.accountHolder);
        } else {
            System.out.println("Số tiền chuyển phải lớn hơn 0.");
        }
    }

    public void display() {
        System.out.println("Tài khoản: " + accountNumber);
        System.out.println("Chủ tài khoản: " + accountHolder);
        System.out.println("Số dư: " + balance);
        System.out.println("---------------------------");
    }
}

public class Bai8 {
    public static void main(String[] args) {
        // Tạo hai tài khoản
        BankAccount account1 = new BankAccount("123456", "Thai Nguyen Gia Bao", 5000);
        BankAccount account2 = new BankAccount("789012", "Tran Thi Quynh Trang", 3000);

        account1.display();
        account2.display();

        account1.deposit(2000);
        account1.withdraw(1000);
        account1.transfer(account2, 1500);

        account1.display();
        account2.display();
    }
}
