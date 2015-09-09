/*********************************************************************** 
Program Name: SalesTracking.java 
Programmer's Name: Jason Franco 
Program Description: Track monthly sales, arverage yearly sales, 
total sales for the year, and which month has the highest sales 
and which month had the lowest sales. The program should prompt the user 
for the sales for each month starting with January.  After all the 
monthly sales have been entered, your program should have methods
that do the following:
***********************************************************************/

import java.util.Scanner;


public class SalesTracking
{
	/* Prompt for each month's sales amount and store values */
	public static double[] getSales(String[] monthArray)
	{	
		Scanner input = new Scanner(System.in);
		double monthAmount = 0;
		double[] monthlySales = new double[12];
		for (int i = 0; i < monthArray.length; i++)
		{
			System.out.printf("Enter the sales for %s: ", monthArray[i]);
			monthAmount = input.nextFloat();
			monthlySales[i] = monthAmount;
		}
		return monthlySales;
	}


	public static double computeTotalSales(double[] monthlySales)
	{
		double totalSales = 0;
		
		for (int i = 0; i < monthlySales.length; i++)
		{
			totalSales += monthlySales[i];
		}
		return totalSales;
	}

	
	public static double computeAverageSales(double[] monthlySales)
	{
		double totalSales = 0;
		double avgSales = 0;
		final double NUM_MONTHS = 12.0f;
		for (int i = 0; i < monthlySales.length; i++)
		{
			totalSales += monthlySales[i];
		}
		
		avgSales = totalSales / NUM_MONTHS;
		
		return avgSales;
	}
	
	
	public static int computeHighestMonth(double[] monthlySales)
	{
		// assume monthlySales[0] is the highest month value to begin with
		double highestMonthValue = monthlySales[0];
		
		int highestMonthIndex = 0;
		
		for (int i = 0; i < (monthlySales.length - 1); i++)
		{

			highestMonthValue = Math.max(highestMonthValue, monthlySales[i + 1]);
		}
		
		for (int i = 0; i < monthlySales.length; i++)
		{
			if (monthlySales[i] == highestMonthValue)
				highestMonthIndex = i;
		}
		
		return highestMonthIndex;
	}

	
	public static int computeLowestMonth(double[] monthlySales)
	{
		// assume monthlySales[0] is the lowest month value to begin with
		double lowestMonthValue = monthlySales[0];
		
		int lowestMonthIndex = 0;
		
		for (int i = 0; i < (monthlySales.length - 1); i++)
		{
			lowestMonthValue = Math.min(lowestMonthValue,  monthlySales[i + 1]);
		}
		
		for (int i = 0; i < monthlySales.length; i++)
		{
			if (monthlySales[i] == lowestMonthValue)
				lowestMonthIndex = i;
		}
		return lowestMonthIndex;
	}
	
	/* output sales data */
	public static void displaySaleInfo(double totalSales, double avgSales, String highMonth, double highSales, String lowMonth, double lowSales)
	{
		System.out.printf("Total Sales: $%.2f%n", totalSales);
		System.out.printf("Average Sales: $%.2f%n", avgSales);
		System.out.printf("Highest Month: %s%n", highMonth);
		System.out.printf("Highest Sales: $%.2f%n", highSales);
		System.out.printf("Lowest Month: %s%n", lowMonth);
		System.out.printf("Lowest Sales: $%.2f%n", lowSales);
	}

	public static void main(String[] args)
	{
		// constant
		final int NUM_MONTHS = 12;
		
		// variables
		String[] monthArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		double[] monthlySales = new double[NUM_MONTHS];
		double totalSales = 0.0f;
		double averageSales = 0.0f;
		int highestMonthIndex = 0;
		int lowestMonthIndex = 0;
	
		// method calls
		monthlySales = getSales(monthArray);
		totalSales = computeTotalSales(monthlySales);
		averageSales = computeAverageSales(monthlySales);
		highestMonthIndex = computeHighestMonth(monthlySales);
		lowestMonthIndex = computeLowestMonth(monthlySales); 
		displaySaleInfo(totalSales, averageSales, monthArray[highestMonthIndex], monthlySales[highestMonthIndex], monthArray[lowestMonthIndex], monthlySales[lowestMonthIndex]);
	}
}