/*package model;

import java.util.LinkedList;
import java.util.Random;

public class C_P_Gunner extends C_Player{
	
	Random rand;
	boolean attack_two;
	
	private static C_P_Gunner instance = null;
	
	private C_P_Gunner() {
		this.hp=90;
		this.mp=60;
		this.existRange=20;
		this.Pos = new Position(0,0);
		this.speed=20;
	}
	
	public synchronized static C_P_Gunner getInstance() {
		if(instance==null) instance = new C_P_Gunner();
		return instance;
	}
	
	public void attack(Character target) {
		super.attack(target);
		this.attack_two=false;
		if(this.attack_two) super.attack(target);
		this.mp-=15;
		
	}
	
	void RattackTwice() {
		rand = new Random();
		if(rand.nextInt(100)<=10) attack_two=true;
	}
}*/
