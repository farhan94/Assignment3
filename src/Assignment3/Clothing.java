package Assignment3;

import java.util.ArrayList;

public class Clothing extends Item
{

	//standard constructors initializing values 
	public Clothing(String name, double price, int quantity, int weight) 
	{
		super(name, price, quantity, weight);
		this.calculateItemSubTotal();
		this.calculateRegularShipping();
		this.calculateSalesTax();
		this.calculateTotalPrice();
	}
	
	//standard constructors initializing values from strings
	public Clothing(String name, String pr, String qu, String we) 
	{
		super(name, pr, qu, we);
		this.calculateItemSubTotal();
		this.calculateRegularShipping();
		this.calculateSalesTax();
		this.calculateTotalPrice();
	}
	// calculates the price using the attributes of the object
	public void calculatePrice() 
	{
		this.calculateItemSubTotal();
		this.calculateRegularShipping();
		this.calculateSalesTax();
		this.calculateTotalPrice();
	}
	
}
