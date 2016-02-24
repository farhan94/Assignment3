
package Assignment3;

//import java.util.ArrayList;
import java.util.Arrays;

public class Electronics extends Item {
	
	enum fragClassification {FRAGILE, NONFRAGILE};
	private fragClassification fragile;
	
	enum taxClassification {TAXED, UNTAXED};
	private taxClassification taxed;
	
	String[] taxStates = {"TX","NM","VA","AZ","AK"};
	
	//Basic Constructor
	public Electronics(String name, double price, int quantity, int weight, String fNf, String state) {
		super(name, price, quantity, weight);
		if (fNf.toLowerCase().equals("f"))
		{
			this.fragile = fragClassification.FRAGILE;
			this.calculatePremiumShipping();
		}else if(fNf.toLowerCase().equals("nf"))
		{
			this.fragile = fragClassification.NONFRAGILE;
			calculateRegularShipping();
		}
		if(Arrays.asList(taxStates).contains(state))
		{
			this.taxed = taxClassification.UNTAXED;
			this.salesTax = 0;
		} else
		{
			this.taxed = taxClassification.TAXED;
			this.calculateSalesTax();
		}
		this.calculateTotalPrice();
	}
	
	//String Constructor
	public Electronics(String name, String pr, String qu, String we, String fNf, String state) {
		super(name, pr, qu, we);
		if (fNf.toLowerCase().equals("p")){
			this.fragile = fragClassification.FRAGILE;
			this.calculatePremiumShipping();
		}
		else if(fNf.toLowerCase().equals("np")){
			this.fragile = fragClassification.NONFRAGILE;
			calculateRegularShipping();
		}
		if(Arrays.asList(taxStates).contains(state))
		{
			this.taxed = taxClassification.UNTAXED;
			this.salesTax = 0;
		} else
		{
			this.taxed = taxClassification.TAXED;
			this.calculateSalesTax();
		}
		this.calculateTotalPrice();
	}

	public void calculatePrice() 
	{
		if (this.fragile.equals(fragClassification.FRAGILE))
		{
			this.calculatePremiumShipping();
		}
		else if(this.fragile.equals(fragClassification.NONFRAGILE))
		{
			calculateRegularShipping();
		}
		if(this.taxed.equals(taxClassification.UNTAXED))
		{
			this.salesTax = 0;
		} else
		{
			this.calculateSalesTax();
		}
		this.calculateTotalPrice();
	}
	
}