/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import javax.swing.JOptionPane;

public class SavingsBankAccount extends BankAccount{
    int minBalance ;

    public SavingsBankAccount(int minBalance ,double balance, int ID) {
        super(balance, ID);
        this.minBalance = minBalance;
    }
    public SavingsBankAccount(double balance, int ID) {
        super(balance, ID);
        
    }
    public SavingsBankAccount() {
        this.minBalance = 1000;
    }
    
    

    @Override
    public boolean withraw(double withdraw) {
        if (super.balance-withdraw < minBalance) {
            JOptionPane.showMessageDialog(null, "Balance must be at least 1000");
            return false;
        }
        else return super.withraw(withdraw);
    }

    @Override
    public boolean deposit(double deposit) {
        if (deposit < 100) {
            JOptionPane.showMessageDialog(null, "Deposit must be at least 100");
            return false;
        }
        return super.deposit(deposit); 
    }
    
}
