	package presentationLayer;
	import java.awt.*;
	import java.util.ArrayList;
	import javax.swing.*;
	import javax.swing.border.Border;
	import javax.swing.table.DefaultTableModel;
	import businessLayer.IRestaurantProcessing;
	import businessLayer.MenuItem;
	public class AdministratorGUI {

		private JLabel baseProductName = new JLabel("Base Product Name: ");
		public JTextField baseProductNameTxt = new JTextField("");
		private JLabel baseProductPrice = new JLabel("Price: ");
		private JTextField baseProductPriceTxt = new JTextField("");
		public JButton addBaseP = new JButton("Add Base Product");
		public JButton editBaseP = new JButton("Edit Base Product");
		public JButton deleteBaseP = new JButton("Delete Base Product");
		
		private DefaultTableModel defaultTable;
		private JTable baseProductTable;
		private JScrollPane table1;
		
		public JComboBox<String> productList = new JComboBox<String>();
		public JButton selectP = new JButton("Select Ingredients");
		private JLabel ingredients = new JLabel("Ingredients: ");
		private JLabel ingredientsList = new JLabel("");
		public JButton removeP = new JButton("Remove Ingredients");
		
		private JLabel compositeProductName = new JLabel("Composite Product Name:");
		public JTextField compositeProductNameTxt = new JTextField("");
		public JButton addCompositeP = new JButton("Add Composite");
		public JButton editCompositeP = new JButton("Edit Composite");
		public JButton deleteCompositeP = new JButton("Delete Composite");
		
		private DefaultTableModel defaultTable2;
		private JTable compositeProductTable;
		private JScrollPane table2;
		
		private Color panelColor = new Color(255,255,250);
		private Color buttonColor = new Color(255,204,230);
		private Color p = new Color(255,255,255);
		private Border blackline = BorderFactory.createLineBorder(Color.black);
		private JFrame frame = new JFrame("Administrator");
		private JPanel defaultPanel = new JPanel();
		private JPanel panel1 = new JPanel();
		private JPanel panel2 = new JPanel();
		private JPanel panel3 = new JPanel();
		private JPanel panel4 = new JPanel();
		private JPanel panel5 = new JPanel();
		private JPanel panel6 = new JPanel();
		private IRestaurantProcessing rp;

		public void setPanels() {						//this method sets all the existing panels by choosing a specific layout, colour and border;
			defaultPanel.setLayout(new FlowLayout());
			defaultPanel.setBackground(panelColor);
			panel1.setLayout(new FlowLayout());
			panel1.setBackground(p);
			panel1.setBorder(blackline);
			panel2.setLayout(new FlowLayout());
			panel2.setBackground(p);
			panel2.setBorder(blackline);
			panel3.setLayout(new FlowLayout());
			panel3.setBackground(p);
			panel3.setBorder(blackline);
			panel4.setLayout(new FlowLayout());
			panel4.setBackground(p);
			panel4.setBorder(blackline);
			panel5.setLayout(new FlowLayout());
			panel5.setBackground(p);
			panel5.setBorder(blackline);
			panel6.setLayout(new FlowLayout());
			panel6.setBackground(p);
			panel6.setBorder(blackline); 
			}
		
		public void setComponents() {						//this method sets all the existing components by choosing a specific size, colour;
			baseProductName.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			baseProductNameTxt.setPreferredSize(new Dimension(75,30));
			baseProductPrice.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			baseProductPriceTxt.setPreferredSize(new Dimension(45,30));
			addBaseP.setPreferredSize(new Dimension(200,30));
			addBaseP.setBackground(buttonColor);
			editBaseP.setPreferredSize(new Dimension(200,30));
			editBaseP.setBackground(buttonColor);
			deleteBaseP.setPreferredSize(new Dimension(200,30));
			ingredients.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			deleteBaseP.setBackground(buttonColor);
			productList.setPreferredSize(new Dimension(200,30));
			productList.setBackground(buttonColor);
			selectP.setPreferredSize(new Dimension(200,30));
			selectP.setBackground(buttonColor);
			removeP.setPreferredSize(new Dimension(200,30));
			removeP.setBackground(buttonColor);
			ingredientsList.setPreferredSize(new Dimension(400,30));
			compositeProductName.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			compositeProductNameTxt.setPreferredSize(new Dimension(80,30));
			addCompositeP.setPreferredSize(new Dimension(130,30));
			addCompositeP.setBackground(buttonColor);
			editCompositeP.setPreferredSize(new Dimension(130,30));
			editCompositeP.setBackground(buttonColor);
			deleteCompositeP.setPreferredSize(new Dimension(150,30));
			deleteCompositeP.setBackground(buttonColor);
		}
		
		public void setTableBase() {						//this method sets the JTable created for base products;
			String[] baseProductHeader = {"Base Product Name", "Price"};
			defaultTable = new DefaultTableModel(baseProductHeader, 0);
			baseProductTable = new JTable(defaultTable);
			table1 = new JScrollPane(baseProductTable);
			table1.setPreferredSize(new Dimension(500,200));
		}
		
		public void setTableComposite() {					//this method sets the JTable created for composite products;
			String[] compositeProductHeader = {"Composite Product Name","Price", "Ingredients"};
			defaultTable2 = new DefaultTableModel(compositeProductHeader, 0);
			compositeProductTable = new JTable(defaultTable2);
			table2 = new JScrollPane(compositeProductTable);
			table2.setPreferredSize(new Dimension(500,200));
		}
		
		public AdministratorGUI(IRestaurantProcessing rp) {			//all the elements of the graphical user's interface, will be added to the corresponding panels;
			this.rp = rp;
			frame.setSize(1000, 650);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setPanels();
			this.setComponents();
			panel1.add(baseProductName);
			panel1.add( baseProductNameTxt);
			panel1.add(baseProductPrice);
			panel1.add(baseProductPriceTxt);
			panel1.add(addBaseP);
			panel1.add(editBaseP);
			panel1.add(deleteBaseP);
			this.setTableBase();
			panel2.add(table1);
			panel3.add(productList);
			panel3.add(selectP);
			panel3.add(removeP);
			panel4.add(ingredients);
			panel4.add(ingredientsList);
			panel4.add(compositeProductName);
			panel4.add(compositeProductNameTxt);
			panel5.add(addCompositeP);
			panel5.add(editCompositeP);
			panel5.add(deleteCompositeP);
			this.setTableComposite();
			panel6.add(table2);
			defaultPanel.add(panel1);
			defaultPanel.add(panel2);
			defaultPanel.add(panel3);
			defaultPanel.add(panel4);
			defaultPanel.add(panel5);
			defaultPanel.add(panel6);
			frame.setContentPane(defaultPanel);
			frame.setVisible(true);	
		}
		
		public String[] addBaseProduct() {			//this method adds a new product in the list, only if both the name text field and the price one contain input data provided by the user;
			ArrayList<MenuItem> compositionList = new ArrayList<MenuItem>();
			String name =  baseProductNameTxt.getText();
			String price = baseProductPriceTxt.getText();
			String[] add1 = {name, price};
			if(!name.equals("") && !price.equals("")) {
			productList.addItem(name);
			int correctPrice = Integer.parseInt(price);
			rp.createMenuItem( name, correctPrice, compositionList);
			defaultTable.addRow(add1);	
			this.baseProductNameTxt.setText("");
			this.baseProductPriceTxt.setText("");		//the text fields will be reseted after the addition takes place;
			} else JOptionPane.showMessageDialog(frame, "Please make sure the name of the Base Product and the Price are chosen");
			return add1;
		}
		
		public String[] addCompositeProduct() {											
			ArrayList<MenuItem> compositionList = new ArrayList<MenuItem>();
			String name = compositeProductNameTxt.getText();
			int price = 0;
			String selectedIngredients = ingredientsList.getText();		//firstly, the application checks if at least one ingredient has been selected by the user;
			if(selectedIngredients.equals("")) {	JOptionPane.showMessageDialog(frame, "The list of ingredients is currently empty");
			}else if(!name.equals("")) {								//then, it is checked if the name text field is not empty (a non-null value must be entered by the user);
			String[] wantedIngredients = selectedIngredients.split(" ");
			for(int i=0; i<wantedIngredients.length; i++) {
			ArrayList<MenuItem> menu = rp.getMenuItems();				//place all the current menu items in a list;
			for(int j=0; j<menu.size(); j++) {
			MenuItem currentItem = menu.get(j);
			if(wantedIngredients[i].equals(currentItem.getName())) {	//if the ingredient is found in the items already created, then the price will be computed accordingly and it will be added to the product's ingredient list;
			price += currentItem.computePrice();
			compositionList.add(currentItem);	}	} 	
			}
			rp.createMenuItem(name, price, compositionList);
			productList.addItem(name);
			String[] add2 = {name, Integer.toString(price), selectedIngredients};
			defaultTable2.addRow(add2);
			this.ingredientsList.setText("");
			this.compositeProductNameTxt.setText("");					//the text fields are set after the addition takes place;
			} else JOptionPane.showMessageDialog(frame, "Please insert the name of the Composite Product");	
			String[] result = {name, Integer.toString(price)};
			return  result;
		}
		
		public boolean check() {										//this method represents a verification function, in order to see if a base product represents an ingredient for any composite products created;
			boolean ok = false;
			String name =  baseProductNameTxt.getText();
			for(int j=0;j<compositeProductTable.getRowCount();j++) {
			if(((compositeProductTable.getValueAt(j, 2).toString().contains(name)) && !name.equals(""))) {	
			ok = true;	}	}
			return ok;
		}
		
		public boolean checkB() {										//this method represents a verification function, in order to see if a composite product represents an ingredient for another composite product created;
			boolean ok = false;
			String name2 =  compositeProductNameTxt.getText();
			for(int j=0;j<compositeProductTable.getRowCount();j++) {
			if((compositeProductTable.getValueAt(j, 2).toString().contains(name2)) && !name2.equals("")) {
			ok = true;	}	}
			return ok;
		}
		
		public void editBaseProduct() {											
			if(baseProductNameTxt.getText().equals("") || baseProductPriceTxt.getText().equals("")) {	JOptionPane.showMessageDialog(frame, "Please insert all the data of the Base Product before editing");	}
			String newPrice = baseProductPriceTxt.getText();
			String wantedName = baseProductNameTxt.getText();
			int correctPrice = Integer.parseInt(baseProductPriceTxt.getText());
			if(this.check()== true) {	JOptionPane.showMessageDialog(frame, "This Base Product cannot be edited since it is a part of some Composite Products! Please check Table2");	}
			else if(this.check() == false) {							//a base product can be edited only if it is not an ingredient for a composite product;
			for(int i=0; i<baseProductTable.getRowCount(); i++) {
			String name =(String) baseProductTable.getValueAt(i, 0);
			if(name.equals(wantedName)) {								//the item is searched by name, if the wanted name is found, then the product will be edited;
			ArrayList<MenuItem> list = new ArrayList<MenuItem>();
			rp.editMenuItem( wantedName, correctPrice, list);
			defaultTable.setValueAt(newPrice, i, 1);	}	}			//update the table's corresponding column (price);
			}
			this.baseProductNameTxt.setText("");
			this.baseProductPriceTxt.setText("");
		}
		
		public String deleteBaseProduct() {	
			String delete1 = new String();
			String wantedName = baseProductNameTxt.getText();
			if(this.check()== true) {	JOptionPane.showMessageDialog(frame, "This Base Product cannot be deleted since it is a part of some Composite Products! Please check Table2");	}
			else if(this.check() == false) {							//a base product can be deleted only if it is not an ingredient for a composite product;
			for(int i=0; i<baseProductTable.getRowCount(); i++) { 
			delete1 = (String) baseProductTable.getValueAt(i, 0);
			if(delete1.equals( wantedName)) {							//the item is searched by name, if the wanted name is found, then the product will be deleted;
			rp.deleteMenuItem(delete1);
			productList.removeItem(delete1);
			defaultTable.removeRow(i);
			if(ingredientsList.getText().contains(wantedName))	ingredientsList.getText().replace(wantedName, "");		//the application also checks the ingredients area, if the deleted product remains there by mistake, it will be deleted;
			this.baseProductNameTxt.setText("");
			return wantedName;	}	}
			}
			return "";
		}
		
		public String deleteCompositeProduct() {	
			String delete2 = new String();
			String wantedName = compositeProductNameTxt.getText();
			if(this.checkB()== true) {	JOptionPane.showMessageDialog(frame, "This Composite Product cannot be deleted since it is a part of another Composite Product! Please check all the Ingredients from the third column");
			} else if(this.checkB() == false) {							//a composite product can be deleted only it is not an ingredient for another composite product;
			for(int i=0; i<compositeProductTable.getRowCount(); i++) { 
			delete2 = (String) compositeProductTable.getValueAt(i, 0);
			if(delete2.equals(wantedName)) { 							//the item is searched by name, if the wanted name is found, then the item will be deleted;
			productList.removeItem(delete2);
			rp.deleteMenuItem(delete2);
			defaultTable2.removeRow(i);		
			return wantedName;}	}										//if the deletion takes place, the wanted name is returned for its usage in the Controller Class;
			this.compositeProductNameTxt.setText("");	}
			return "";
		}
		
		public void editCompositeProduct() {
			if(compositeProductNameTxt.getText().equals("")) JOptionPane.showMessageDialog(frame, "Please insert the wanted name before editing!");
			String wantedName = compositeProductNameTxt.getText();
			String selectedIngredients = ingredientsList.getText();
			String[] wantedIngredients = selectedIngredients.split(" ");
			ArrayList<MenuItem> compositionList = new ArrayList<MenuItem>();
			int price = 0;
			if(this.checkB()== true) {	JOptionPane.showMessageDialog(frame, "This Composite Product cannot be edited since it is a part of another Composite Product! Please check all the Ingredients from the third column");
			} else if(this.checkB() == false) {							// a composite product cannot be edited if it represents an ingredient for another composite product;
			for(int i=0; i<wantedIngredients.length; i++) {
			ArrayList<MenuItem> menu = rp.getMenuItems();
			for(int j=0; j<menu.size(); j++) {
			MenuItem currentItem = menu.get(j);
			if(wantedIngredients[i].equals(currentItem.getName())) {	//the application is computing the new price and the ingredients list;
			price += currentItem.computePrice();
			compositionList.add(currentItem);	}	}
			}
			for(int j=0;j<compositeProductTable.getRowCount();j++) {
			String name = (String) compositeProductTable.getValueAt(j, 0);
			if((name.contains(wantedName))) {							//the item is searched by name in the menu list, if it is founded, then the item will be edited;
			rp.editMenuItem( wantedName, price, compositionList);
			defaultTable2.setValueAt(selectedIngredients, j, 2);		//update the values in the composite products table, more exactly the ingredients list;
			defaultTable2.setValueAt(price, j, 1);	}	}	}
			this.ingredientsList.setText("");
			this.compositeProductNameTxt.setText("");
			}
		
		public void selectIngredient() {								//this method selects at least one item from the created list, containing both base and composite products;
			String select = new String();
			String ingredients = ingredientsList.getText();
			String wantedIngredient = (String) productList.getSelectedItem();
			select = ingredients.concat(" " + wantedIngredient);
			ingredientsList.setText(select);							//the text is set in the ingredients area (the label created);
		}
		
		public String removeIngredient() {								//this method removes an ingredient by its name;
			String remove = new String();
			String ingredients = ingredientsList.getText();
			String ingredientToRemove = (String) productList.getSelectedItem();
			remove = ingredients.replace(ingredientToRemove, "");
			ingredientsList.setText(remove);
			if(!ingredients.contains(ingredientToRemove)) JOptionPane.showMessageDialog(frame, "The selected element is not a part of the current ingredients");	//if the user wants to remove an ingredient which is not presented in the list, a message will be displayed;
			return ingredientToRemove;
		}
		}