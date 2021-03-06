package trittimo.components.pieces;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import trittimo.components.Screen;

public class Player extends Entity {
	
	private Image i;
	
	public Player(Screen screen, int x, int y) {
		super(screen, x, y);
        try {
			i = ImageIO.read(new File("src/resource/chad.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		Point p = this.getLocation();
		//System.out.println(p);
		g.drawImage(this.i, p.x * Screen.GRID_SIZE, p.y * Screen.GRID_SIZE, this.screen);
	}
}
