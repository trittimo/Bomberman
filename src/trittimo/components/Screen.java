package trittimo.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import trittimo.components.pieces.Entity;

public class Screen extends JPanel {

	public ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public Screen() {
		this.setPreferredSize(new Dimension(800, 800));
		this.setMinimumSize(new Dimension(800, 800));
		
		// load l0
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Do rendering stuff here
	}
}
