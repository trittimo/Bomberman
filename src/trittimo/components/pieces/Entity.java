package trittimo.components.pieces;

import trittimo.components.Screen;

public abstract class Entity {
	public int x;
	public int y;
	
	public abstract void update(Screen screen);
}
