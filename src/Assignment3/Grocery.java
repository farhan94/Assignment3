package Assignment3;

import java.util.ArrayList;

public class Grocery extends Item 
{
	
	enum classification {PERISH, NONPERISH};	//this will be used to check if it is perishable or nonperishable
	private classification perishable;
	
	//standard constructors initializing values
	public Grocery(String name, double price, int quantity, int weight, String Pnp) {
		super(name, price, quantity, weight);
		this.calculateItemSubTotal();
		if (Pnp.toLowerCase().equals("p"))
		{
			this.perishable = classification.PERISH;
			this.calculatePremiumShipping();
		}
		else if(Pnp.toLowerCase().equals("np"))
		{
			this.perishable = classification.NONPERISH;
			this.calculateRegularShipping();
		}
		this.salesTax = 0;
		this.calculateTotalPrice();
	}
	//standard constructor using string to initialize values
	public Grocery(String name, String pr, String qu, String we, String Pnp) {
		super(name, pr, qu, we);
		this.calculateItemSubTotal();
		if (Pnp.toLowerCase().equals("p"))
		{
			this.perishable = classification.PERISH;
			this.calculatePremiumShipping();
		}
		else if(Pnp.toLowerCase().equals("np"))
		{
			this.perishable = classification.NONPERISH;
			this.calculateRegularShipping();
		}
		this.salesTax = 0;
		this.calculateTotalPrice();
	}
	//this method calculates the price depending on the attributes of the object (grocery)
	public void calculatePrice() 
	{
		this.calculateItemSubTotal();
		if (this.perishable.equals(classification.PERISH))
		{
			this.calculatePremiumShipping();
		}else if(this.perishable.equals(classification.NONPERISH))
		{
			this.calculateRegularShipping();
		}
		this.salesTax = 0;
		this.calculateTotalPrice();
	}
	
}
