package trittimo.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import trittimo.components.pieces.Bomb;
import trittimo.components.pieces.DestructableWall;
import trittimo.components.pieces.Door;
import trittimo.components.pieces.Enemy;
import trittimo.components.pieces.Entity;
import trittimo.components.pieces.Player;
import trittimo.components.pieces.Wall;

public class Screen extends JPanel {

	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public static final int GRID_SIZE = 50;
	
	
	public Screen() {
		this.setPreferredSize(new Dimension(800, 800));
		this.setMinimumSize(new Dimension(800, 800));
		
		// load l0
		try {
			loadLevel(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadLevel(int level) throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("resource/level" + level));
			String line;
			for (int y = 0; y < 16; y++) {
				line = reader.readLine();
				for (int x = 0; x < 16; x++) {
					switch(line.charAt(x)) {
					case 'W': // wall
						entities.add(new Wall(this, x, y));
						break;
					case 'D': // destructable wall
						entities.add(new DestructableWall(this, x, y));
						break;
					case 'E': // enemy
						entities.add(new Enemy(this, x, y));
						break;
					case 'P': // player
						entities.add(new Player(this));
						break;
					case 'B': // bomb
						entities.add(new Bomb(this, x, y));
						break;
					case 'Z': // door
						entities.add(new Door(this, x, y));
						break;
					default:
						// do nothing
						break;
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Do rendering stuff here
	}
}
