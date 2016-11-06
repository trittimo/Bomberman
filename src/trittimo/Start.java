package trittimo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import trittimo.components.Screen;
import trittimo.components.pieces.Bomb;

public class Start {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Bomberman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Screen screen = new Screen();

		frame.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_W:
					screen.player.attemptMove(screen.player.x, screen.player.y + 1);
					break;
				case KeyEvent.VK_A:
					screen.player.attemptMove(screen.player.x - 1, screen.player.y);
					break;
				case KeyEvent.VK_S:
					screen.player.attemptMove(screen.player.x, screen.player.y - 1);
					break;
				case KeyEvent.VK_D:
					screen.player.attemptMove(screen.player.x + 1, screen.player.y);
					break;
				case KeyEvent.VK_SPACE:
					screen.addEntity(new Bomb(screen, screen.player.x, screen.player.y));
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});

		frame.add(new Screen());
		frame.pack();
		frame.setVisible(true);
	}
}
