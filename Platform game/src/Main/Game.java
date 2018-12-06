package Main;

import javax.swing.JFrame;

public class Game {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Game"); //game name here
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //make the window close with exit
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		
	}

}

