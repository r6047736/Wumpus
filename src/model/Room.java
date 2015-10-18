package model;
 //Kenneth Allison made a change here
//and put a comment at the start of the file
public class Room {

	Type type;
	boolean isVisible;
	boolean isOccupied;
	
	public Room(Type t){
		this.type = t;
		isVisible = false;
		isOccupied = false;
		
	}
	
	public void enter(){
		this.isVisible = true;
		this.isOccupied =true;
		
	}
	public void exit(){
		this.isOccupied = false;
		
	}
	
	public Type getType(){
		return type;
	}

	public void setType(Type fillHelper) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	public void changeType(Type newType){
		if (this.type == Type.Nothing){
			this.type = newType;
			
		}
		else if (this.type == Type.Slime && newType == Type.Blood){
			this.type = Type.Goop;
			
		}
		else if (this.type == Type.Blood && newType == Type.Slime){
			this.type = Type.Goop;
			
		}
		
		else{
			System.out.println("Speical case = "+ this.type +" vs "+newType);
			
		}
		
	}
	
	
}
