/*package model;

import java.util.LinkedList;
import java.util.Random;

public class C_P_Magician extends C_Player {
	
	Random rand;
	boolean no_mp;
	
	private static C_P_Magician instance = null;
	
	private C_P_Magician() {
		this.hp=80;
		this.mp=70;
		this.existRange=30;
		this.item = new LinkedList<Item>();

		this.speed=10;
	}
	
	public synchronized static C_P_Magician getInstance() {
		if(instance==null) instance = new C_P_Magician();
		return instance;
	}
	
	public void attack(Character target) {
		super.attack(target);
		this.no_mp=false;
		this.RattackNoMp();
		if(!this.no_mp) this.mp-=20;
	}
	
	void RattackNoMp() {
		rand = new Random();
		if(rand.nextInt(100)<=10) no_mp=true;
	}

}
*/