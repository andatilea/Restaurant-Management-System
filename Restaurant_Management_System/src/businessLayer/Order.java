package businessLayer;
import java.util.Date;

		//This Class represents the most important part of a Waiter's job. This Class contains all the order related attributes;
	public class Order {

	private int orderID;		//an unique identifier for each order;
	private String location;	//the serving location: each client is able to choose between being served in the outside area or inside;
	private int Table;			//it represents the table's number at which the client will stay;
	private Date date;			//the current date marking the computation of the order, also being used for creating the bill;
	
	public Order(int orderID, String location, int Table, Date date) {
		
		this.orderID = orderID;
		this.location = location;
		this.Table = Table;
		this.date = date;
	}
	
		//the getter methods are used in order to obtain the needed information regarding the current order;
	public int getId() {
		return this.orderID;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public int getTable() {
		return this.Table;
	}
	
	public Date getDate() {
		return this.date;
	}
	
		//overridden method responsible for generating the hash code in order to know where to place the mapping;
	@Override				
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + orderID;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + Table;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;		//the method will return an unique integer;
	}
	
		//overridden method which will be responsible for helping the user determine if two orders are equal or not;
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) return true;
		
		if (obj == null) return false;
		
		if (this.getClass() != obj.getClass()) return false;
		
		Order other = (Order) obj;
		if (this.orderID != other.orderID)  return false;
		if (this.location != other.location) return false;
		if(this.Table != other.Table) return false;
		if (date == null) {
		if (other.date != null) return false;
		} else if (date != other.date) return false;

		return true;
	}
	}