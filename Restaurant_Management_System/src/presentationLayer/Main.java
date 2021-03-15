package presentationLayer;

import businessLayer.Restaurant;

		//This Class is responsible for launching the entire Application;
	public class Main {

		//The order of the user's interfaces is presented below, for creating a more practical simulation of the Restaurant;
	public static void main(String[] args) {
		
		Subject subject = new Subject();
		Restaurant restaurant = new Restaurant();
		new ChefGUI(subject);
		WaiterGUI waiter = new WaiterGUI(restaurant, subject);
		AdministratorGUI admin = new AdministratorGUI(restaurant);
		new Controller(admin, waiter);
	}	
}
