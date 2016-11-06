package trittimo.components.pieces;

import java.awt.Graphics;

import javax.swing.JComponent;

import trittimo.components.Screen;

public abstract class Entity {
	public int x;
	public int y;
	
	public Screen screen;
	
	public Entity(Screen s, int xp, int yp) {
		this.screen = s;
		this.x = xp;
		this.y = yp;
	}
	
	public Entity(Screen screen) {
		this.screen = screen;
	}
	
	public boolean attemptMove(int ax, int ay) {
		//System.out.println("Attempting move to: (" + ax + ", " + ay + ")");
		//check if occupied
		for (Entity e: screen.entities) {
			if ((e.x == ax) && (e.y == ay))
				if ((e instanceof Enemy) || (e instanceof DestructableWall) || (e instanceof Wall))
					return false;
		}
		this.x = ax;
		this.y = ay;
		return true;
	}
	
	/**
	 * Update tick
	 * @return True if we need to remove it
	 */
	public boolean tick() {
		//by default do nothing
		return false;
	}
	
	public abstract void paintComponent(Graphics g);
}
