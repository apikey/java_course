/***********************************************************************
Program Name: SavingsAccount.java
Programmer's Name: Jason Franco
Program Description: SavingsAccount class, a subclass of SavingsAccount
***********************************************************************/

public class SavingsAccount extends Account
{
	public static double INTEREST_BALANCE_HIGH = 5000;
	public static double INTEREST_BALANCE_MEDIUM = 3000;
	public static double INTEREST_HIGH = 0.04;
	public static double INTEREST_MEDIUM = 0.03;
	public static double INTEREST_LOW = 0.02;
	
	public SavingsAccount()
	{
		super();
	}
	
	public SavingsAccount(String accountName, int accountID, double balance)
	{
		super(accountName, accountID, balance);
	}
	
	@Override
	public void calculateInterest()
	{
		if (balance >= INTEREST_BALANCE_HIGH)
			balance += balance * INTEREST_HIGH;
		else if (balance >= INTEREST_BALANCE_MEDIUM)
			balance += balance * INTEREST_MEDIUM;
		else if (balance > 0)
			balance += balance * INTEREST_LOW;
	}
	
	public void processWithdrawal(double amount)
	{
		balance -= amount;
	}
}