package model;

public enum Type {

	Hidden_Room(1),Slime(2),Blood(3), Goop(4), Wumpus(5), Pit(6), Nothing(7);
	
	 int index;
	Type(int index){
		this.index = index;
		
	}
	/*
	public String getString(){
		switch (index){
			//case 1:
			//	return "Hidden Room";
			
			case 2:
				return "Slime";
				
			case 3:
				return "Blood";
				
			case 4:
				return "Goop";
				
			case 5:
				return "Wumpus";
				
			case 6:
				return "Pit";
				
			case 7:
				return "Nothing";
		}
		
		return "Error ";
		
		
	}
	*/
	
	public String getChar(){
		switch (index){
		
		case 2:
			return "S";
			
		case 3:
			return "B";
			
		case 4:
			return "G";
			
		case 5:
			return "W";
			
		case 6:
			return "P";
			
		}
		return " ";
		
	}
	
	
	
}
