package model;

import java.awt.*;

import javax.swing.ImageIcon;
 
public class Bird extends Enemy{

	int birdWidth = 145;
	int birdHeight = 171;
	
	public Bird(int startX, int startY) {
		super(startX, startY, "./images/bird.png");
		hp = 20;
		attackPower = 5;
	}
	
    public Rectangle getBounds(){
        return new Rectangle(xPos,yPos, birdWidth, birdHeight);
    }
       
}