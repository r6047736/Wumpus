package model;


/**
 * This Observable will notify any move or shoot to the observer.
 * .
 * 
 * @author Haodong Ruan, Kenneth Allison
 */
import java.awt.Point;
import java.util.Observable;



public class Game extends Observable{
	
  private Map rooms ;
  public static int TILE_SIZE = 50;
  private String status = "";
  private boolean playable = true;   // if can click the move button. (avoid press mutiple times when anmation)
  private boolean end = false;  // if die, game ends.
  private boolean win = false;
  

  
  public Game(int playerX, int playerY, int preMap) {
	  //0 is wumpus&pit
	  //1 is wumpus in center
	  //2 is wumpus top left, with pit below and to right
	rooms= new Map(preMap);
    rooms.insertHunter(playerX,playerY);

  } 
  
  
  public Game(int playerX, int playerY) {
		//rooms= new Map(preMap);
	  rooms = new Map();
	    rooms.setPlayerPosition(playerX,playerY);
	    rooms.generateRandomPitsAndWumpus();
	    rooms.gemerateSlimeandBloods();
	    
	    
	  
	  } 
	  
  
  

  
  

  
	 //0 is nothing
	 //1 is death by Womp
	 //2 is death by pit
	 //3 is blood
	 //4 is slime
	 //5 is goop
  


  public void movePlayer(Direction dir) {
	  if (end || !playable){
		  return ;
		  
	  }
	  playable= false;
	  int status = getMap().playerMove(dir);
    	if(status==1){
    		die();
    		this.status =  "You have been eaten by the terrible Wumpus!!! (LOSE)";
    	}
    	else if(status==2){
    		die();
    		this.status  = "You have fallen into a pit and died!!! (LOSE)";
    	}
    	else if(status==3)
    		this.status  = "You step in blood. The Wumpus is nearby...";
    	else if(status==4)
    		this.status  = "You step in slime. A pit is nearby...";
    	else if(status==5)
    		this.status  = "You step in goop. Danger surrounds you!";
    	else
    		this.status  =  "Nothing to see here hunter...";

    		
    	setChanged();
	    notifyObservers(dir);
  }
  
  public void shootWumpus(Direction dir){
	  
	  switch (dir){
	  case NORTH:
	  case SOUTH:
		  for (int i =0 ; i< 10; i++){
			//  System.out.println(rooms.getRooms()[getPointX()][i].type);
			  if (rooms.getRooms()[getPointX()][i].type==Type.Wumpus){
				  this.status ="You shoot the Wumpus! You Win!!!!!! \n(WIN)";
				  win = true;
				  end =true;
				 break;
				 // return true;
				  
			  }
			  rooms.die();
			  end = true;
			  this.status ="You shoot a arrow, But you missed Wumpus! (LOSE)";
		  }
		  setChanged();
		  notifyObservers();
		 break;
	  case WEST:
	  case EAST:
		  for (int i =0 ; i< 10; i++){
			  if (rooms.getRooms()[i][getPointY()].type==Type.Wumpus){
				  this.status ="You shoot the Wumpus! You Win!!!!!! \n(WIN)";
				
				  win= true;
				  end = true;
				  break;
				  //return true;  
			  }
			  rooms.die();
			  end = true;
			
			  this.status ="You shoot a arrow, But you missed Wumpus! (LOSE) ";
		  }
		  setChanged();
		  notifyObservers();
	  break;
	  }
	  
	//  return false;
	  
	  
  }
  
  public void GamePlayable(){
	  playable = true;
	  
  }
  
  public boolean gameWin(){
	  return win;
  }
  
  public boolean gameEnd(){
	  return end;
  }
  
  
  
  
  
public String getStatus() {
	return status;
}
public Map getMap() {
	return rooms;
}



  //reveals whole map, other events on death
	private void die() {
		rooms.die();	
		//playable = false;
		end = true;
	}
	
	public int getPointX(){
		return rooms.getPlayerX();
	}
	
	public int getPointY(){
		return rooms.getPlayerY();
	}
	
	public int getOldPointX(){
		return rooms.getPlayerXOld();
	}
	
	public int getOldPointY(){
		return rooms.getPlayerYOld();
	}
	
	public String toString(){
		return rooms.toStringInvisible();
	}

}