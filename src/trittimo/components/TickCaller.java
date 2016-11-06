package trittimo.components;

import java.util.ArrayList;

import trittimo.components.pieces.Bomb;

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
		while (run) {
			for (int i = 0; i < screen.entities.size(); i++)
				if (screen.entities.get(i).tick()) // if true, then delete
					screen.entities.remove(i--);
			try {
				Thread.sleep((last + TICK_LENGTH) - System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
