/*package model;

import java.util.LinkedList;
import java.util.Random;

public class C_P_Warrior extends C_Player {
	
	Random rand;
	boolean gethurt;
	
	private static C_P_Warrior instance = null;
	
	private C_P_Warrior() {
		this.hp=100;
		this.mp=50;
		this.existRange=10;
		this.item = new LinkedList<Item>();
	
		this.speed=15;
	}
	
	public synchronized static C_P_Warrior getInstance() {
	      if (instance == null) {
	         instance = new C_P_Warrior();
	      }
	      return instance;
	   }
	
	public void attack(Character target) {
		super.attack(target);
		this.mp-=10;
	}
	
	public void hurt(int dec_hp) {
		gethurt = true;
		this.Rshield();
		if(gethurt) super.hurt(dec_hp);
	}
	
	void Rshield() {
		rand = new Random();
		if(rand.nextInt(100)<=10) gethurt=false;
	}

}
*/