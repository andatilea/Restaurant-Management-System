package businessLayer;
import java.util.ArrayList;
import java.util.Iterator;

		//This class models a more complex type of product, being built out from several ingredients;
	public class CompositeProduct extends MenuItem {
	
		//A list of menu items is declared, in order to add all the ingredients involved in the creation of the current composite product;
	private ArrayList<MenuItem> ingredients = new ArrayList<MenuItem>();
	
	public CompositeProduct(String name, int price, ArrayList<MenuItem> ingredients) {
		//The "super" keyword is used for referring to the parent's class String name;
		super(name);
		this.ingredients = ingredients;
	}	

		//In this case, the overridden method will be implemented by taking every ingredient selected into consideration;
	public @Override int computePrice() {
	int price = 0;
	Iterator<MenuItem> iterator = ingredients.iterator();
	while(iterator.hasNext()){
	MenuItem curentItem = iterator.next();
		//the total price attached to the a composite product will represent the addition of each ingredient's price;
	price+=curentItem.computePrice();
	}
	return price;
}
	}
