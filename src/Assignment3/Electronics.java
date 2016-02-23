
package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;

public class Electronics extends Item {
	
	enum fragClassification {FRAGILE, NONFRAGILE};
	private fragClassification fragile;
	
	enum taxClassification {TAXED, UNTAXED};
	private taxClassification taxed;
	
	String[] taxStates = {"TX","NM","VA","AZ","AK"};
	
	//Bascic Constructor
	public Electronics(String name, double price, int quantity, int weight, String fNf, String state) {
		super(name, price, quantity, weight);
		if (fNf.toLowerCase().equals("f"))
		{
			this.fragile = fragClassification.FRAGILE;
		}else if(fNf.toLowerCase().equals("nf"))
		{
			this.fragile = fragClassification.NONFRAGILE;
		}
		if(Arrays.asList(taxStates).contains(state))
		{
			this.taxed = taxClassification.UNTAXED;
		} else
		{
			this.taxed = taxClassification.TAXED;
		}
	}
	
	//String Constructor
	public Electronics(String name, String pr, String qu, String we, String fNf, String state) {
		super(name, pr, qu, we);
		if (fNf.toLowerCase().equals("p")){
			this.fragile = fragClassification.FRAGILE;
		}
		else if(fNf.toLowerCase().equals("np")){
			this.fragile = fragClassification.NONFRAGILE;
		}
		if(Arrays.asList(taxStates).contains(state))
		{
			this.taxed = taxClassification.UNTAXED;
		} else
		{
			this.taxed = taxClassification.TAXED;
		}
	}


	//override calculatePrice() if necessary; Implement print methods as necessary	
	// Only re-implement stuff you cannot get from the superclass (Item)
	public void calculateShipping()
	{
		if (this.fragile == fragClassification.FRAGILE){
			this.calculatePremiumShipping();
		}
		else{
			this.calculateRegularShipping();
		}
	}
	
	public double calculatePrice() 
	{
		double finalPrice = 0;
		if(this.taxed.equals(taxClassification.TAXED)){
			finalPrice = (this.price * (1 + this.salesTax))* this.quantity + this.shippingPrice;
		} else
		{
			finalPrice = this.price * this.quantity + this.shippingPrice;
		}
		return finalPrice;
	}
	
}