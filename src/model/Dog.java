package model;

import java.awt.Rectangle;

public class Dog extends Enemy{

	int dogWidth = 251;
	int dogHeight = 165;
	
	public Dog(int startX, int startY) {
		super(startX, startY, "./images/dog.png");
		hp = 10;
		attackPower = 7;
	}
	
    public Rectangle getBounds(){
        return new Rectangle(xPos,yPos, dogWidth, dogHeight);
    }
       
}
