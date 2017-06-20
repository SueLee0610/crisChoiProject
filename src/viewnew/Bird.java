package viewnew;

import java.awt.*;

import javax.swing.ImageIcon;
 
public class Bird extends Enemy{

	int birdWidth = 145;
	int birdHeight = 171;
	
	public Bird(int startX, int startY, String location) {
		super(startX, startY, location);
		hp = 20;
	}
	
    public Rectangle getBounds(){
        return new Rectangle(xPos,yPos, birdWidth, birdHeight);
    }
       
}