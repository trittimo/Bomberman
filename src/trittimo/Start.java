package trittimo;

import javax.swing.JFrame;

import trittimo.components.Screen;

public class Start {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Bomberman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Screen());
		frame.pack();
		frame.setVisible(true);
	}
}
