package viewnew;

import java.awt.Rectangle;

public class Dog extends Enemy{

	int dogWidth = 251;
	int dogHeight = 165;
	
	public Dog(int startX, int startY, String location) {
		super(startX, startY, location);
		hp = 10;
	}
	
    public Rectangle getBounds(){
        return new Rectangle(xPos,yPos, dogWidth, dogHeight);
    }
       
}
