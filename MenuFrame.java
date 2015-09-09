/***********************************************************************
Program Name: MenuFrame.java
Programmer's Name: Jason Franco
Program Description: Menu class for Quick Fast Car Care application
***********************************************************************/
import javax.swing.*;

import java.awt.event.*;

public class MenuFrame extends JFrame
{
	
	public OilChange bronze	= new OilChange("Bronze", OilChange.BRONZE_PRICE);
	public OilChange silver = new OilChange("Silver", OilChange.SILVER_PRICE);
	public OilChange gold	= new OilChange("Gold", OilChange.GOLD_PRICE);
	
	public CarWash basic = new CarWash("Basic", CarWash.BASIC_PRICE);
	public CarWash better = new CarWash("Better", CarWash.BETTER_PRICE);
	public CarWash best = new CarWash("Best", CarWash.BEST_PRICE);
	
	public double oilChangePrice;
	public String oilChangeType;
	public double carWashPrice;
	public String carWashType;
	
	public double total;
	
	// constructor
	public MenuFrame(String applicationName)
	{
		super(applicationName);
		
		oilChangePrice = 0.0;
		oilChangeType = "Not selected";
		carWashPrice = 0.0;
		carWashType = "Not selected";
		
		JMenu oilChangeMenu 	= new JMenu("Oil Change");
		JMenuItem bronzeItem 	= new JMenuItem("Bronze");
		JMenuItem silverItem 	= new JMenuItem("Silver");
		JMenuItem goldItem 		= new JMenuItem("Gold");

		// oil change menu
		oilChangeMenu.add(bronzeItem);
		oilChangeMenu.add(silverItem);
		oilChangeMenu.add(goldItem);
		
		// add oil change menu actions
		bronzeItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						oilChangeType = bronze.getOilChangeType();
						oilChangePrice = bronze.getOilChangePrice();
						JOptionPane.showMessageDialog(MenuFrame.this, "Bronze Oil Change selected", "Bronze Oil Change", JOptionPane.PLAIN_MESSAGE);
					}
				}
				);
		
		silverItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						
						oilChangeType = silver.getOilChangeType();
						oilChangePrice = silver.getOilChangePrice();
						JOptionPane.showMessageDialog(MenuFrame.this, "Silver Oil Change selected", "Silver Oil Change", JOptionPane.PLAIN_MESSAGE);
					}
				}
				);
		
		goldItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						oilChangeType = gold.getOilChangeType();
						oilChangePrice = gold.getOilChangePrice();
						JOptionPane.showMessageDialog(MenuFrame.this, "Gold Oil Change selected", "Gold Oil Change", JOptionPane.PLAIN_MESSAGE);
					}
				}
				);
		
		// car wash menu
		JMenu carWashMenu = new JMenu("Car Wash");
		JMenuItem basicWashItem = new JMenuItem("Basic");
		JMenuItem betterWashItem = new JMenuItem("Better");
		JMenuItem bestWashItem = new JMenuItem("Best");
		carWashMenu.add(basicWashItem);
		carWashMenu.add(betterWashItem);
		carWashMenu.add(bestWashItem);
		
		// add car wash menu actions
		basicWashItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						
						carWashType = basic.getCarWashType();
						carWashPrice = basic.getCarWashPrice();
						JOptionPane.showMessageDialog(MenuFrame.this, "Basic car wash selected", "Basic Car Wash", JOptionPane.PLAIN_MESSAGE);
					}
				}
				);
		
		betterWashItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						carWashType = better.getCarWashType();
						carWashPrice = better.getCarWashPrice();
						JOptionPane.showMessageDialog(MenuFrame.this, "Better car wash selected", "Better Car Wash", JOptionPane.PLAIN_MESSAGE);
					}
				}
				);
		
		bestWashItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						carWashType = best.getCarWashType();
						carWashPrice = best.getCarWashPrice();
						JOptionPane.showMessageDialog(MenuFrame.this, "Best car wash selected", "Best Car Wash", JOptionPane.PLAIN_MESSAGE);
					}
				}
				);
		// Totals/Clear/Exit menu
		JMenu totalsClearExit = new JMenu("Totals/Clear/Exit");
		JMenuItem totalItem = new JMenuItem("Total");
		JMenuItem clearItem = new JMenuItem("Clear");
		JMenuItem exitItem = new JMenuItem("Exit");
		totalsClearExit.add(totalItem);
		totalsClearExit.add(clearItem);
		totalsClearExit.add(exitItem);
		
		// add Totals/Clear/Exit menu actions
		totalItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						StringBuilder str = new StringBuilder();
						if (total > 0.0 || total < 0.0) // reset total so they aren't double charged
							total = 0.0;
						total += oilChangePrice;
						total += carWashPrice;
						str.append("Oil Change: " + oilChangeType);
						str.append("\nCar Wash: " + carWashType);
						str.append("\nTotal Cost: $" + String.format("%,.2f", total) );
						JOptionPane.showMessageDialog(MenuFrame.this, str.toString(), "Total Order", JOptionPane.PLAIN_MESSAGE);
					}
				}
				);
		
		clearItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						oilChangeType = "Not Selected";
						oilChangePrice = 0.0;
						carWashType = "Not selected";
						carWashPrice = 0.0;
						total = 0.0;
						JOptionPane.showMessageDialog(MenuFrame.this, "Your list has been cleared", "Clear", JOptionPane.PLAIN_MESSAGE);
					}
				}
				);
		
		exitItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						JOptionPane.showMessageDialog(MenuFrame.this, "Good Bye!", "Exit", JOptionPane.PLAIN_MESSAGE);
						System.exit(0);
					}
				}
				);
		
		// set up bar
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		bar.add(oilChangeMenu);
		bar.add(carWashMenu);
		bar.add(totalsClearExit);
	}
}