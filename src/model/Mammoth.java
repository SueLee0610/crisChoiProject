package model;

import java.awt.Rectangle;

public class Mammoth extends Enemy{

	int mammothWidth = 216;
	int mammothHeight = 190;
	
	public Mammoth(int startX, int startY) {
		super(startX, startY, "./images/mammoth.png");
		hp = 30;
		attackPower = 18;
	}
	
    public Rectangle getBounds(){
        return new Rectangle(xPos,yPos, mammothWidth, mammothHeight);
    }
       
}
