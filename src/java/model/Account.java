package model;
import javax.faces.bean.ApplicationScoped;



/* Written by Kihoon, Lee (c0663965) */

@ApplicationScoped
public class Account {
    
    private double balance;
    private double withdraw;
    private double deposit;

    public Account() {
        balance=0.0;
        withdraw=0.0;
        deposit=0.0;
    }

    public Account(double balance) {
        this.balance = balance;
        this.withdraw =0;
        this.deposit =0;
    }

    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance){
        this.balance=balance;
    }

    public void deposit(double cash) {
        balance+=cash;
    }
    
    public void withdraw(double cash) {
        balance-=cash;
    }
    
    public void closeAccount() {
        balance=0.0;
    }
}