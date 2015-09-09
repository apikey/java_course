/***********************************************************************
Program Name: CheckingAccount.java
Programmer's Name: Jason Franco
Program Description: CheckingAccount class, a subclass of Account
***********************************************************************/
import helpers.OutputHelpers;

public class CheckingAccount extends Account
{
	public double OVER_DRAFT_FEE = 35;
	public double DEFAULT_INTEREST = 0.01;
	public double INTEREST_BALANCE = 3000;
	
	public CheckingAccount()
	{
		super(); // call the super class' default constructor
	}
	
	public CheckingAccount(String accountName, int accountID, double balance)
	{
		super(accountName, accountID, balance);
	}
	
	/* not sure how to prompt user about this */
	private void calculateOverDraftFee()
	{
		balance -= OVER_DRAFT_FEE;
	}
	
	@Override
	public void calculateInterest()
	{
		if (balance >= INTEREST_BALANCE)
			balance += balance * DEFAULT_INTEREST;
	}
	
	@Override
	public void processWithdrawal(double withdrawalAmnt)
	{
		int proceed = 0;
		
		if (withdrawalAmnt > balance)
		{
			proceed = OutputHelpers.showOKCancelDiaglog("If you make this withdrawal you will receive an overdraft charge of $35.00.  Are you sure you want to proceed with the withdrawal?",  "Warning");
			if (proceed == 0)
			{
				System.out.println("1 is yes");
				balance -= withdrawalAmnt;
				calculateOverDraftFee();
				OutputHelpers.showStandardDialog("You have been hit with an overdraft charge of $35.00", "Overdrawn");
			}
			else
			{
				System.out.println("1 is no");
			}
		}
		else
		{
			balance -= withdrawalAmnt;
			System.out.println("The withdrawal has been made.");
		}
	}
	
	@Override
	public String toString()
	{
		return String.format("Account name: %s %n Account ID: %d %n Account Balance: %d %n", getAccountName(), getAccountID(), getBalance()  );
	}
}