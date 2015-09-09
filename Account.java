/***********************************************************************
Program Name: Account.java
Programmer's Name: Jason Franco
Program Description: Main Account class
***********************************************************************/
public class Account 
{
	// business constraints
	public static final int 		INVALID_ACCOUNT_ID = 0;
	public static final String 		INVALID_ACCOUNT_NAME = "Invalid Account";
	public static final double 		MIN_DEPOSIT = 25;
	public static final double 		MIN_BALANCE = 25;
	public static final double 		MAX_BALANCE = 200000;
	public static final double 		DEFAULT_INTEREST = 0.01;
	protected String accountName = 	INVALID_ACCOUNT_NAME;
	protected int accountID = 		INVALID_ACCOUNT_ID;
	protected double balance = 		MIN_DEPOSIT;
	
	
	// constructors
	public Account()
	{
		this(INVALID_ACCOUNT_NAME, INVALID_ACCOUNT_ID, MIN_DEPOSIT);
	}
	
	public Account(String accountName, int accountID, double balance)
	{
		// check the validity of the parameters
		this.accountName = accountName;
		this.accountID = accountID;
		this.balance = balance;
	}
	
	// getters
	public String getAccountName() { return accountName; }
	public int getAccountID() 	{ return accountID;   }
	public double getBalance() 	{ return balance;     }
	
	// setters 
	// * check that we have a string being entered here as the account name
	public void setAccountName(String accountName)
	{ 
		this.accountName = accountName; 
	}
	
	public void setAccountID(int accountID) { this.accountID = accountID; }
	public void setBalance(double balance) { this.balance = balance; }
	
	// calculation methods
	public void processDeposit(double depositAmnt) 
	{
		// * if the deposit amount is less than the minimum deposit amount
		// * if the depositAmnt plus the current balance are greater than maximum balance
		if ( depositAmnt < MIN_DEPOSIT || (depositAmnt + balance) > MAX_BALANCE )
		{
			StringBuilder errorMssg = new StringBuilder();
			errorMssg.append("Your deposit cannot be accepted.");
			errorMssg.append("\nDeposit must be a minumum of $25.00 and ");
			errorMssg.append("the current balance plus deposit amount must not exceed $" + MAX_BALANCE);
			throw new UnsupportedOperationException(errorMssg.toString());
		}
		else
		{
			balance += depositAmnt;
		}
	}
	public void processWithdrawal(double withdrawalAmount)
	{
		if ((balance - withdrawalAmount) < MIN_BALANCE || withdrawalAmount > balance )
		{
			StringBuilder errorMsg = new StringBuilder();
			errorMsg.append("Your withdrawal cannot be completed.");
			errorMsg.append("\nEither the withdrawal amount being requested will bring your ");
			errorMsg.append("account below the minimum balance of: $" + MIN_BALANCE);
			errorMsg.append("\n or you withdrawal amount exceeds the amount of funds in your account.");
			throw new UnsupportedOperationException(errorMsg.toString());
		}
		else
		{
			balance -= withdrawalAmount;
		}
	}
	
	public void calculateInterest()
	{
		balance += balance * DEFAULT_INTEREST;
	}
	
	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", accountID="
				+ accountID + ", balance=" + balance + "]";
	}
	
	
	
	
}