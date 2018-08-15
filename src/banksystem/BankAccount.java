
package banksystem;

import javax.swing.JOptionPane;

public class BankAccount {
        protected double balance;
    protected int ID;
    
    
    public BankAccount() {
        this.balance = 0.0;
    }

    public BankAccount(double balance, int ID) {
        this.balance = balance;
        this.ID = ID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public boolean withraw(double withdraw){
        if (withdraw <= 0 || withdraw > balance ) {
            JOptionPane.showMessageDialog(null, "Withdraw Error");
            return false;
        }
        else balance -= withdraw;
        return true;
    }
    
    public boolean deposit(double deposit){
        if (deposit <= 0 ) {
            JOptionPane.showMessageDialog(null, "Deposit Error");
            return false;
        }
        else balance += deposit;
        return true;
    }
    
    
}
