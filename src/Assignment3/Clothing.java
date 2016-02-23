package Assignment3;

import java.util.ArrayList;

public class Clothing extends Item {

	//Bascic Constructor
	public Clothing(String name, double price, int quantity, int weight) {
		super(name, price, quantity, weight);
	}
	
	//String Constructor
	public Clothing(String name, String pr, String qu, String we) {
		super(name, pr, qu, we);
	}


	public void calculateShipping()
	{
		this.calculateRegularShipping();
	}
	
	public double calculatePrice() 
	{
		double finalPrice = 0;
		finalPrice = (this.price * (1 + this.salesTax))* this.quantity + this.shippingPrice;
		return finalPrice;
	}
	
}
