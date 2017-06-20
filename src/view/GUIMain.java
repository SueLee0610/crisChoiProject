package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class GUIMain extends JFrame {

	private Stage currentStage;
	private Stage1 stage1;
	
	public GUIMain frame = this;
	public static final int screenWidth = 1200;
	public static final int screenHeight = 900;
	
	public GUIMain() {
		stage1 = new Stage1();
		currentStage = stage1;
		
		System.out.println("System.out.prinln works");
		
		this.setTitle("Disney");
		this.setSize(screenWidth, screenHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		stage1.paint(getGraphics());
		this.setContentPane(stage1);
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
						stage1.moveUp();
						
						//make character go up
						break;
					case KeyEvent.VK_DOWN:
						stage1.moveDown();
						break;
					case KeyEvent.VK_LEFT:
						stage1.moveLeft();
						break;
					case KeyEvent.VK_RIGHT:
						stage1.moveRight();
						break;
					default:
						break;
			}
			repaint();
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
		});
		
		/*
		currentStage.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				//attack enemy & obstacles
				
				e
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
		});
		*/
		
		//figure out if there's buttenlistener or like that
		//make panel bigger than the screen
	}
	
	
	

}
