package viewnew;

import javax.swing.ImageIcon;

public class Gunner extends Character{
	
	private static Gunner instance = null;
	
	public synchronized static Gunner getInstance() {
		if (instance == null) {
			instance = new Gunner();
		}
		return instance;
	}
	
	private Gunner(){
		super();
		
		characterClass = "gunner";
		characterRight = new ImageIcon("./images/" + characterClass + "_right.png");
    	characterJump = new ImageIcon("./images/" + characterClass + "_right.png");
    	characterLeft = new ImageIcon("./images/" + characterClass + "_left.png");
    	imgLeft = characterRight.getImage(); //캐릭터 이미지 불러옴

    	
		hp = 200;
		ammo = 10;
		attackPower = 12;
	}
}
