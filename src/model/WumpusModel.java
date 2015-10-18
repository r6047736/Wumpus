package model;

import java.util.Observable;
import java.util.Random;

public class WumpusModel extends Observable{

		Map rooms ;

	  public WumpusModel() {
		  rooms = new Map();
		  rooms.generateRandomPitsAndWumpus();
		  rooms.gemerateSlimeandBloods();
		  
	  }
	  
	  public WumpusModel(Random r){
		  
		  
	  }

	  public String toString() {
	    return rooms.toString();
	  }
	  
	  public Map getMap(){
		 return rooms; 
		  
	  }

	  public void increment() {
	    
	    setChanged(); // Needed by Observer/Observable
	    notifyObservers(this); // Needed by Observer/Observable
	  }
	
	
	

}
