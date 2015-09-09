
/***********************************************************************
Program Name: AccountTest.java
Programmer's Name: Jason Franco
Program Description: Runs program that asks for user bank and account
info and then displays banking information.
***********************************************************************/
import helpers.ApplicationHelpers;
import helpers.InputHelpers;
import helpers.OutputHelpers;

public class AccountTest
{
	public static void main(String[] args)
	{
		// application start
		displayApplicationHeader();
		
		// bank object and adding to account type objects
		Bank aBank = new Bank();
		
		// prompt for bank information
		collectBankInformation(aBank);
		
		// calculate interest for each account
		aBank.getCheckingAccount().calculateInterest();
		aBank.getSavingsAccount().calculateInterest();
		
		// display info
		displayBankInformation(aBank);
		
		// end application
		terminateApplication();
	}
	
	private static void displayApplicationHeader() 
	{
		ApplicationHelpers.displayApplicationInformation("Account", "3", "Account information");
	}
	
	private static void collectBankInformation(Bank aBank)
	{
		aBank.setBankName(InputHelpers.getString("your bank name"));
		aBank.setRoutingNumber(InputHelpers.getIntegerInput("your bank routing number"));
		
		// get account information
		collectAccountInformation(aBank.getCheckingAccount(), "Checking");
		collectAccountInformation(aBank.getSavingsAccount(), "Savings");
		
	}
	
	private static void collectAccountInformation(Account aAccount, String typeOfAccount)
	{
		String dataInput;
		
		dataInput = "Enter " + typeOfAccount + " account information";
		OutputHelpers.showStandardDialog(dataInput, typeOfAccount + " Account Information");
		
		aAccount.setAccountName(typeOfAccount);
		
		aAccount.setAccountID( InputHelpers.getIntegerInput("your Account ID"));
		aAccount.setBalance( InputHelpers.getDoubleInput("your initial Account Balance"));
		
		makeDeposit(aAccount);
		makeWithdrawal(aAccount);
	}
	
	private static void makeDeposit(Account aAccount)
	{
		aAccount.processDeposit(InputHelpers.getDoubleInput("deposit amount($25.00 or more only)"));
	}
	
	private static void makeWithdrawal(Account aAccount)
	{
		aAccount.processWithdrawal(InputHelpers.getDoubleInput("the amount to withdraw"));
	}
	
	private static void displayBankInformation(Bank aBank)
	{
		StringBuilder str = new StringBuilder();
		str.append("Bank Name: " + aBank.getBankName() + "    Routing Number: " + aBank.getRoutingNumber());
		str.append("\n-------------------------------------------------------------------------");
		
		// display checking account info;
		str.append("\nAccount Name: " + aBank.getCheckingAccount().getAccountName());
		str.append("    Account ID: " + aBank.getCheckingAccount().getAccountID());
		str.append("    Account Balance: $" + String.format("%,.2f", aBank.getCheckingAccount().getBalance()));
		
		// display savings account info
		str.append("\nAccount Name: " + aBank.getSavingsAccount().getAccountName());
		str.append("    Account ID: " + aBank.getSavingsAccount().getAccountID());
		str.append("    Account Balance: $" + String.format("%,.2f", aBank.getSavingsAccount().getBalance()));
		
		OutputHelpers.showStandardDialog(str.toString(), "Bank and Account Summary" );
	}
	
	private static void terminateApplication()
	{
		// Add in the application name
		ApplicationHelpers.terminateApplication("Account");
	}
	
}	
