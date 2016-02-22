package Assignment3;

import java.util.ArrayList;
import java.util.Iterator;

public class Grocery extends Item {
	//variables, constructor here
	private static double salesTax = 0;
	
	enum classification {PERISH, NONPERISH};
	private classification perishable;
	
	public static void evaluateInput(String[] s, ArrayList<Item> shoppingCart){
		if (s[0].toLowerCase().equals("insert"))
		{
			if (Item.itemExists(s[2], shoppingCart)){
				System.err.println("Item " +s[2]+ " already exists in shopping cart.");
			}
			else
			{
				shoppingCart.add(new Grocery(s[2], s[3], s[4], s[5], s[6]));
		
			}
		}
		
		else if (s[0].toLowerCase().equals("search"))
		{
			Item.search(s[1], shoppingCart);
		}
		
		else if (s[0].toLowerCase().equals("delete"))
		{
			Item.delete(s[1], shoppingCart);
		}
		
		else if (s[0].toLowerCase().equals("update"))
		{
			Item.update(s[1], s[2], shoppingCart);
		}
		
	}
	
	
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
		double final_price = 0;
		final_price = this.price * this.quantity + this.shippingPrice;
		return final_price;
	}
	
}
