package model;

import java.awt.Rectangle;

public class Turtle extends Enemy{

	int turtleWidth = 251;
	int turtleHeight = 165;
	
	public Turtle(int startX, int startY) {
		super(startX, startY, "./images/turtle.png");
		hp = 10;
	}
	
    public Rectangle getBounds(){
        return new Rectangle(xPos,yPos, turtleWidth, turtleHeight);
    }
       
}