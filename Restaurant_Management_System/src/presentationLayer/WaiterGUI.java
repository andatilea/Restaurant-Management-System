	package presentationLayer;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;
	import java.util.Date;

	import javax.swing.*;
	import javax.swing.border.Border;
	import javax.swing.table.DefaultTableModel;

	import businessLayer.*;
	import businessLayer.MenuItem;
	
		//This Class represents the Waiter's job and all the task it needs to perform;
	public class WaiterGUI {

		public JComboBox<String> menuList = new JComboBox<String>();
		public JButton select = new JButton("Select");
		public JButton remove = new JButton("Remove");
		private JLabel items = new JLabel("Menu Items: ");
		private JLabel itemsList = new JLabel("");
		
		public JLabel location = new JLabel("Serving Zone: ");
		private JComboBox<String> locationList;
		private JLabel lTable = new JLabel("Table: ");
		private JTextField tableNr = new JTextField("");
		
		public JButton createO = new JButton("Create Order");
		private JButton computeBill = new JButton("Compute bill");
		
		private JScrollPane table1;
		private JTable orderTable;
		private DefaultTableModel defaultTable;
		
		private Subject subject;
		
		private Color defaultColor = new Color(255,255,250);
		private Color buttonColor = new Color(179,255,217);
		private Color panelColor = new Color(255,255,255);
		private Border blackline = BorderFactory.createLineBorder(Color.black);
		
		private JFrame frame = new JFrame("Waiter");
		private JPanel defaultPanel = new JPanel();
		private JPanel panel1 = new JPanel();
		private JPanel panel2 = new JPanel();
		private JPanel panel3 = new JPanel();
		
		private IRestaurantProcessing rp;
		Order order;
		
		//this method sets all the existing panels by choosing a specific layout, colour and border;
		public void setPanels() {
			
			defaultPanel.setLayout(new FlowLayout());
			defaultPanel.setBackground(defaultColor);
			panel1.setLayout(new FlowLayout());
			panel1.setBackground(panelColor);
			panel1.setBorder(blackline);
			panel2.setLayout(new FlowLayout());
			panel2.setBackground(panelColor);
			panel2.setBorder(blackline);
			panel3.setLayout(new FlowLayout());
			panel3.setBackground(panelColor);
			panel3.setBorder(blackline);
		}
		
			//this method sets all the existing components by choosing a specific size, colour;
		public void setComponents() {
			
			menuList.setPreferredSize(new Dimension(150,30));
			menuList.setBackground(buttonColor);
			select.setBackground(buttonColor);
			remove.setBackground(buttonColor);
			items.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			itemsList.setPreferredSize(new Dimension(400,30));
			location.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			tableNr.setPreferredSize(new Dimension(150,30));
			lTable.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			String[] locations = new String[] { "outside", "inside"};
			locationList = new JComboBox<>(locations);
			locationList.setPreferredSize(new Dimension(150,30));
			locationList.setBackground(buttonColor);
			createO.setPreferredSize(new Dimension(120,30));
			createO.setBackground(buttonColor);
			computeBill.setPreferredSize(new Dimension(120,30));
			computeBill.setBackground(buttonColor);
		}
		
			//this method sets the JTable created for orders;
		public void setTable() {
			
			String[] orderTableHeader = {"OrderID", "Serving Zone", "Table" ,"Date"};	//the Table will contain a header with four columns;
			defaultTable = new DefaultTableModel(orderTableHeader, 0);
			orderTable = new JTable(defaultTable);
			table1 = new JScrollPane(orderTable);
		}
		
			//all the elements of the graphical user's interface, will be added to the corresponding panels, and the setting functions presented above will be called.
		public WaiterGUI(IRestaurantProcessing rp, Subject subject) {
			
			this.subject = subject;
			this.rp = rp;
			frame.setSize(1000, 600);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setPanels();
			this.setComponents();
			this.setTable();
			panel1.add(menuList); 
			panel1.add(select);
			panel1.add(remove);
			panel1.add(items);
			panel1.add(itemsList);
			panel2.add(location);
			panel2.add(locationList);
			panel2.add(lTable);
			panel2.add(tableNr);
			panel2.add(table1);
			panel2.add(createO);
			panel2.add(computeBill);
			panel3.add(table1);
			defaultPanel.add(panel1);
			defaultPanel.add(panel2);
			defaultPanel.add(panel3);
			frame.setContentPane(defaultPanel);
			frame.setVisible(true);
		}
		
			//this getter method will return the entire menu list, being constantly updated to each operation performed;
		public JComboBox<String> displayMenuList() {
			return this.menuList;
		}
		
			//this method is responsible for selecting any menu item desired for an order;	
		public void selectItem() {
			
			String select = new String();
			String menuItemsList = itemsList.getText();
			String menuItem = (String) menuList.getSelectedItem();		//it stores the selected product from the menu's JComboBox;
			select = menuItemsList.concat(" " + menuItem);				//all the menu items selected will be displayed separately, containing a "  " (space) between them;
			itemsList.setText(select);
		}
		
		public void removeItem() {
			
			String remove = new String();
			String menuItemsList = itemsList.getText();
			String itemToRemove = (String) menuList.getSelectedItem();	//it stores the selected product from the menu's JComboBox;	
			remove = menuItemsList.replace(itemToRemove, "");			
			itemsList.setText(remove);									//the wanted menu item will be removed and not taken into consideration for the current order;
			if(!menuItemsList.contains(itemToRemove)) {					//The Application also deals with the case in which, a certain element is selected in the JComboBox but it does not represent a part of the current menu items list;
			JOptionPane.showMessageDialog(frame, "The selected element is not a part of the current items");	//in this case, a message will be displayed;
				}
			}
		
			//this boolean function represents a way of verifying if a Table number is already occupied by another clients or it is available for new clients; 
		public boolean check() {						
			boolean ok = false;
			String Table =  tableNr.getText();			//the input number inserted by the user;
			for(int j=0;j<orderTable.getRowCount();j++) {
			if(orderTable.getValueAt(j, 2).toString().contains(Table)) {
			ok = true;									//if this condition is satisfied then the wanted Table is already occupied;
				}
			}
			return ok;									//else, the Table is free;
		}	
		
			//this method is responsible for creating a new order, when required;
		public void createOrder() {
			
			String selected = itemsList.getText();
			ArrayList<MenuItem> menuItemsOrdered = new ArrayList<MenuItem>();
			int orderID = orderTable.getRowCount() + 1;
			String location = (String) locationList.getSelectedItem();
			int Table = Integer.parseInt(tableNr.getText());
			Date date = new Date();
			int price = 0;
			if(!selected.equals("")) {			//the Application makes sure that the Client ordered at least one menu item in order for the Waiter to compute the Order;
			if(this.check()== true) {			//the Application also checks if the Table wanted by the user is available;
			JOptionPane.showMessageDialog(frame, "This Table is already occupied! Please check the Table for details");	}		//if the table will not be available, a suggestive message will be displayed;
			else if(this.check() == false) {
			String[] selectedItems = selected.split(" ");
			for(int i=0; i<selectedItems.length; i++) {
			int size = rp.getMenuItems().size();
			for(int j=0; j<size; j++) {
			MenuItem currentItem = rp.getMenuItems().get(j);
			String wantedName = currentItem.getName();
			if(selectedItems[i].equals(wantedName))		
			menuItemsOrdered.add(currentItem);		}	//the specific product will be added to the String of items ordered (they will be displayed in the order's message notification);
			}
			Order o = rp.createNewOrder(orderID, location,Table, date, menuItemsOrdered);		//using the Restaurant's implemented method for creating a new order;
			price = rp.computePrice(o);					//the Application computes the corresponding price;
			order = o;
			String[] add1= {Integer.toString(orderID), location, Integer.toString(Table), date.toString()};
			defaultTable.addRow(add1);					//for each order created, a new table row will be added;
			JOptionPane.showMessageDialog(frame, "The Order was created :" + "\n Number: " + orderID + "\n Serving: " + location +  "\n Table: " 
			+ Table + "\n At the date: " + date + "\n Ordering: " + selected + "\n Amount to pay: " + price);	//after the order is created a pop-up message will appear with all the current's order information;
			subject.setState("\nNew Order!! " + "Id:" + orderID + ", served: " + location + ", at the Table:" + Table);	}		//set the notification for the Chef;
			this.itemsList.setText("");	
			} else {
			JOptionPane.showMessageDialog(frame, "Please select the Menu Items!");	}
		}
		
		//This method implements the action listener needed for the "compute bill" button;
		public void addActionListener() {
			
			computeBill.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					
					for(int i=0;i<orderTable.getRowCount();i++) {
					if(Integer.parseInt(orderTable.getValueAt(i, 0).toString()) == orderTable.getRowCount()) {
					int id = orderTable.getRowCount();
					int price =  rp.computePrice(order);
					rp.generateBill(id, order.getLocation(), order.getTable(), order.getDate().toString(), price);		//the Restaurant's implemented method for computing the bill is used;
							}
						}
					}
				});
			}
		}
