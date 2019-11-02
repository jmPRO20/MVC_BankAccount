
import java.awt.Canvas;
import java.util.Observable;

/**
	File name: BankAccountModel.java
	Short description: ??????
	IST 242 Assignment:  
	@author Joshua Michaels
	@version 1.01 2014-08-25
	date of last revision:
	details of the revision: none
*/




/**
 *
 * @author Joshua
 */

interface Observer
{	void update(Observable t, Object o);	
}

public class BankAccountModel extends java.util.Observable {

    private String listInput = " ";
    private double deposit = 0.0;
    private double savingsTotal = 0.0;
    private double checkingTotal = 0.0;
    private String accountType = " ";
    private double accessDeposit = 0.0;
    private double accessWithdraw = 0.0;
    private double accessTotal = 0.0;
    private double balance = 0.0;
    
    public String getListInput() {return listInput;}
    
    public double getDeposit() {return deposit;}
    
    public double getSavingsTotal() {return savingsTotal;}
    
    public double getCheckingTotal() {return checkingTotal;}
    
    public String getAccountType() {return accountType;}
    
    public void setTotal(double t)
    {
        if (accountType.equals("Savings Account"))
        {
            savingsTotal += t;
            setChanged();
            notifyObservers();
        }
        
        else if (accountType.equals("Checking Account"))
        {
            checkingTotal += t;
            setChanged();
            notifyObservers();
        }
        
    }
    public void setAccountType(Object type)
    {
        accountType = type.toString();
        setChanged();
        notifyObservers();
    }
    
    public void setDeposit(double d) {
        
        deposit = d;
        setChanged();
        notifyObservers();
    }
    
    public double getAccessDeposit() {return accessDeposit;}
    
    public double getAccessWithdraw() {return accessWithdraw;}
    
    public double getBalance() {return balance;}
    
    public void setAccessDeposit(double dp) {
        
        accessDeposit = dp;
        setChanged();
        notifyObservers();
    }
    
    public void setAccessWithdraw(double w) {
        
        accessWithdraw = w;
        setChanged();
        notifyObservers();
    }
    
    public void setBalance(double b)
    {
        balance = b;
        setChanged();
        notifyObservers();
    }
    
}
