/***********************************************************************
Program Name: CarWash.java
Programmer's Name: Jason Franco
Program Description: Car wash prices and types
***********************************************************************/
import java.util.InputMismatchException;

public class CarWash
{
	public static final double BASIC_PRICE = 5.00;
	public static final double BETTER_PRICE = 10.00;
	public static final double BEST_PRICE = 15.00;
	
	private String carWashType;
	private double carWashPrice;
	
	public CarWash()
	{
		carWashType = "Not Determined";
		carWashPrice = 0.0;
	}
	
	public CarWash(String carWashType, double carWashPrice) throws InputMismatchException
	{
		this.carWashType = carWashType;
		this.carWashPrice = carWashPrice;
	}
	
	//setters
	public void setCarWashType(String carWashType) throws InputMismatchException
	{
		this.carWashType = carWashType;
	}
	
	public void setCarWashPrice(double carWashPrice) throws InputMismatchException
	{
		this.carWashPrice = carWashPrice;
	}
	
	//getters
	public String getCarWashType()
	{
		return carWashType;
	}
	
	public double getCarWashPrice()
	{
		return carWashPrice;
	}
}