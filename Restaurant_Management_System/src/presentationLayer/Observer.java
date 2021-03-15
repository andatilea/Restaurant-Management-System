package presentationLayer;
import java.util.ArrayList;
import java.util.List;

		//The Observer pattern is used in the situation in which if one object is modified, its dependent objects are to be notified automatically;
	public interface Observer {
	   
	public static final Subject subject = new Subject();
	
		//the method will be overridden and implemented in the ChefGUI Class;
	public void update();
	}

		//A concrete class is implemented;
	class Subject {
	
	   private List<Observer> observers = new ArrayList<Observer>();
	   private String state;

	   public String getState() {
	      return state;
	   }

	   	//the subject's state will be set in the Waiter's GUI Class, every time a new order is created. A specific message will appear as a pop-up in the Chef's interface;
	   public void setState(String state) {
	      this.state = state;
	      notifyAllObservers();
	   }

	   public void attach(Observer observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObservers(){
	      for (Observer observer : observers) {
	         observer.update();
	      }
	   } 	
	}
