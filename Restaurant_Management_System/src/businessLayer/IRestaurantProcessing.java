package businessLayer;
import java.util.ArrayList;
import java.util.Date;

	/**
	 * This Interface declares all the methods needed for computing the employee’s tasks;
	 * Here, a getter is declared, in order to track permanently the menu list of the restaurant;
	 *  Firstly, the administrator will receive as a task: to create, edit and delete a menu item;
	 *  Then, the waiter will receive the “create order” and “compute Price” and “generate bill” tasks. 
	 */
	public interface IRestaurantProcessing {
	
	/**
	 * The method represents a getter function, which will help the user track the current items contained in the menu;
	 * The List will be updated after each operation computed;
	 * @return the current List of menu items will be returned;
	 */
	public ArrayList<MenuItem> getMenuItems();
	
	/**
	 * The method is designed for the Administrator's use. It will create a new item with the corresponding specifications provided by the user;
	 * @param name: a String type variable, which represents the name of the item which needs to be added;
	 * @param price: an Integer type variable, which represents the price (original/computed) assigned for the current product. The calculation for the price will depend on the type of the product(base/composite);
	 * The product's type will be checked in the implementation of the function;
	 * @param ingredients: an ArrayList of MenuItems representing the list of products taken as ingredients in the making of the wanted product. This list could be empty (base product) or could contain several ingredients (composite product);
	 * precondition: name != null;
	 * precondition: price != 0;
	 * postcondition: menu.size.precondition + 1 == menu.size.postcondition;
	 */
	public void createMenuItem(String name, int price, ArrayList<MenuItem> ingredients);
	
	/**
	 * The method is designed only for the Administrator's tasks. It is responsible for editing an already existing item. For the base products, the price will be updated;
	 * For the composite products, the list of ingredients can be changed, the price being updated accordingly;
	 * @param name: a String type variable which will represent the searching criteria. All the items will be searched in the menu using their name;
	 * @param price: an Integer type variable which will represent the updated price attached to the edited item;
	 * @param ingredients: an ArrayList of MenuItems representing the ingredients used in the making of the current item. 
	 * precondition: name != null;
	 * precondition: price2 != 0;
	 */
	public void editMenuItem(String name, int price, ArrayList<MenuItem> ingredients);
	
	/**
	 * This method is also designed strictly for the Administrator's use. The employee with this role is capable of deleting an item from the menu;
	 * The item is searched using its name;
	 * @param name: a String type variable which will represent the name of the product about to be deleted;
	 * precondition: name != null;
	 * postcondition: menu.size.precondition = menu.size.postcondition + 1;
	 */
	public void deleteMenuItem(String name);
	
	/**
	 * This method is designed only for the Waiter's use. This employee is allowed to create orders and compute them afterwards;
	 * @param id: an Integer type variable, which represents an identifier. It is used for assuring the uniqueness of each particular order created. Two orders will never have the same id;
	 * @param location: a String type variable, which represents the area in which the clients decided to serve the meal. This string could only have two values allowed by the restaurant: inside or outside(terrace); 
	 * @param Table: an Integer type variable, which represents the number of the Client's table. Two orders cannot be computed for the same table. If the table is occupied, the Waiter must provide the customers with another option;
	 * @param date: a Date type variable, which represents the exact date (moment) in which the order is computed. Also it will be relevant for the computing of the bill;
	 * @param menu: an ArrayList of the MenuItems type variable, which represents all the ordered items attached to the current order;
	 * precondition: id != 0;
	 * precondition: location != null;
	 * precondition: Table != 0;
	 * precondition: date != null;
	 * @return it returns an order Object which will later be used for computing the total amount the client has to pay;
	 */
	public Order createNewOrder(int id, String location,int Table, Date date, ArrayList<MenuItem> menu);
	
	/**
	 * This method is designed only for the Waiter's tasks. It is responsible for computing the total amount to pay, for each order received;
	 * @param o: an Order type variable, which represents the current order, the one for which the price is going to be computed;
	 * precondition: order != null;
	 * @return it returns an Integer variable, representing the total price for each order. It will also appear on the bill, when it is generated;
	 */
	public int computePrice(Order order);
	
	/**
	 * This method is designed also for the Waiter's use. It is responsible for computing the bill after an order is created;
	 * @param id: an Integer type variable; it represents the current's order unique identifier (id); 
	 * @param location: a String type variable, which represents the location declared for the current order;
	 * @param Table: an Integer type variable, which represents the table at which the client is being served for the current order;
	 * @param date: a Date type variable, which represents the real-time date;
	 * @param price: an Integer type variable, which represents the total amount the client has to pay, for the current order;
	 * 
	 */
	public void generateBill(int id, String location, int Table, String date, int price);
}
