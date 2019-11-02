/**
	File name: CreateAccount.java
	Short description: ??????
	IST 242 Assignment:  
	@author Joshua Michaels
	@version 1.01 2014-08-25
	date of last revision:
	details of the revision: none
*/



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import javax.swing.*;
/**
 *
 * @author Joshua
 */
public class CreateAccountView  implements java.util.Observer {

    
    private JComboBox accountType;
    private TextField initDeposit;
    private Button createButton;
    private String label = "Create Account";
    private BankAccountModel model;
    private Frame createFrame;
    
    CreateAccountView(BankAccountModel model, int h, int v)
    {
        
        this.model = model;
        accountType = new JComboBox();
        Label depositLabel = new Label("Initial Deposit");
        initDeposit = new TextField(10);
        createButton = new Button("Create");
        createButton.addActionListener(new DepositListener());
        accountType.addItem("Select Account");
        accountType.addItem("Savings Account");
        accountType.addItem("Checking Account");
        Panel p = new Panel();
        p.setSize(h, v);
        p.add(accountType);
        p.add(depositLabel);
        p.add(initDeposit);
        p.add(createButton);
        createFrame = new Frame(label);
        createFrame.setSize(500, 500);
        createFrame.setLocation(h, v);
        createFrame.add(p);
        createFrame.addWindowListener(new CloseListener());
        createFrame.setVisible(true);
        model.addObserver(this);
    }

    class CloseListener extends WindowAdapter
	{	public void windowClosing(WindowEvent e)
		{	e.getWindow().setVisible(false);
			System.exit(0);
		}
	}
    
    class DepositListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
                  
            model.setDeposit(Double.parseDouble(initDeposit.getText())); 
            model.setAccountType(accountType.getSelectedItem());           
            model.setTotal(model.getDeposit());
            
        }
        
    }
    @Override
    public void update(Observable o, Object o1) {}
    
    
}
