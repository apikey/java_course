/***********************************************************************
Program Name: Bank.java
Programmer's Name: Jason Franco
Program Description: Class to hold bank info
***********************************************************************/
public class Bank 
{
	public static final String INVALID_BANK_NAME = "Invalid Bank";
	public static final int INVALID_ROUTING_NUM = 0;
	public static final int NUMBER_ACCOUNTS = 2;
	
	private String bankName;
	private int routingNumber;

	
	private CheckingAccount checkingAccount = new CheckingAccount();
	private SavingsAccount savingsAccount = new SavingsAccount();
	
	private Account[] accountList = { checkingAccount, savingsAccount };
	public Bank()
	{
		bankName = INVALID_BANK_NAME;
		routingNumber = INVALID_ROUTING_NUM;
	}
	
	public Bank(String bankName, int routingNumber)
	{
		this.bankName = bankName;
		this.routingNumber = routingNumber;
	}
	
	// getters
	public String getBankName()
	{
		return bankName;
	}
	public int getRoutingNumber()
	{
		return routingNumber;
	}
	public Account[] getAccountList()
	{
		return accountList;
	}
	public CheckingAccount getCheckingAccount()
	{
		return checkingAccount;
	}
	public SavingsAccount getSavingsAccount()
	{
		return savingsAccount;
	}
	
	// setters
	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}
	public void setRoutingNumber(int routingNumber)
	{
		this.routingNumber = routingNumber;
	}
	public void setCheckingAccount(CheckingAccount checkingAccount)
	{
		this.checkingAccount = checkingAccount;
	}
	public void setSavingsAccount(SavingsAccount savingsAccount)
	{
		this.savingsAccount = savingsAccount;
	}
	public void setAccountList(Account[] accountList)
	{
		this.accountList = accountList;
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("Bank Name: " + bankName);
		str.append("Routing Number: " + routingNumber);
		return str.toString();
	}
}
