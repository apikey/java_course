/***********************************************************************
Program Name: Greet.java
Programmer's Name: Jason Franco
Program Description: Greet the person by their name 
***********************************************************************/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;

public class Greet extends Applet implements ActionListener
{
	public Label lblEnter = new Label();
	public TextField txtField = new TextField();
	public Button btn = new Button();
	public Label lblResult = new Label();
	
	public void init()
	{
		this.setSize(500, 500);
		setBackground(Color.yellow);
		this.setLayout(null);
		
	
		// label enter
		lblEnter.setText("Please enter your name: ");
		lblEnter.setBounds(20, 20, 200, 20);
		
		// text field
		txtField.setSize(200, 5);
		txtField.setBounds(220, 20, 200, 20);
		
		// button
		btn.setLabel("GREET");
		btn.setBounds(220, 50, 100, 20);
		
		// label result
		lblResult.setText("Result goes here.");
		lblResult.setBounds(200, 250, 300, 20);
		
		// add action to button
		btn.addActionListener(this);
		
		
		// add UI elements
		add(lblEnter);
		add(txtField);
		add(btn);
		add(lblResult);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		lblResult.setText("Hello, " + txtField.getText() + "!");
	}
}
