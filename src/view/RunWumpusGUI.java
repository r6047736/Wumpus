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
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import model.Direction;
import model.Game;
import model.Type;



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

  private JTabbedPane TabPanels;
  private ImageView imageview;
  private TextView textview;
  private  JLabel winlabel;
  private JButton shootN;
  private JButton shootS;
  private JButton shootW;
  private JButton shootE;
  
  private JButton moveN;
  private JButton moveS;
  private JButton moveW;
  private JButton moveE;
  
  private Game game;

  public RunWumpusGUI() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(750, 600);
    //setLocation(100, 30);
    
    setLayout(null);
    game = new Game(0,0);
    
    int x =  (int) (Math.random() * 9) ;
    int y =  (int) (Math.random() * 9) ;
    while (!game.getMap().getRooms()[x][y].getType().getChar().equals(" ")){
    	x =  (int) (Math.random() * 9) ;
    	y =  (int) (Math.random() * 9) ;
    }
    game.getMap().insertHunter(x, y);
   
  
   // game.notifyObservers();
   
    
    TabPanels = new JTabbedPane();
    imageview = new ImageView(game);
    textview = new TextView(game);
    
    //----------JButton part
    
    JLabel shootlb = new JLabel("shoot");
    shootlb.setLocation(80,20);
    shootlb.setSize(100,20);
    add(shootlb);
    
    JLabel movelb = new JLabel("move");
    movelb.setLocation(80,150);
    movelb.setSize(100,20);
    add(movelb);
    
    shootN = new JButton("^");
    shootS = new JButton("S");
    shootE = new JButton(">");
    shootW = new JButton("<");
    moveN = new JButton("^");
    moveS = new JButton("S");
    moveE = new JButton(">");
    moveW = new JButton("<");
    
    shootN.setLocation(80,50);
    shootN.setSize(50,50);
    add(shootN);
    
    shootS.setLocation(80,100);
    shootS.setSize(50,50);
    add(shootS);
    
    shootW.setLocation(30,100);
    shootW.setSize(50,50);
    add(shootW);
    
    shootE.setLocation(130,100);
    shootE.setSize(50,50);
    add(shootE);
    
    
    moveN.setLocation(80,180);
    moveN.setSize(50,50);
    add(moveN);
    
    moveS.setLocation(80,230);
    moveS.setSize(50,50);
    add(moveS);
    
    moveW.setLocation(30,230);
    moveW.setSize(50,50);
    add(moveW);
    
    moveE.setLocation(130,230);
    moveE.setSize(50,50);
    add(moveE);
    /*
    winlabel = new JLabel("");
    winlabel.setSize(200, 50);
    winlabel.setLocation(20,200);
    */
    //-------- right Part
    
    TabPanels.add("Graphcal view", imageview);
    TabPanels.add("Text view", textview);
    TabPanels.setSize(520, 550);
    TabPanels.setLocation(200,0);
    add(TabPanels);
    
    
    
    //Add observer
    game.addObserver(imageview);
    game.addObserver(textview);
   
    moveN.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			game.movePlayer(Direction.NORTH);
		}
    });
    
    moveS.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			game.movePlayer(Direction.SOUTH);
		}
    });
    
    moveW.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			game.movePlayer(Direction.WEST);
		}
    });
    moveE.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			game.movePlayer(Direction.EAST);
		}
    });
    
    //shootWumpus
    
    shootN.addActionListener(new ActionListener(){
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			// TODO Auto-generated method stub
  			game.shootWumpus(Direction.NORTH);
  		}
      });
    shootS.addActionListener(new ActionListener(){
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			// TODO Auto-generated method stub
  			game.shootWumpus(Direction.SOUTH);
  		}
      });
    shootE.addActionListener(new ActionListener(){
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			// TODO Auto-generated method stub
  			game.shootWumpus(Direction.EAST);
  		}
      });
    shootW.addActionListener(new ActionListener(){
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			// TODO Auto-generated method stub
  			game.shootWumpus(Direction.WEST);
  		}
      });
    
   
  }
  
  

}
