package trittimo.components.pieces;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import trittimo.components.Screen;



public class Bomb extends Entity {
	public static final int SECONDS_TO_BLOW = 5;
	public static final int SECONDS_TO_MILI = 60*1000;
	Timer timer;
	Bomb ths = this;

	public Bomb(Screen screen, int x, int y) {
		super(screen, x, y);
		this.timer = new Timer();

		this.timer.schedule(new TimerTask(){
			@Override
			public void run() {
				Bomb.this.ths.explode();
			}
		}, Bomb.SECONDS_TO_BLOW * Bomb.SECONDS_TO_MILI);

	}

	public void explode(){
		System.out.println("boom");;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(this.x * Screen.GRID_SIZE, this.y * Screen.GRID_SIZE, 50, 50);
	}
}
