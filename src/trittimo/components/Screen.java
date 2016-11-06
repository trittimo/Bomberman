package trittimo.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import trittimo.components.pieces.Entity;

public class Screen extends JPanel {

	public Entity[][] entities = new Entity[16][16];
	
	public Screen() {
		this.setPreferredSize(new Dimension(800, 800));
		this.setMinimumSize(new Dimension(800, 800));
		
		
		// load level 0
		
	}
	
	public void updateAll() {
		for (int x = 0; x < entities.length; x++) {
			for (int y = 0; y < entities[0].length; y++) {
				if (entities[x][y] != null) {
					entities[x][y].update(this);
				}
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Do rendering stuff here
	}
}
