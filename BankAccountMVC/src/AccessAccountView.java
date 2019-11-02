/**
	File name: AccessAccount.java
	Short description: ??????
	IST 242 Assignment:  
	@author Joshua Michaels
	@version 1.01 2014-08-25
	date of last revision:
	details of the revision: none
*/



import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;
/**
 *
 * @author Joshua
 */


public class AccessAccountView implements java.util.Observer {

    private BankAccountModel model;
    private JTextField selectAccount;
    private JTextField deposit;
    private JTextField withdraw;
    private JTextField balance;
    private Button depositButton;
    private Button withdrawButton;
    private Frame accessFrame;
    private String label = "Access Account";
    
    AccessAccountView(BankAccountModel model, int h, int v)
    {
        this.model = model;
        depositButton = new Button("Deposit");
        withdrawButton = new Button("Withdraw");
        Panel p = new Panel();
        selectAccount = new JTextField(10);
        deposit = new JTextField(10);
        withdraw = new JTextField(10);
        balance = new JTextField(10);
        balance.setEditable(false);
        balance.setText("0.0");
        depositButton.addActionListener(new DepositListener());
        withdrawButton.addActionListener(new WithdrawListener());
        accessFrame = new Frame(label);
        accessFrame.setSize(500, 500);
        accessFrame.setLocation(h, v);
        accessFrame.add("North", new Label(label));
        p.add(selectAccount);
        p.add(new Label("Account Name"));
        p.add(deposit);
        p.add(depositButton);
        p.add(withdraw);
        p.add(withdrawButton);
        p.add(new Label("Balance"));
        p.add(balance);
        accessFrame.add(p);
        accessFrame.addWindowListener(new AccountListView.CloseListener());
        accessFrame.setVisible(true);
        model.addObserver(this);
    }

    protected BankAccountModel model() {return model;}
    
    class DepositListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            model.setAccessDeposit(Double.parseDouble(deposit.getText()));
            model.setBalance(Double.parseDouble(balance.getText()) - Double.parseDouble(deposit.getText()));
            
            if (model.getBalance() <= 0.0)
            {
                model.setBalance(0.0);
            }
             
            balance.setText(model.getBalance() + "");
            
        }
        
    }
    
    class WithdrawListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
        
            model.setAccessWithdraw(Double.parseDouble(withdraw.getText()));
            model.setBalance(Double.parseDouble(balance.getText()) + Double.parseDouble(withdraw.getText()));
            balance.setText(model.getBalance() + "");
        }
        
    }
    
    @Override
    public void update(Observable o, Object o1) {}
}
