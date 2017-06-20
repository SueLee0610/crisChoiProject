package model;

import java.util.Random;

public class C_E_genie extends C_Enemy {
	
	Random rand;
	
	public C_E_genie() {
		//this.power=20;
		//this.Pos = new Position(10,10);
	}
	
	public void attack(Character target) {
		rand = new Random();
		int temp = rand.nextInt(100);
		
		if(temp<5) this.rain(target);
		else if(temp<20) this.throw_cloud();
		else super.attack(target);
	}
	
	void rain(Character target) {
		long start = System.currentTimeMillis();
		target.speed-=3;
		while((System.currentTimeMillis()-start)/1000 < 10) {
			//raining
		}
		target.speed+=3;
	}
	
	void throw_cloud() {
		
		
	}
}
