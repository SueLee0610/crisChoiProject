package model;

import java.util.LinkedList;

public abstract class C_Player extends Character{
	private int xPos, xMove, yPos, nx, backgroundXPos, left, yMove;//dx = 키 한 번 누를 때마다 움직이는 정도 
	private int hp = 100, mp = 100;


	@Override
	public void attack(Character target) {
		// TODO Auto-generated method stub
		//target.hurt(this.weapon.power);
	}

	@Override
	public void hurt(int dec_hp) {
		// TODO Auto-generated method stub
		this.hp-=dec_hp;
	}
	
	public void use_item(Item item) {
		if(item.isItem()) {
			this.hp+=item.increase_hp();
			this.mp+=item.increase_mp();
		}
	}
	
	public void recover() {
		
	}
	
    public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}
}
