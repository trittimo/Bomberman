package trittimo.components;

import java.util.ArrayList;

import trittimo.components.pieces.Bomb;
import trittimo.components.pieces.Entity;

public class TickCaller implements Runnable {
	private Screen screen;
	private long last;
	private boolean run;
	
	public static final long TICK_LENGTH = 500;
	
	public TickCaller(Screen s) {
		screen = s;
		run = true;
	}
	
	public void stop() {run = false;}
	
	@Override
	public void run() {
		last = System.currentTimeMillis();
		long sleepFor;
		Entity e;
		while (run) {
			for (int i = 0; i < screen.entities.size(); i++) {
				e = screen.entities.get(i);
				if ((e != null) && (e.tick())) // if true, then delete
					screen.entities.remove(i--);
			}
			screen.repaint();
			last = System.currentTimeMillis();
		}
	}
	
}
