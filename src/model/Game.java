package model;


/**
 * This Observable will notify any observers whenever 
 * someone sends this Game a movePlayer message.
 * 
 * @author Rick Mercer
 */
import java.awt.Point;
import java.util.Observable;

public class Game{
  Map rooms = new Map();
  public static int TILE_SIZE = 50;
  public Game(int playerX, int playerY, int preMap) {
	rooms= new Map(preMap);
    rooms.setPlayerPosition(playerX,playerY);
    
    
    
    
    
  } 

  
	 //0 is nothing
	 //1 is death by Womp
	 //2 is death by pit
	 //3 is blood
	 //4 is slime
	 //5 is goop
  
  
  public String movePlayer(Direction dir) {
	  int status = rooms.playerMove(dir);
    	if(status==1)
    		return "You have been eaten by the terrible Wumpus!!!";
    	else if(status==2)
    		return "You have fallen into a pit and died!!!";
    	else if(status==3)
    		return "You step in blood. The Wumpus is nearby...";
    	else if(status==4)
    		return "You step in slime. A pit is nearby...";
    	else if(status==5)
    		return "You step in goop. Danger surrounds you!";
    	else
    		return "Nothing to see here hunter...";
    		

  }

}