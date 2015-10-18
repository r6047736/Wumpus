package model;

import java.util.ArrayList;
import java.util.Observer;

import java.util.Observable;

public class Map {
	
	

	public static int TILE_SIZE = 50;
	 public static int WIDTH = 10;
	 public static int HEIGHT  =10;
	 
	 private Room[][] rooms = new Room[10][10]; 
	 
	 private int playerX;
	 private int playerY;
	 
	 
	 public static void main(String[] args){
		 Map a = new Map();
		 a.generateRandomPitsAndWumpus();
		 a.gemerateSlimeandBloods();
		 System.out.println(a.toString());
		 
	 }
	 
	 
	 public Map(){
		 for (int i=0; i<10;i++){
			 for (int j=0; j<10;j++){
				 rooms[i][j] = new Room(Type.Nothing);
			 } 
			 
		 }
		 
	 }
	 
	 
	 //uses pre-rendered map
	 public Map(int preMap) {
		 if(preMap == 1)
			 rooms = WumpusOnEdge();
		 else if(preMap == 1)
			rooms = WumpusOnly();
		else
			rooms = WumpusAndPit();
	}


	private Room[][] WumpusOnEdge() {
		Room[][] wumPitsEdge = new Room[WIDTH][HEIGHT];
		for(int i = 0; i< WIDTH; i++){
			for(int j = 0; j< HEIGHT; j++){
				if(i==0 && j==0)
					wumPitsEdge[i][j] = new Room(Type.Wumpus);
				else if(i==0 && j==1)
					wumPitsEdge[i][j] = new Room(Type.Pit);
				else if(i==1 && j==0)
					wumPitsEdge[i][j] = new Room(Type.Pit);
				else
					wumPitsEdge[i][j] = new Room(Type.Nothing);					
			}
		}
		
		this.gemerateSlimeandBloods();
		
		return wumPitsEdge;
	}


	private Room[][] WumpusAndPit() {
		Room[][] wumPits = new Room[WIDTH][HEIGHT];
		for(int i = 0; i< WIDTH; i++){
			for(int j = 0; j< HEIGHT; j++){
				if(i==4 && j==4)
					wumPits[i][j] = new Room(Type.Wumpus);
				else if(i==j)
					wumPits[i][j] = new Room(Type.Pit);
				else
					wumPits[i][j] = new Room(Type.Nothing);					
			}
		}
		
		this.gemerateSlimeandBloods();
		
		return wumPits;
	}



	private Room[][] WumpusOnly() {
		Room[][] wumpusRooms = new Room[WIDTH][HEIGHT];
		for(int i = 0; i< WIDTH; i++){
			for(int j = 0; j< HEIGHT; j++){
				if(i==4 && j==4)
					wumpusRooms[i][j] = new Room(Type.Wumpus);
				else
					wumpusRooms[i][j] = new Room(Type.Nothing);					
			}
		}
		
		this.gemerateSlimeandBloods();
		
		return wumpusRooms;
	}


