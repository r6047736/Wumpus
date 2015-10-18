package view;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

class GameGUI extends JFrame{
	public static void main(String[] args) {
		(new GameGUI()).setVisible(true);
	}

	private Game game;
	 private JTabbedPane tablPanels;
	 private ImageView imgView;
	 
	public GameGUI() {
		this.setSize(700, 700);
		// Other normal GUI stuff
		
		game = new Game();
	
	}
	
	
	

}