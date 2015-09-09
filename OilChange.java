/***********************************************************************
Program Name: OilChange.java
Programmer's Name: Jason Franco
Program Description: Oil Change types and prices
***********************************************************************/
import java.util.InputMismatchException;

public class OilChange
{
	public final static double BRONZE_PRICE = 20.00;
	public final static double SILVER_PRICE = 25.00;
	public final static double GOLD_PRICE = 30.00;
	
	private String oilChangeType;
	private double oilChangePrice;
	
	public OilChange()
	{
		oilChangeType = "Not Determined";
		oilChangePrice = 0.0;
	}
	
	public OilChange(String oilChangeType, double oilChangePrice) throws InputMismatchException
	{
		this.oilChangeType = oilChangeType;
		this.oilChangePrice = oilChangePrice;
	}
	
	// setters
	public void setOilChangeType(String oilChangeType) throws InputMismatchException
	{
		this.oilChangeType = oilChangeType;
	}
	public void setOilChangePrice(double oilChangePrice) throws InputMismatchException
	{
		this.oilChangePrice = oilChangePrice;
	}
	
	// getters
	public String getOilChangeType()
	{
		return oilChangeType;
	}
	public double getOilChangePrice()
	{
		return oilChangePrice;
	}
}