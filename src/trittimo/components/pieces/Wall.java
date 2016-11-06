package trittimo.components.pieces;

import java.awt.Color;
import java.awt.Graphics;

import trittimo.components.Screen;

public class Wall extends Entity {

	public Wall(Screen screen, int x, int y) {
		super(screen, x, y);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(this.x * Screen.GRID_SIZE, this.y * Screen.GRID_SIZE, Screen.GRID_SIZE, Screen.GRID_SIZE);
		g.setColor(Color.BLACK);
		g.drawRect(this.x * Screen.GRID_SIZE, this.y * Screen.GRID_SIZE, Screen.GRID_SIZE, Screen.GRID_SIZE);
	}

}
