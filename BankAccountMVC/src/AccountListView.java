/**
	File name: AccountList.java
	Short description: ??????
	IST 242 Assignment:  
	@author Joshua Michaels
	@version 1.01 2014-08-25
	date of last revision:
	details of the revision: none
*/




import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import javax.swing.*;
/**
 *
 * @author Joshua
 */
public class AccountListView implements java.util.Observer {
    
    private JTextArea listArea; 
    private String label = "Account List";
    private BankAccountModel model;
    private Frame accountFrame;
    
    
    AccountListView(BankAccountModel model, int h, int v)
    {
        
        this.model = model;
        listArea = new JTextArea(10, 10);
        accountFrame = new Frame(label);
        accountFrame.setSize(500, 500);
        accountFrame.setLocation(h, v);
        accountFrame.add("North", new Label(label));
        accountFrame.add("Center", listArea);
        accountFrame.addWindowListener(new CloseListener());
        accountFrame.setVisible(true);
        model.addObserver(this);
        
    }

       

    
    public static class CloseListener extends WindowAdapter
	{	public void windowClosing(WindowEvent e)
		{	e.getWindow().setVisible(false);
			System.exit(0);
		}
	}
protected BankAccountModel model() {return model;}

    @Override
    public void update(Observable t, Object o) // Called from the Model
	{	      
            if (model.getAccountType().equals("Savings Account"))
            {               
                listArea.setText("Account Type: " + model.getAccountType() + "" + "\n" + "Amount Deposited: " + model.getDeposit() + "" + "\nTotal: " + model.getSavingsTotal() + "");	
            }
    }
}
