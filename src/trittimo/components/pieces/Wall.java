package trittimo.components.pieces;

import java.awt.Color;
import java.awt.Graphics;

import trittimo.components.Screen;

public class Wall extends Entity {

	public Wall(Screen screen) {
		super(screen);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(this.x, this.y, 50, 50);
		g.setColor(Color.CYAN);
	}

}
