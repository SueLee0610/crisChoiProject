package viewnew;

import java.awt.Rectangle;

public class Mammoth extends Enemy{

	int mammothWidth = 216;
	int mammothHeight = 190;
	
	public Mammoth(int startX, int startY, String location) {
		super(startX, startY, location);
		hp = 30;
	}
	
    public Rectangle getBounds(){
        return new Rectangle(xPos,yPos, mammothWidth, mammothHeight);
    }
       
}
