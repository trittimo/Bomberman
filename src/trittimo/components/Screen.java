package trittimo.components;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Screen extends JPanel {

	public Screen() {
		this.setPreferredSize(new Dimension(800, 800));
		this.setMinimumSize(new Dimension(800, 800));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Do rendering stuff here
	}
}
