package trittimo.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	public Player player;
	
	
	public Screen() {
		this.setPreferredSize(new Dimension(800, 800));
		this.setMinimumSize(new Dimension(800, 800));
		
		// load l0
		try {
			this.player = loadLevel(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//add listener
        
		
		this.repaint();
	}
	
	public void addEntity(Entity e) {
        this.entities.add(e);
	}
	
	public Player loadLevel(int level) throws IOException {
		Player player = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/resource/level" + level));
			String line;
			for (int y = 0; y < 16; y++) {
				line = reader.readLine();
				for (int x = 0; x < 16; x++) {
					switch(line.charAt(x)) {
					case 'W': // wall
						addEntity(new Wall(this, x, y));
						break;
					case 'D': // destructable wall
						addEntity(new DestructableWall(this, x, y));
						break;
					case 'E': // enemy
						addEntity(new Enemy(this, x, y));
						break;
					case 'P': // player
						player = new Player(this, x, y);
						addEntity(player);
						break;
					case 'Z': // door
						addEntity(new Door(this, x, y));
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
		
		return player;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Entity e : this.entities) {
			e.paintComponent(g);
		}
		// Do rendering stuff here
	}
}
