package Assignment3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Item 
{
    // Declare variables for this class. Think about its type: public, protected
    // or private?
    String name;
    double unitPrice;
    int quantity;
    double itemSubTotal;
    double shippingPrice;
    double salesTax;
    int weight;
    double totalPrice; // including either premium or regular shipping and tax
		       // if applicable

    public Item(String name, double price, int quantity, int weight) 
    {
	this.name = name;
	this.unitPrice = price;
	this.quantity = quantity;
	this.weight = weight;
    }

    public Item(String name2, String pr, String qu, String we) 
    {
	double price = Double.parseDouble(pr);
	int cast = (int) (price * 100);
	price = (double) cast / 100;

	double quantity = Double.parseDouble(qu);
	double weight = Double.parseDouble(we);
	this.name = name2;
	this.unitPrice = price;
	this.quantity = (int) quantity;
	this.weight = (int) weight;
    }

    public String getName() 
    {
	return name;
    }

    public void setName(String name) 
    {
	this.name = name;
    }

    public double getUnitPrice() 
    {
	return unitPrice;
    }

    public void setUnitPrice(double price) 
    {
	this.unitPrice = price;
    }

    public int getQuantity() 
    {
	return quantity;
    }

    public void setQuantity(int quantity) 
    {
	this.quantity = quantity;
    }

    public void calculateItemSubTotal() 
    {
	this.itemSubTotal = this.quantity * this.unitPrice;
    }

    public int getWeight() 
    {
	return weight;
    }

    public void setWeight(int weight) 
    {
	this.weight = weight;
    }

    public double getShippingPrice() 
    {
	return shippingPrice;
    }

    public double getSalesTax() 
    {
	return salesTax;
    }

    public double getTotalPrice() 
    {
	return totalPrice;
    }

    public void calculateTotalPrice() 
    {
	totalPrice = itemSubTotal + shippingPrice + salesTax;
    }

    public void calculateRegularShipping() 
    {   
	// use the technique in the
	// assignment description to
	// calculate the shipping price
	// (variable)
	this.shippingPrice = this.weight * 20 * this.quantity;
    }

    public void calculatePremiumShipping() 
    { 
	// use the technique in the 
	// assignment description to
	// calculate the shipping price
	// (variable)
	this.shippingPrice = this.weight * 20 * this.quantity * 1.2;
    }

    public void calculateSalesTax() 
    {
	this.salesTax = .1 * itemSubTotal;
    }

    public static void search(String name, ArrayList<Item> shoppingCart) 
    {
	int result = 0;
	Iterator<Item> i = shoppingCart.iterator();
	while (i.hasNext()) 
	{
	    Item a = i.next();
	    if (a.name.equals(name)) 
	    {
		result += a.quantity;
	    }
	}
	if (result == 0) 
	{
	    System.err.println("This item does not exist in the shopping cart");
	} else 
	{
	    System.out.println("There is a quantity of " + result + " " + name + " in the shopping cart.");
	}
    }

    public static void delete(String name, ArrayList<Item> shoppingCart)
    {
	int del = 0;
	Iterator<Item> i = shoppingCart.iterator();
	while (i.hasNext())
	{
	    Item a = i.next();
	    if (a.name.equals(name)) 
	    {
		del += a.quantity;
		i.remove();
	    }

	}
	System.out.println("A quantity of " + del + " " + name + " was deleted from the shopping cart.");

    }

    public static boolean itemExists(String name, ArrayList<Item> shoppingCart) 
    {
	Iterator<Item> i = shoppingCart.iterator();
	while (i.hasNext()) 
	{
	    Item a = i.next();
	    if (a.name.equals(name)) 
	    {
		return true;
	    }
	}
	return false;
    }

    public void calculatePrice() 
    {
	// Polymorphic Function will call calculate Price of the three class
	// functions
    }

    public static void update(String name, String quant, ArrayList<Item> shoppingCart)
    {
	int quantity = Integer.parseInt(quant);
	Iterator<Item> i = shoppingCart.iterator();
	while (i.hasNext()) 
	{
	    Item a = i.next();
	    if (a.name.equals(name)) 
	    {
		int ind = shoppingCart.indexOf(a);
		a = shoppingCart.get(ind);
		a.setQuantity(quantity);
		a.calculatePrice();
		shoppingCart.set(ind, a);
		System.out.println(a.name + ": " + a.quantity);
		return;
	    }

	}
    }

    public static void evaluateInput(String[] s, ArrayList<Item> shoppingCart) 
    {
	if (s[1].toLowerCase().equals("groceries")) 
	{
	    shoppingCart.add(new Grocery(s[2], s[3], s[4], s[5], s[6]));
	} 
	else if (s[1].toLowerCase().equals("electronics")) 
	{
	    shoppingCart.add(new Electronics(s[2], s[3], s[4], s[5], s[6], s[7]));
	}

	else if (s[1].toLowerCase().equals("clothing")) 
	{
	    shoppingCart.add(new Clothing(s[2], s[3], s[4], s[5]));
	}

    }

    void printItemAttributes() 
    {
	// Print all applicable attributes of this class
	System.out.println("Item name: " + getName());
	System.out.println("Item quantity: " + getQuantity());
	double priceTaxShipping = this.itemSubTotal + this.getSalesTax() + this.getShippingPrice();
	System.out.println("Item price after tax and shipping: $" + String.format("%.2f", priceTaxShipping));
    }

    public static void print(ArrayList<Item> shoppingCart) 
    {
	// this method will print the items in the shopping cart in alphabetical
	// order
	double cartTotal = 0;
	Collections.sort(shoppingCart, new CustomComparator());
	for (int i = 0; i < shoppingCart.size(); i++) 
	{
	    shoppingCart.get(i).printItemAttributes();
	    cartTotal += shoppingCart.get(i).totalPrice;
	}
	System.out.println("Total Charges for this cart: $" + String.format("%.2f", cartTotal));
    }
}
