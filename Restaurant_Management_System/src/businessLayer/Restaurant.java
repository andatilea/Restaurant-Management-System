package businessLayer;
import java.util.*;
import dataLayer.*;

	/**
	 * The Restaurant Class is responsible for implementing all the interface’s methods; 
	 * It truly represents the center of this Application;
	 * Every action will have to pass through the restaurant or it is executed by this class;  
	 * This class will contain three Fields: a list which will contain all the menu items already created, the HashMap, and an Order parameter;
	 *  The HashMap is used in order to map the ordered items to the specific order they belong;
	 */
	public class Restaurant extends Observable implements IRestaurantProcessing{

		private ArrayList<MenuItem> menu;
	
		private Map<Order, ArrayList<MenuItem>> orderMap = new HashMap<Order, ArrayList<MenuItem>>();//ORDER RELATED INFO
	
		private Order order;
	
		
	public Restaurant() {
		
		this.menu = new ArrayList<MenuItem>();
		this.orderMap = new HashMap<Order, ArrayList<MenuItem>>();	
	}
	
	/**
	 * The getter method will return the restaurant's menu. It is being updated after each employee's task;
	 * @return this.menu: the list of existing products in the menu;
	 */
	@Override
	public ArrayList<MenuItem> getMenuItems(){
		return this.menu;
	}

	/**
	 * The method for creating a menu item, described in the interface, is implemented in the Restaurant Class;
	 *  It checks the size of the ingredients list;
	 * The assumption is that, if the list contains some elements, then the user tries to insert a composite product;
	 * For base products, the list will always be empty, because they don't contain other ingredients;
	 * Finally, the item wanted is added to the menu;
	 */
	@Override
	public void createMenuItem(String name, int price, ArrayList<MenuItem> ingredients) {
		
		assert name != null;
		assert price !=0;
		int size1 = menu.size();
		MenuItem product;
		if(!(ingredients.size() == 0)){
		product = new CompositeProduct(name, price, ingredients);				//is ambele pentru ca pretul unui composite depinde de pretul base products
		} else {
		product = new BaseProduct(name, price);		}
		menu.add(product);
		int size2 = menu.size();
		assert size1 + 1  == size2;
	}
	
	/**
	 * The method for editing a menu item, described in the interface, is implemented in the Restaurant Class;
	 *  It searches through all the menu items already existing;
	 * If the wanted name equals a name contained in the menu list, then the product will be updated with the new information assigned;
	 */
	@Override
	public void editMenuItem(String name, int price2, ArrayList<MenuItem> ingredients) {
		
		assert name != null;
		assert price2 != 0;
		int price1 = 0;
		for(int i=0; i<menu.size(); i++) {
		MenuItem currentItem = menu.get(i);
		String productName = currentItem.getName();
		if(productName.equals(name)){
		menu.remove(menu.get(i));	 
		ingredients = new ArrayList<MenuItem>();
		createMenuItem(name, price2, ingredients); 
			}
		}
		assert price1 == price2;
	}
	
	/**
	 * The method for deleting a menu item, described in the interface, is also implemented here, in the Restaurant Class;
	 * The deletion also uses the name of an already existing menu item;
	 * If the wanted name equals a value from the menu, then that specific product with all its attributes will be removed;
	 */
	@Override
	public void deleteMenuItem(String name) {
		
		assert name != null;
		int size1 = menu.size();
		for(int i=0; i<menu.size(); i++) {
		String productName = menu.get(i).getName();           							  
		if(productName == name) {                  
		menu.remove(i);	
		}
		}
		int size2 = menu.size();
		assert size1 == size2 + 1;
	}


	/**
	 * The method for creating a new order, described in the interface, is implemented here, in the Restaurant Class. 
	 * All the parameters given represent the total information needed for an order to be created and computed;
	 * The method will create a new Order along with its attached list of menu items;
	 * The Application will make use of the HashMap implemented;
	 * @return  order: an order type variable will be returned;
	 */
	@Override
	public Order createNewOrder(int id, String location, int Table,  Date date, ArrayList<MenuItem> items) {
		
		assert id != 0;
		assert location != null;
		assert Table != 0;
		assert date != null;
		order = new Order(id, location, Table, date);
		orderMap.put(order, items);
		return order;
	}

	/**
	 * The method for computing an order's price, described in the interface, is also implemented here. 
	 * The Application received all the order related information, using the Hash Map implemented;
	 * Then an iteration is done, for computing the total amount needed to pay, by adding the value (price) of each individual menu item ordered;
	 * @return price: an integer type variable, representing the computed result, is returned;
	 */
	@Override
	public int computePrice(Order order) {
		
		assert order != null;
		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
		list = orderMap.get(order);
		int price = 0;
		Iterator<MenuItem> iterator = list.iterator();
		while(iterator.hasNext()){
		MenuItem curentItem = iterator.next();
		price+=curentItem.computePrice();
		}
		return price;
	}
	
	/**
	 * The method for generating the bill, described in the interface, is also implemented here.
	 * All the parameters given are order related information, needed for the bill to be computed;
	 * The Application uses the FileWriter Class in order to compute the bill in a output file text format.
	 * The output will be saved in the Project Folder as a “.txt” file;
	 */
	@Override
	public void generateBill(int id,String location, int Table,  String date, int price) {
		FileWriter.createBill(id, location, Table, date, price);
	}
	}