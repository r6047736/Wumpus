package view;

import java.util.Random;

public class Game {
    private Random r;
    public Game(Random r) {
        this.r = r;
    }

    public int getNextBoardChar() {
        return 'a' + r.nextInt(26);
    }

}

public class GameGUI extends JFrame{
	public static void main(String[] args) {
		(new GameGUI(new Random())).setVisible(true);
	}
	private JLabel theChar;
	private Game game;
	public GameGUI() {
		this.setSize(500, 500);
		// Other normal GUI stuff
		this.theChar = new JLabel();
		this.add(theChar);
		game = new Game();
		Timer t = new Timer(500, new ActionListener() {
			public void ActionPerformed(ActionEvent e) {
				theChar.setText(game.getNextBoardChar() + "");
			}
		});
		t.start();
	}

}