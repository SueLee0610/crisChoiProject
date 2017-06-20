package model;

import javax.swing.ImageIcon;

public class Warrior extends Character{
	
	private static Warrior instance = null;
	
	public synchronized static Warrior getInstance() {
		if (instance == null) {
			instance = new Warrior();
		}
		return instance;
	}
	
	private Warrior(){
		super();
		
		characterClass = "warrior";
		characterRight = new ImageIcon("./images/" + characterClass + "_right.png");
    	characterJump = new ImageIcon("./images/" + characterClass + "_right.png");
    	characterLeft = new ImageIcon("./images/" + characterClass + "_left.png");
    	imgLeft = characterRight.getImage(); //ĳ���� �̹��� �ҷ���

		
		hp = 150;
		ammo = 15;
		attackPower = 15;
	}

}
