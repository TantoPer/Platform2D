package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;

import TileMap.Background; //importo classe Background dal package TileMap

public class MenuState extends GameState{
	
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {
			"Start",  //RICORDA LE VIRGOLE^^
			"Help",
			"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background("/Background/backgrds.jpg", 1); //va scalato a 1
			bg.setVector(-0.1, 0); // velocità con cui si muove il background
			
			titleColor = new Color(128, 0, 0); // blue
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);
			
			font = new Font("Arial", Font.PLAIN, 12);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void init() {
		
		
		
	}
	
	public void update() {
		bg.update();
	}
	
	public void draw(Graphics2D g) {
			
		//draw background
		bg.draw(g);
		
		//draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Spiff's Tale", 80, 70); // posizione titolo nel menu
		
		//draw menu options
		g.setFont(font);
		for(int i=0; i<options.length; i++) { //ciclo per le opzioni del menu
			if(i== currentChoice) {
				g.setColor(Color.BLACK);
			}else {
				g.setColor(Color.GREEN);
			}
			g.drawString(options[i], 145, 140 + i * 15); // li distanzia di 15 pixel
		}
		
	}
	
	private void select() {  // seleziona i menu
		if(currentChoice == 0) {
			//start
		}
		if(currentChoice == 1) {
			//help
		}
		if(currentChoice == 2) {
			System.exit(0);
		}
	}
	
	public void keyPressed(int k) {  //inseriamo i tasti da poter utilizzare nel menu
		if(k == KeyEvent.VK_ENTER) {
			select();
		}
		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) { // siamo andati fuori campo
				currentChoice = options.length -1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) { // fori campo di sopra
				currentChoice = 0;
			}
		}
	}
	
	public void keyReleased(int k) {
		
		
		
	}

}
