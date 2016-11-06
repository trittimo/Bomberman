package trittimo.components.pieces;

import javax.swing.JComponent;

import trittimo.components.Screen;

public abstract class Entity extends JComponent {
	public int x;
	public int y;
	
	public Screen screen;
	
	public Entity(Screen s, int xp, int yp) {
		this.screen = s;
		this.x = xp;
		this.y = yp;
		this.setLocation(xp * Screen.GRID_SIZE, yp * Screen.GRID_SIZE);
	}
	
	public Entity(Screen screen) {
		this.screen = screen;
	}
	
	public boolean attemptMove(int ax, int ay) {
		//check if occupied
		for (Entity e: screen.entities) {
			if ((e.x == ax) && (e.y == ay))
				if ((e instanceof Enemy) || (e instanceof DestructableWall) || (e instanceof Wall))
					return false;
		}
		this.x = ax;
		this.y = ay;
		this.setLocation(x * Screen.GRID_SIZE, y * Screen.GRID_SIZE);
		return true;
	}
}
