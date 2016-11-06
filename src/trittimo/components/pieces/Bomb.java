package trittimo.components.pieces;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import trittimo.components.Screen;

public class Bomb extends Entity {
	public static final int EXPLODE_AFTER_MS = 5000;
	
	private long timeCreated;

	public Bomb(Screen screen, int x, int y) {
		super(screen, x, y);
		this.timeCreated = System.currentTimeMillis();
	}

	/**
	 * check if need to dies
	 */
	public boolean tick() {
		if (System.currentTimeMillis() > (timeCreated + EXPLODE_AFTER_MS)) {
			this.explode();
			return true;
		}
		return false;
	}
	
	public void explode(){
		System.out.println("boom");
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(this.x * Screen.GRID_SIZE, this.y * Screen.GRID_SIZE, 50, 50);
	}
}
