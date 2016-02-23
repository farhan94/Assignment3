package Assignment3;

import java.util.ArrayList;

public class Grocery extends Item {
	//variables, constructor here
	private static double salesTax = 0;
	
	enum classification {PERISH, NONPERISH};
	private classification perishable;
	

	
	
	public Grocery(String name, double price, int quantity, int weight, String Pnp) {
		super(name, price, quantity, weight);
		if (Pnp.toLowerCase().equals("p")){
			this.perishable = classification.PERISH;
		}
		else if(Pnp.toLowerCase().equals("np")){
			this.perishable = classification.NONPERISH;
		}
	}
	
	public Grocery(String name, String pr, String qu, String we, String Pnp) {
		super(name, pr, qu, we);
		if (Pnp.toLowerCase().equals("p")){
			this.perishable = classification.PERISH;
		}
		else if(Pnp.toLowerCase().equals("np")){
			this.perishable = classification.NONPERISH;
		}
	}


	//override calculatePrice() if necessary; Implement print methods as necessary	
	// Only re-implement stuff you cannot get from the superclass (Item)
	public void calculateShipping()
	{
		if (this.perishable == classification.PERISH){
			this.shippingPrice = this.weight*20*this.quantity*1.2;
		}
		else{
			this.shippingPrice = this.weight*20*this.quantity;
		}
	}
	
	public double calculatePrice() 
	{
		double finalPrice = 0;
		finalPrice = this.price * this.quantity + this.shippingPrice;
		return finalPrice;
	}
	
}
