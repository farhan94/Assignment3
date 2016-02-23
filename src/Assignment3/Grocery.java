package Assignment3;

import java.util.ArrayList;

public class Grocery extends Item {
	//variables, constructor here
	
	enum classification {PERISH, NONPERISH};
	private classification perishable;
	
	public Grocery(String name, double price, int quantity, int weight, String Pnp) {
		super(name, price, quantity, weight);
		if (Pnp.toLowerCase().equals("p")){
			this.perishable = classification.PERISH;
			this.calculatePremiumShipping();
		}
		else if(Pnp.toLowerCase().equals("np")){
			this.perishable = classification.NONPERISH;
			this.calculateRegularShipping();
		}
		this.salesTax = 0;
		this.calculateTotalPrice();
	}
	
	public Grocery(String name, String pr, String qu, String we, String Pnp) {
		super(name, pr, qu, we);
		if (Pnp.toLowerCase().equals("p")){
			this.perishable = classification.PERISH;
			this.calculatePremiumShipping();
		}
		else if(Pnp.toLowerCase().equals("np")){
			this.perishable = classification.NONPERISH;
			this.calculateRegularShipping();
		}
		this.salesTax = 0;
		this.calculateTotalPrice();
	}

	public void calculatePrice() 
	{
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
