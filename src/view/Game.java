package view;


/**
 * This Observable will notify any observers whenever 
 * someone sends this Game a movePlayer message.
 * 
 * @author Rick Mercer
 */
import java.awt.Point;


import model.Direction;
import model.Map;

public class Game {
  Map rooms = new Map();
  int currentRow, currentCol, oldRow, oldCol;
  public static int TILE_SIZE = 50;
  public Game(int row, int column) {
    currentRow = row;
    currentCol = column;
    oldRow = row;
    oldCol = column;
    
    rooms= new Map();
    rooms.generateRandomPitsAndWumpus();
    rooms.gemerateSlimeandBloods();
    
  } 

  public void movePlayer(Direction dir) {
    oldRow = currentRow;
    oldCol = currentCol;
    if (dir == Direction.NORTH)
      currentRow--;
    if (dir == Direction.EAST)
      currentCol++;
    if (dir == Direction.SOUTH)
      currentRow++;
    if (dir == Direction.WEST)
      currentCol--;
   // setChanged();
   // notifyObservers(dir);
  }

  public int getCurrentRow() {
    return currentRow;
  }

  public int getCurrentColumn() {
    return currentCol;
  }

  public Point getOldPoint() {
    return new Point(oldCol * TILE_SIZE, oldRow * TILE_SIZE);
  }

  public Point getPoint() {
    return new Point(currentCol * TILE_SIZE, currentRow * TILE_SIZE);
  }
}