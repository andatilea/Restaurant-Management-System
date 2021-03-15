package presentationLayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

		//This Class is responsible for the implementation of almost all the actions performed by the administrator's and waiter's buttons. 
	public class Controller {
	
	private AdministratorGUI administrator;
	private WaiterGUI waiter;
	
	public Controller(AdministratorGUI administrator, WaiterGUI waiter) {
		
		this.administrator = administrator;
		this.waiter = waiter; 
		this.addActionListenerAdminBaseProduct();
		this.addActionListenerAdminCompositeProduct();
		this.addActionListenerWaiter();
		waiter.addActionListener();
	}
	
		//For each button, a certain function is called, this method dedicates itself to the "base products" operations;
	public void addActionListenerAdminBaseProduct() {
		
		administrator.addBaseP.addActionListener(new ActionListener() {		//the button especially created for adding base products;
			public void actionPerformed(ActionEvent arg0) {
			String[] product = administrator.addBaseProduct();		//the "add menu item" method implemented in the administrator's GUI is called and the result is saved in the "product" String;
			if(!product[0].equals("") && !product[1].equals("")) {	//the Application makes sure that all the needed input data is entered by the user in order to be used in the proper menu list;
			waiter.displayMenuList().addItem(product[0]);			//the successfully added item will also be added in the menu list present in the waiter's GUI;
				}
			}
		});
		
		administrator.editBaseP.addActionListener(new ActionListener() {	//the button especially created for editing base products;
			public void actionPerformed(ActionEvent arg0) {
			administrator.editBaseProduct();						//the "edit menu item" method implemented in the administrator's GUI is called;
			}
		});
		
		administrator.deleteBaseP.addActionListener(new ActionListener() {	//the button especially created for deleting base products;
			public void actionPerformed(ActionEvent arg0) {			
			String name = administrator.deleteBaseProduct();		//the result of the administrator's GUI method is stored in the "name" String declared;
			if(!name.equals("")) {									//the Application makes sure that the user does not search to delete a product with a "null" name;
			waiter.displayMenuList().removeItem(name);				//if the deletion is performed successfully, the wanted item will also be deleted from the waiter's menu list;
			}
			}
		});
	}
	
		//This method implements the action listeners for the "composite products" operations;
	public void addActionListenerAdminCompositeProduct() {
		
		administrator.selectP.addActionListener(new ActionListener() {		//the button especially created for selecting the ingredients (for a composite product);
			public void actionPerformed(ActionEvent arg0) {
			administrator.selectIngredient();								//the "select ingredients" method is called;
			}
		});
		
		administrator.removeP.addActionListener(new ActionListener() {		//the button especially created for removing the ingredients (non-wanted items);
			public void actionPerformed(ActionEvent arg0) {
			administrator.removeIngredient();								//"remove ingredients" method is called;
			}
		});
		
		administrator.addCompositeP.addActionListener(new ActionListener() {	//button created for adding composite products;
			public void actionPerformed(ActionEvent arg0) {
			String[] product = administrator.addCompositeProduct();				//the result of the administrator's method is stored in the "product" String declared;
			if(!product[0].equals("") && !product[1].equals(""))	{			//the Application makes sure that the text field needed for the input data does not remain empty when a new item is about to be created;
			waiter.displayMenuList().addItem(product[0]);						//if the addition is done successfully, the item will also be added in the waiter's menu list;
				}										
			}
		});
		
		administrator.editCompositeP.addActionListener(new ActionListener() {	//button created for editing composite products;
			public void actionPerformed(ActionEvent arg0) {
			administrator.editCompositeProduct();								//the administrator's "edit composite product" method is called;
			}
		});
		
		administrator.deleteCompositeP.addActionListener(new ActionListener() {	//button created for deleting composite products;
			public void actionPerformed(ActionEvent arg0) {
			String name = administrator.deleteCompositeProduct();				//the result of the administrator's method will be stored in the "name" String declared;
			if(!name.equals("")) {												//the Application makes sure that the text field which provides the input is not empty(null);
			waiter.displayMenuList().removeItem(name);							//if the deletion is achieved successfully, the item will also be removed from the waiter's menu list;
			}
			}
		});
	}
	
		//This method implements the action listeners needed for all the Waiter's operations;
	public void addActionListenerWaiter() {
		
		waiter.createO.addActionListener(new ActionListener() {					//button designed for creating a new order;
			public void actionPerformed(ActionEvent arg0) {
			waiter.createOrder();												//the "create Order" waiter's function is called;
			}
		});
		
		waiter.select.addActionListener(new ActionListener() {					//button designed for selecting the menu items which the client desired to order;
			public void actionPerformed(ActionEvent arg0) {
			waiter.selectItem();												//the method calls and uses the waiter's implemented function "select Item";
			}
		});
		
		waiter.remove.addActionListener(new ActionListener() {					//button designed for removing the menu items selected by mistake by the waiter
			public void actionPerformed(ActionEvent arg0) {
			waiter.removeItem();												//the waiter's implemented method "remove Item" will be called;
			}
		});
		
	}
}