/***********************************************************************
Program Name: CurrencyConversion.java
Programmer's Name: Jason Franco
Program Description: Compute exchange rate between currencies.
***********************************************************************/

import javax.swing.JOptionPane;

public class CurrencyConversion
{
	// amount
		public static double MIN_AMOUNT = 1;
		public static double MAX_AMOUNT = 10000;
		
		// rate
		public static double MIN_RATE   = 0;
		public static double MAX_RATE   = 500;
		
	public static void main(String[] args)
	{
		double convertedAmount = 0;
		double amount = 0;
		double rate = 0;
	
		String fromCurrencyCode = JOptionPane.showInputDialog(null, "Enter Currency Code of the Input Amount: ", "Currency Conversion", JOptionPane.CLOSED_OPTION);
		System.out.println(fromCurrencyCode);
	
		String strAmount = JOptionPane.showInputDialog(null, "Enter Input Amount to be converted", "Currency Conversion", JOptionPane.CLOSED_OPTION);
		amount = Double.parseDouble(strAmount);
		System.out.println(amount);
		
		String toCurrencyCode = JOptionPane.showInputDialog(null, "Enter Currency Code for the currency you are converting to", "Currency Conversion", JOptionPane.CLOSED_OPTION);
		System.out.println(toCurrencyCode);
		
		// calculate rate
		rate = getRate(fromCurrencyCode, toCurrencyCode);
		
		// convert to amount
		convertedAmount = convert(rate, amount);
		
		// output result
		StringBuilder output = new StringBuilder();
		output.append(fromCurrencyCode + " converted to " + toCurrencyCode + " amount: " + convertedAmount);
		
		JOptionPane.showMessageDialog(null, output.toString());
	}
	
	public static double getRate(String fromCountry, String toCountry)
	{
		double rate = 0;
		String from = fromCountry;
		String to = toCountry;
		
		if (from.equals("USD"))
		{
			if (to.equals("GBP"))
			{
				rate = 0.66;
			}
			else if (to.equals("JPY"))
			{
				rate = 117.56;
			}
		}
		else if (from.equals("GBP"))
		{
			if(to.equals("USD"))
			{
				rate = 1.51;
			}
			else if (to.equals("JPY"))
			{
				rate = 178.07;
			}
		}
		else if (from.equals("JPY"))
		{
			if(to.equals("USD"))
			{
				rate = 0.01;
			}
			else if (to.equals("GBP"))
			{
				rate = 0.0056;
			}
		}
		return rate;
	}
	
	public static double convert(double rate, double amount)
	 {
		double value = 0;
		
		if ((rate > MIN_RATE && rate <= MAX_RATE) && (amount > MIN_AMOUNT && amount <= MAX_AMOUNT))
		{
			value = rate * amount;
		}
		return value;
	 }
}

