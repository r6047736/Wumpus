package model;


/**
 * This Observable will notify any observers whenever 
 * someone sends this Game a movePlayer message.
 * 
 * @author Rick Mercer
 */
import java.awt.Point;
import java.util.Observable;

public class Game extends Observable{
  private Map rooms = new Map();
  public static int TILE_SIZE = 50;
  private String status = "";
  
  public Game(int playerX, int playerY, int preMap) {
	setRooms(new Map(preMap));
    getRooms().setPlayerPosition(playerX,playerY);
  } 
  
  
  public Game(int playerX, int playerY) {
		//rooms= new Map(preMap);
	    getRooms().setPlayerPosition(playerX,playerY);
	    getRooms().generateRandomPitsAndWumpus();
	    getRooms().gemerateSlimeandBloods();
	    
	  } 
	  
  
  

  
  

  
	 //0 is nothing
	 //1 is death by Womp
	 //2 is death by pit
	 //3 is blood
	 //4 is slime
	 //5 is goop
  
  
  public void movePlayer(Direction dir) {
	  int status = getRooms().playerMove(dir);
	  
    	if(status==1)
    		this.status =  "You have been eaten by the terrible Wumpus!!!";
    	else if(status==2)
    		this.status  = "You have fallen into a pit and died!!!";
    	else if(status==3)
    		this.status  = "You step in blood. The Wumpus is nearby...";
    	else if(status==4)
    		this.status  = "You step in slime. A pit is nearby...";
    	else if(status==5)
    		this.status  = "You step in goop. Danger surrounds you!";
    	else
    		this.status  =  "Nothing to see here hunter...";
    		
    	setChanged();
	    notifyObservers();
  }
  
  
  
  
  
public String getStatus() {
	return status;
}





public Map getRooms() {
	return rooms;
}
public void setRooms(Map rooms) {
	this.rooms = rooms;
}

}