package Assignment3;

import java.util.ArrayList;

public class Clothing extends Item
{

	//Basic Constructor
	public Clothing(String name, double price, int quantity, int weight) 
	{
		super(name, price, quantity, weight);
		this.calculateItemSubTotal();
		this.calculateRegularShipping();
		this.calculateSalesTax();
		this.calculateTotalPrice();
	}
	
	//String Constructor
	public Clothing(String name, String pr, String qu, String we) 
	{
		super(name, pr, qu, we);
		this.calculateItemSubTotal();
		this.calculateRegularShipping();
		this.calculateSalesTax();
		this.calculateTotalPrice();
	}
	
	public void calculatePrice() 
	{
		this.calculateItemSubTotal();
		this.calculateRegularShipping();
		this.calculateSalesTax();
		this.calculateTotalPrice();
	}
	
}
