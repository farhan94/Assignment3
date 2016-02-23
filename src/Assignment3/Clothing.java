package Assignment3;

import java.util.ArrayList;

public class Clothing extends Item {

	//Basic Constructor
	public Clothing(String name, double price, int quantity, int weight) {
		super(name, price, quantity, weight);
		this.calculateRegularShipping();
		this.calculateSalesTax();
		this.calculatePrice();
	}
	
	//String Constructor
	public Clothing(String name, String pr, String qu, String we) {
		super(name, pr, qu, we);
		this.calculateRegularShipping();
		this.calculateSalesTax();
		this.calculateTotalPrice();
	}
	
	public void calculatePrice() 
	{
		this.calculateRegularShipping();
		this.calculateSalesTax();
		this.calculateTotalPrice();
	}
	
}
