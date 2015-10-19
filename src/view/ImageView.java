package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Direction;
import model.Game;
import model.Room;
import model.Type;

public class ImageView extends JPanel implements Observer {

  private Game game;
  private Image player, tile, blood,goop,slime,slimepit,wumpus;
  private Direction direction;
  private int X, Y;
  private int counts = 0;
  Timer t;
  boolean moving ;
  

  public ImageView(Game game) {
	  this.setBackground(Color.BLACK);
	 // this.setPreferredSize(new Dimension(500,500));
	  this.setSize(600,600);
    this.game = game; // Avoid null pointer when board is first drawn
    moving = false;
    X = game.getPointX()*50;
    Y = game.getPointY()*50;
    try {
    	tile = ImageIO.read(new File("./images/Ground.png"));
      player = ImageIO.read(new File("./images/TheHunter.png"));
      blood = ImageIO.read(new File("./images/Blood.png"));
      goop = ImageIO.read(new File("./images/Goop.png"));
      slime = ImageIO.read(new File("./images/Slime.png"));
      slimepit = ImageIO.read(new File("./images/SlimePit.png"));
      wumpus = ImageIO.read(new File("./images/Wumpus.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    //repaint();
  }

  @Override
  public void update(Observable observable, Object extraParameter) {
    game = (Game) observable;
    direction = (Direction) extraParameter;
   // System.out.println("123");
  
	  X = game.getPointX()*50;
	  Y = game.getPointY()*50;
    drawBoardWithAnimation();
   
  }
  
  
  class  Tlistener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int x = game.getOldPointX()*50;
			int y = game.getOldPointY()*50;
			if (counts<25){
				counts++;
				if (direction==Direction.NORTH)
					Y=(y-(counts*2)+500)%500;
				else if (direction==Direction.SOUTH)
					Y=(y+(counts*2)+500)%500;
				else if (direction==Direction.WEST)
					X=(x-(counts*2)+500)%500;
				else if (direction==Direction.EAST)
					X=(x+(counts*2)+500)%500;
			repaint();
			
			
			}
			else{
				
				counts = 0;
				moving =false;
				game.GamePlayable();
				((Timer)e.getSource()).stop();
			}
		}
		 
		 
	 }
  
  private void drawBoardWithAnimation() { 
    // TODO Set up a timer, add an ActionListener that calls repaint() 25 times
    // in some number of milliseconds  (40ms is good).  Calling repaint() will
    // execute the code in public void paintComponent(Graphics g).  The player
    // should appear to move into the next room, not be transported immediately.
    //
    // Optional: Make it so the player wraps around, something you'll need in the project.
    //
	  if (!moving){
	  Timer t = new Timer(40,new Tlistener());
	  t.start();
	  moving = true;
	  }
	  
	  
	  
	
	  
	
	
	  
	 //repaint(); 
     // temporary location to jump instantly to the next room.
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    // Draw background image 100 times
    /*
    for (int r = 0; r < 500; r += 50)
      for (int c = 0; c < 500; c += 50)
        g2.drawImage(tile, r, c, null);

    System.out.println(X + " " + Y);
    g2.drawImage(player, X, Y, null);
    */
   
    for(int i = 0; i< 10;i++){
    	for (int j=0; j< 10; j++){
    		Room  r= game.getMap().getRooms()[j][i];
    		if (game.getMap().getRooms()[j][i].getVisible()){
    				g2.drawImage(tile, j*50, i*50, null);
    			switch (r.getType()){
    			case Blood:
    				 g2.drawImage(blood, j*50, i*50, null);
    				break;
    			case Slime:
    				g2.drawImage(slime, j*50, i*50, null);
    				break;
    			case Pit:
    				g2.drawImage(slimepit, j*50, i*50, null);
    				break;
    			case Goop:
    				g2.drawImage(goop, j*50, i*50, null);
    				break;
    			case Wumpus:
    				g2.drawImage(wumpus, j*50, i*50, null);
    				break;
				default:
					
					break;
    			}
    			
    		}
    		
    	}
    	
    }
    g2.drawImage(player, X, Y, null);
  }

}