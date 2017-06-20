package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameOverScreen extends JFrame {
	
	private Image background = new ImageIcon("./images/failScreenBackground.png").getImage();
	
	public GameOverScreen() {
		setTitle("Game Over");
		setSize(1500, 879);
		setResizable(false);
		setVisible(true);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics graphics) {
		graphics.drawImage(background, 0, 0, this);
	}
}
