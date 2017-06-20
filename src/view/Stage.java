package view;

import javax.swing.JPanel;

public abstract class Stage extends JPanel {
	public abstract void startMusic();
	public abstract void pauseMusic();
	
	public abstract void moveUp ();
	public abstract void moveDown();
	public abstract void moveLeft();
	public abstract void moveRight();

	public abstract void mapSwitching();
	
	public abstract void setMapX(int x);
	public abstract void setMapY(int y);
	public abstract int getMapX();
	public abstract int getMapY();
	
	public enum Direction {
		LEFT,
		RIGHT;
		//Add UP and DOWN here if we want to change the appearance of the character when it goes up and down
	}
}
