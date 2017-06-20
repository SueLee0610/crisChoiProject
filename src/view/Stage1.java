package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Stage1 extends Stage {
	//TODO: change this later.
	private static final int mapWidth = GUIMain.screenWidth;
	private static final int mapHeight = GUIMain.screenHeight; 
	public static final int screenWidth = mapWidth;
	public static final int screenHeight = mapHeight;
	private int speed = 15;
	
	private final int groundHeight = 600;
	
	private Image stage = new ImageIcon(("./images/Forest.png")).getImage();
	Image scaledMap = stage.getScaledInstance(3000, 1000 ,Image.SCALE_FAST);
	
	private String characterClass;
	private ImageIcon character;
	private ImageIcon stage1Image;
	private ImageIcon dwarf;
	private ImageIcon animal;
	public JLabel characterIcon;
	public JLabel dwarfIcon;
	public JLabel animalIcon;
	
	//private Image warrior = new ImageIcon(("./images/warrior.png")).getImage();
	
	public Stage1() {
		//Stage layout
		this.setLayout(new GroupLayout(this)); //TODO: should probably be changed
		this.setSize(mapWidth, mapHeight);
		this.setPreferredSize(new Dimension(screenHeight, 5000));
		
		
		//--------- Characters and items ---------/
		characterClass = "warrior";
		
		character = new ImageIcon("./images/" + characterClass + "_right"+ ".png");
		dwarf = new ImageIcon("./images/dwarf.png");
		animal = new ImageIcon("./images/animal.png");
		characterIcon  = new JLabel(character);
		dwarfIcon = new JLabel(dwarf);
		animalIcon = new JLabel(animal);
		ImageIcon charLeft = new ImageIcon("./images/" + characterClass + "_right"+ ".png");
		ImageIcon charRight = new ImageIcon("./images/" + characterClass + "_right"+ ".png");
		
		//Icon bounds
		characterIcon.setBounds(0, 0, 200, 250); //TODO: set the correct size
		dwarfIcon.setBounds(0, 0, 200, 250);
		animalIcon.setBounds(0, 0, 200, 250);
		
		//Location of characters and items in the world
		characterIcon.setLocation(300 - characterIcon.getWidth(), groundHeight - characterIcon.getHeight());
		dwarfIcon.setLocation(700 - animalIcon.getWidth(), groundHeight - dwarfIcon.getHeight());
		animalIcon.setLocation(1000 - animalIcon.getWidth(), groundHeight - animalIcon.getHeight());
	
		//Add icons to JPanel...
		this.add(characterIcon);
		this.add(dwarfIcon);
		this.add(animalIcon);
		//... And make them visible
		characterIcon.setVisible(true);
		dwarfIcon.setVisible(true);
		animalIcon.setVisible(true);
	}
	
	private void flipCharacter(Direction direction) {
		switch (direction) {
			case LEFT:
				//TODO: Flip the character to the left
				break;
			case RIGHT:
				//TODO: Flip right
				break;
			default:
				break;
		}
		
	}
	
	@Override
	public void startMusic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pauseMusic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp() {
		characterIcon.setLocation(characterIcon.getX(), characterIcon.getY() - speed);
		
	}

	@Override
	public void moveDown() {
		characterIcon.setLocation(characterIcon.getX(), characterIcon.getY() + speed);
	}

	@Override
	public void moveLeft() {
		characterIcon.setLocation(characterIcon.getX() - speed, characterIcon.getY());
	}

	@Override
	public void moveRight() {
		characterIcon.setLocation(characterIcon.getX() + speed, characterIcon.getY());
	}

	@Override
	public void mapSwitching() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMapX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMapY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMapX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMapY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 500, 500);
		g.drawImage(scaledMap, 0, 0, this);
		/*
		int componentWidth = getWidth();
		int componentHeight = getHeight();
		int imageWidth = stage.getWidth(this);
		int imageHeight = stage.getHeight(this);
		if((imageWidth > 0) && (imageHeight > 0)) {
			g.drawImage(stage,
					(componentWidth - imageWidth)/2,
		            (componentHeight - imageHeight)/2, this);
		    }
		imageWidth = warrior.getWidth(this);
		imageHeight = warrior.getHeight(this);
		if ((imageWidth > 0) && (imageHeight > 0)) {
			int frameNumber = 1;
			g.drawImage(warrior,
					((frameNumber*5) % 
						(imageWidth + componentWidth)) - imageWidth,
		                    (componentHeight - imageHeight)/2,
		                    this);
		    }
		 */
	}
	
}
