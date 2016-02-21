package Assignment3;
//Programmed by Thomas Leahy
//Tpl335
//EE 422C Spring 2016
//Thursday 2:00-3:30

import java.util.Arrays;

import Assignment3.Grocery.classification;




public class Electronics extends Item 
{
	enum classification {FRAGILE, NONFRAGILE};
	private classification fragile;
	String[] noTaxStates = {"TX", "NM", "VA", "AZ", "AK"};
	
	public Electronics(String name, double price, int quantity, int weight, String fNf, String state) {
		super(name, price, quantity, weight);
		if (fNf.equals("F"))
		{
			this.fragile = classification.FRAGILE;
			super.calculatePremiumShipping();
		}else if(fNf.equals("NF"))
		{
			this.fragile = classification.NONFRAGILE;
			super.calculateRegularShipping();
		}
		if(!Arrays.asList(noTaxStates).contains(state.toUpperCase())) //This is from a electronics-taxing state
		{
			
		}
		
		
		
	}
	
	
	// Variables, constructors etc. here.
	
	//Implement calculate price/print methods as necessary

}
