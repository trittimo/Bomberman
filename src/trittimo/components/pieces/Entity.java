package trittimo.components.pieces;

import javax.swing.JComponent;

import trittimo.components.Screen;

public abstract class Entity extends JComponent {
	public int x;
	public int y;
	
	public Screen screen;
	
	public Entity(Screen screen) {
		this.screen = screen;
	}
	
	public boolean attemptMove(int x, int y) {
		
		return false;
	}
}
