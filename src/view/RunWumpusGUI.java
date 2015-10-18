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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;



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
    setSize(700, 550);
    setLocation(100, 30);
    
    setLayout(null);
    game = new Game(0,0);
   
    
    TabPanels = new JTabbedPane();
    imageview = new ImageView(game);
    textview = new TextView();
    
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
    
    
    
    
    //-------- right Part
    
    TabPanels.add("Grafical view", imageview);
    TabPanels.add("Text view", textview);
    TabPanels.setSize(500, 500);
    TabPanels.setLocation(200,0);
    add(TabPanels);
    
    //Add observer
    game.rooms.addObserver(imageview);
    game.rooms.addObserver(textview);
   
    
    
    
    
   // this.addKeyListener(new ArrowKeyListener());
    
    
    
    /*
    game = new Game(0, 0);
    imagePanel = new ImageView(game);
    add(imagePanel, BorderLayout.EAST);
    game.addObserver(imagePanel);
    this.setFocusable(true);
    */
  }
  
  

}
