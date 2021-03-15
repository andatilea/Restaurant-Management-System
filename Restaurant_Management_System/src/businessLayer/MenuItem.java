package businessLayer;

		//This Class incorporates the entire concept of a menu item for this Restaurant.
	public abstract class MenuItem{
		
		//the Field is declared as a "protected" type, assuring in this way that the visualisation by its children can be done;
	protected String name;
	
	public MenuItem(String name) {
		this.name = name;
	}
	
		//This compute Price method is declared as abstract, since it needs to be implemented in two different ways, depending on the type of the product in cause;
	public abstract int computePrice();	
	
		//The abstract Class also contains a getter method in order to make menu item's name available;
	public String getName() {
		return this.name;
	}
	}