public class Account {
    private int id;
    private double balance;

    // Constructor
    public Account(int id) {
        this.id = id;
        this.balance = 0;
    }

    // Getters
    public int getId() {
        return this.id;
    }
    public double getBalance() {
        return this.balance;
    }

    // Increase and decrease balance
    public boolean addBalance(double value) {
        // Check for negative increases
        if (value < 0) {
            return false;
        }
        this.balance += value;
        return true;
    }
    public boolean subtractBalance (double value) {
        // Check for negative decreases
        if (value < 0) {
            return false;
        }
        // Balance value can't be negative. At least in my bank ;)
        if (this.balance - value < 0) {
            return false;
        }
        this.balance -= value;
        return true;
    }
}