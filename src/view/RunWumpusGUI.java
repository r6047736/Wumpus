package view;

/**
 * Start an event-driven GUI with a player on a board in the upper left corner.
 * This JFrame has a key listener that sends movePlayer message to the game
 * when the user presses one of the four arrow keys. At that time, the Game,
 * which is also an Observable, sends a notifyObserver message to its one
 * Observer, which is also a JPanel that repaints the game board.
 * 
 * @author Rick Mercer
 */
import java.awt.BorderLayout;

import javax.swing.JFrame;



/*
 * This is main GUI for playing, all buttons set in here, read user actions.
 * Put the imageView and other things here. 
 * 
 * 
 */


public class RunWumpusGUI extends JFrame {

  public static void main(String[] args) {
    RunWumpusGUI window = new RunWumpusGUI();
    window.setVisible(true);
  }

  private ImageView imagePanel;
  private Game game;

  public RunWumpusGUI() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 520);
    setLocation(100, 30);
   // this.addKeyListener(new ArrowKeyListener());
    game = new Game(0, 0);
    imagePanel = new ImageView(game);
    add(imagePanel, BorderLayout.EAST);
    game.addObserver(imagePanel);
    this.setFocusable(true);
  }
  
  
/*
  private class ArrowKeyListener implements KeyListener {

    @Override
    public void keyPressed(KeyEvent ke) {

      if (ke.getKeyCode() == KeyEvent.VK_UP)
        game.movePlayer(Direction.NORTH);

      if (ke.getKeyCode() == KeyEvent.VK_DOWN)
        game.movePlayer(Direction.SOUTH);

      if (ke.getKeyCode() == KeyEvent.VK_LEFT)
        game.movePlayer(Direction.WEST);

      if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
        game.movePlayer(Direction.EAST);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
 
  }
  */
}