	public void generateRandomPitsAndWumpus(){
		 //Pits;
		 int pistNum = (int) (Math.random() * 2) + 3;
		 System.out.println("pits numer = "+pistNum);
		 
		 for (int i=0;i<pistNum;i++){
			 int x =  (int) (Math.random() * 9) ;
			 int y = (int) (Math.random() * 9) ;
			 
			 rooms[y][x] = new Room(Type.Pit);
			 System.out.println("pits = "+x+","+y);
			 //TODO late
			 // xy same time?
		 }
		 
		 //Wumpus 
		 
		 int x =  (int) (Math.random() * 9) ;
		 int y = (int) (Math.random() * 9) ;
		
		 	rooms[y][x] = new Room(Type.Wumpus);
		 	System.out.println("Wumpus = "+x+","+y);
		//TODO late
		// xy cover pit?
		 
		 
	 }
	 public void gemerateSlimeandBloods(){
		 for(int i = 0; i<10;i++){
			 for(int j = 0; j<10;j++){
				 if(rooms[i][j].getType() == Type.Wumpus){
					 fill(Type.Wumpus,i,j);
				 }
				 if(rooms[i][j].getType() == Type.Pit){
					fill(Type.Pit, i, j);	
				 }
			 }
		 }
		 
		 
		 
	 }
	 
	 
	 private void fill(Type type, int y, int x) {
			if (type == Type.Pit){
				rooms[y][(x+1)%10].changeType(Type.Slime);
				rooms[y][(x-1+10)%10].changeType(Type.Slime);
				rooms[(y-1+10)%10][x].changeType(Type.Slime);
				rooms[(y+1)%10][x].changeType(Type.Slime);
			}
			if (type ==Type.Wumpus){
				rooms[y][(x+1)%10].changeType(Type.Blood);
				rooms[y][(x-1+10)%10].changeType(Type.Blood);
				rooms[(y-1+10)%10][x].changeType(Type.Blood);
				rooms[(y+1)%10][x].changeType(Type.Blood);
				rooms[y][(x+2)%10].changeType(Type.Blood);
				rooms[y][(x-2+10)%10].changeType(Type.Blood);
				rooms[(y-2+10)%10][x].changeType(Type.Blood);
				rooms[(y+2)%10][x].changeType(Type.Blood);
				
				rooms[(y+1)%10][(x+1)%10].changeType(Type.Blood);
				rooms[(y+1)%10][(x-1+10)%10].changeType(Type.Blood);
				rooms[(y-1+10)%10][(x+1)%10].changeType(Type.Blood);
				rooms[(y-1+10)%10][(x-1+10)%10].changeType(Type.Blood);
				
				
				
			}
			
			  
				
		}
	 
	 public String toString(){
		 String s = "";
		 for (int i =0; i< 10; i++){
			 for (int j=0; j<10;j++){
				 s+= "["+rooms[j][i].getType().getChar()+"]";
				 
			 }
			 s+="\n";
			 
		 }
		 return s;
		 
	 }
	 public String toStringInvisible(){
		 String s = "";
		 for (int i =0; i< 10; i++){
			 for (int j=0; j<10;j++){
				 if (playerX==j && playerY==i){
					 s+="[O]";
				 }
			 else if (rooms[j][i].isVisible){
				 s+= "["+rooms[j][i].getType().getChar()+"]";
				 }
				 else
					s+="[X]";
			 }
			 s+="\n";
			 
		 }
		 return s;
		 
	
		 
		 
	 }
	 
	 public int playerMove(Direction d){
		 rooms[playerX][playerY].exit();
		 if(d == Direction.WEST)
			 playerX=(playerX-1+10)%10;
		 else if(d==Direction.EAST)
			 playerX=(playerX+1)%10;
		 else if(d==Direction.NORTH)
			 playerY=(playerY+9)%10;
		 else
			 playerY=(playerY+1)%10;
		 
		 //0 is nothing
		 //1 is death by Womp
		 //2 is death by pit
		 //3 is blood
		 //4 is slime
		 //5 is goop
		 
		 rooms[playerX][playerY].enter();
		 
		 if(rooms[playerX][playerY].getType() == Type.Pit)
			 return 2;
		 else if(rooms[playerX][playerY].getType() == Type.Wumpus)
			 return 1;
		 else if(rooms[playerX][playerY].getType() == Type.Blood)
			 return 3;
		 else if(rooms[playerX][playerY].getType() == Type.Slime)
			 return 4;
		 else if(rooms[playerX][playerY].getType() == Type.Goop)
			 return 5;
		 else 
			 return 0;
		 
		 
		
		 
	 }


	public void setPlayerPosition(int playerX2, int playerY2) {
		playerX = playerX2;
		playerY = playerY2;
	}
	 
	

	
	 
	 
	 
}


	
