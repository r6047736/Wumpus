package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	  //0 is wumpus&pit
	  //1 is wumpus in center
	  //2 is wumpus top left, with pit below and to right
	@Test
	public void testToStringPreset1() {
		Game first = new Game(0,0,1);
		//player can only see self square
		assertEquals(				  "[O][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n",
									first.toString());
	
	first.movePlayer(Direction.EAST);
	assertEquals(				  "[ ][O][X][X][X][X][X][X][X][X]\n"
								+ "[X][X][X][X][X][X][X][X][X][X]\n"
								+ "[X][X][X][X][X][X][X][X][X][X]\n"
								+ "[X][X][X][X][X][X][X][X][X][X]\n"
								+ "[X][X][X][X][X][X][X][X][X][X]\n"
								+ "[X][X][X][X][X][X][X][X][X][X]\n"
								+ "[X][X][X][X][X][X][X][X][X][X]\n"
								+ "[X][X][X][X][X][X][X][X][X][X]\n"
								+ "[X][X][X][X][X][X][X][X][X][X]\n"
								+ "[X][X][X][X][X][X][X][X][X][X]\n",
								first.toString());	
	
	}
	
	@Test
	public void testToStringPreset2() {
		Game first = new Game(4,3,1);
		assertEquals(				  "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][O][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n"
									+ "[X][X][X][X][X][X][X][X][X][X]\n",
									first.toString());
		first.movePlayer(Direction.SOUTH);
		assertEquals(				  "[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]\n"
									+ "[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]\n"
									+ "[ ][ ][ ][ ][B][ ][ ][ ][ ][ ]\n"
									+ "[ ][ ][ ][B][B][B][ ][ ][ ][ ]\n"
									+ "[ ][ ][B][B][O][B][B][ ][ ][ ]\n"
									+ "[ ][ ][ ][B][B][B][ ][ ][ ][ ]\n"
									+ "[ ][ ][ ][ ][B][ ][ ][ ][ ][ ]\n"
									+ "[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]\n"
									+ "[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]\n"
									+ "[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]\n",
									first.toString());
		
	}
	
	@Test
	public void testToString3AndDieWithCommand() {
		Game first = new Game(2,3,0);
		first.movePlayer(Direction.NORTH);
		assertEquals(				      "[P][S][ ][ ][ ][ ][ ][ ][ ][S]\n"
										+ "[S][P][S][ ][ ][ ][ ][ ][ ][ ]\n"
										+ "[ ][S][O][S][B][ ][ ][ ][ ][ ]\n"
										+ "[ ][ ][S][P][G][B][ ][ ][ ][ ]\n"
										+ "[ ][ ][B][G][W][G][B][ ][ ][ ]\n"
										+ "[ ][ ][ ][B][G][P][S][ ][ ][ ]\n"
										+ "[ ][ ][ ][ ][B][S][P][S][ ][ ]\n"
										+ "[ ][ ][ ][ ][ ][ ][S][P][S][ ]\n"
										+ "[ ][ ][ ][ ][ ][ ][ ][S][P][S]\n"
										+ "[S][ ][ ][ ][ ][ ][ ][ ][S][P]\n",
										first.toString());
		first.movePlayer(Direction.NORTH);
		assertEquals(				      "[P][S][ ][ ][ ][ ][ ][ ][ ][S]\n"
				+ "[S][P][S][ ][ ][ ][ ][ ][ ][ ]\n"
				+ "[ ][S][O][S][B][ ][ ][ ][ ][ ]\n"
				+ "[ ][ ][S][P][G][B][ ][ ][ ][ ]\n"
				+ "[ ][ ][B][G][W][G][B][ ][ ][ ]\n"
				+ "[ ][ ][ ][B][G][P][S][ ][ ][ ]\n"
				+ "[ ][ ][ ][ ][B][S][P][S][ ][ ]\n"
				+ "[ ][ ][ ][ ][ ][ ][S][P][S][ ]\n"
				+ "[ ][ ][ ][ ][ ][ ][ ][S][P][S]\n"
				+ "[S][ ][ ][ ][ ][ ][ ][ ][S][P]\n",
				first.toString());
		
	}
	
	@Test
	public void testWalkingOverEverySurfacePlayable() {
		Game first = new Game(2,4,0);
		first.movePlayer(Direction.EAST);
		first.movePlayer(Direction.NORTH);
		first.movePlayer(Direction.WEST);
		first.movePlayer(Direction.NORTH);
		first.movePlayer(Direction.NORTH);
		first.movePlayer(Direction.NORTH);
		assertEquals("You step in goop. Danger surrounds you!", first.getStatus());
	}
		
}
