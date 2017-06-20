package viewnew;

import javax.swing.ImageIcon;

public class Magician extends Character{
	
	private static Magician instance = null;
	
	public synchronized static Magician getInstance() {
		if (instance == null) {
			instance = new Magician();
		}
		return instance;
	}
	
	private Magician(){
		super();
		
		characterClass = "magician";
		characterRight = new ImageIcon("./images/" + characterClass + "_right.png");
    	characterJump = new ImageIcon("./images/" + characterClass + "_right.png");
    	characterLeft = new ImageIcon("./images/" + characterClass + "_left.png");
    	imgLeft = characterRight.getImage(); //캐릭터 이미지 불러옴

		
		hp = 150;
		ammo = 20;
		attackPower = 11;
	}
}
