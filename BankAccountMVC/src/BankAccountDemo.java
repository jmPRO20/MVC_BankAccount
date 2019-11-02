/**
	File name: BankAccountDemo.java
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
public class BankAccountDemo {

    public static void main(String[] args) {
        BankAccountModel b = new BankAccountModel();
        AccountListView a = new AccountListView(b, 200,50);
        CreateAccountView c = new CreateAccountView(b, 200, 550);
        AccessAccountView av = new AccessAccountView(b, 700, 50);
    }
}
