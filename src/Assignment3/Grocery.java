package Assignment3;

public class Grocery extends Item {
	//variables, constructor here
	private static double salesTax = 0;
	
	enum classification {PERISH, NONPERISH};
	private classification perishable;
	
	public Grocery(String name, double price, int quantity, int weight, String Pnp) {
		super(name, price, quantity, weight);
		if (Pnp.equals("P")){
			this.perishable = classification.PERISH;
		}
		else if(Pnp.equals("NP")){
			this.perishable = classification.NONPERISH;
		}
	}
	//override calculatePrice() if necessary; Implement print methods as necessary	
	// Only re-implement stuff you cannot get from the superclass (Item)
	public void calculateShipping(){
		if (this.perishable == classification.PERISH){
			this.shippingPrice = this.weight*20*this.quantity*1.2;
		}
		else{
			this.shippingPrice = this.weight*20*this.quantity;
		}
	}
	
}
