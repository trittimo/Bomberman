package trittimo.components.pieces;

import java.awt.Color;
import java.awt.Graphics;

import trittimo.components.Screen;

public class DestructableWall extends Entity {

	public DestructableWall(Screen screen, int x, int y) {
		super(screen, x, y);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(this.x * Screen.GRID_SIZE, this.y * Screen.GRID_SIZE, Screen.GRID_SIZE, Screen.GRID_SIZE);
		g.setColor(Color.BLACK);
		g.drawRect(this.x * Screen.GRID_SIZE, this.y * Screen.GRID_SIZE, Screen.GRID_SIZE, Screen.GRID_SIZE);
	}

}
