package Assignment3;

public class Item 
{
//Declare variables for this class. Think about its type: public, protected or private?
	String name;
	double price;
	double shippingPrice;
	protected double salesTax = 0.1;
	protected int quantity;
	int weight;
	
	double totalPrice; //including either premium or regular shipping and tax if applicable
	
// You will need a constructor (Why?). Create it here.
	public Item(String name, double price, int quantity, int weight){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.weight = weight;
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getWeight() {
		return weight;
	}



	public void setWeight(int weight) {
		this.weight = weight;
	}



	public double getShippingPrice() {
		return shippingPrice;
	}



	public double getSalesTax() {
		return salesTax;
	}



	public double getTotalPrice() {
		return totalPrice;
	}



	public double calculatePrice () 
	{
		double final_price = 0;
		final_price = this.price * this.quantity + this.shippingPrice + this.price*this.salesTax;
		return final_price;
	}
	

	void printItemAttributes () 
	{
		//Print all applicable attributes of this class
	}
	
	public void calculateRegularShipping(){ //use the technique in the assignment description to calculate the shipping price (variable)
		this.shippingPrice = this.weight*20*this.quantity;
	}
	
	public void calculatePremiumShipping(){ //use the technique in the assignment description to calculate the shipping price (variable)
		this.shippingPrice = this.weight*20*this.quantity*1.2;
	}

}
