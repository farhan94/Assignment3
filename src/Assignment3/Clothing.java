package Assignment3;

import java.util.ArrayList;

public class Clothing extends Item 
{

	// variables, constructors as necessary
	
	
	public Clothing(String name, double price, int quantity, int weight) {
		super(name, price, quantity, weight);
		// TODO Auto-generated constructor stub
	}

	public double calculatePrice () 
	{
		float final_price = 0;
		// Insert price calculation here
		return final_price;
	}
	
	void printItemAttributes () 
	{
		//Print all applicable attributes of this sub-class
	}

	public static void evaluateInput(String[] splitString, ArrayList<Item> shoppingCart) {
		// TODO Auto-generated method stub
		
	}
	

}
