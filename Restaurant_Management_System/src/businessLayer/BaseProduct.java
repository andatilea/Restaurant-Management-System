package businessLayer;

		//this class represents a child for the MenuItem class. It will implements simple products;
	public class BaseProduct extends MenuItem {
	
	private int price;
	
	public BaseProduct(String name,int price) {
		//the "super" keyword is used for referring to the parent's class String name;
		super(name);
		this.price = price;	
	}

		//the price for each base product will be represented only by the entered price value, since they do not contain any other ingredients;
	public @Override int computePrice() {
		return this.price;
	}
	}