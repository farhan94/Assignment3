
package Assignment3;

//import java.util.ArrayList;
import java.util.Arrays;

public class Electronics extends Item 
{
	
	enum fragClassification {FRAGILE, NONFRAGILE};	//will be used to see if the object is fragile or not
	private fragClassification fragile;				// it comes in use for shipping calculations
	
	enum taxClassification {TAXED, UNTAXED};		// depending on the state, it will be taxed or untaxed
	private taxClassification taxed;
	
	String[] taxStates = {"TX","NM","VA","AZ","AK"};	//these states are not taxed
	
	//Basic Constructor
	public Electronics(String name, double price, int quantity, int weight, String fNf, String state) 
	{
		super(name, price, quantity, weight);
		this.calculateItemSubTotal();
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
	public Electronics(String name, String pr, String qu, String we, String fNf, String state)
	{
		super(name, pr, qu, we);
		this.calculateItemSubTotal();
		if (fNf.toLowerCase().equals("f")){
			this.fragile = fragClassification.FRAGILE;
			this.calculatePremiumShipping();
		}
		else if(fNf.toLowerCase().equals("nf")){
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
	//this method calculates priced based on attributes of the object
	public void calculatePrice() 
	{
		this.calculateItemSubTotal();
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