package model;

public class C_Enemy extends Character{
	
	protected int power;
	
	@Override
	public void recover() {
		// TODO Auto-generated method stub
		
	}
	
	public void tracePlayer(C_Player player) {
		if(!this.isPlayerExist(player)) {
			if(player.Pos.getxPos()>this.Pos.getxPos()) move(1);
			else move(2);
		}
	}
	
	private boolean isPlayerExist(Character player) {//playerë²”ìœ„ ?‚´?— enemyê°? ?žˆ?œ¼ë©? trueë¦¬í„´, ?—†?œ¼ë©? falseë¦¬í„´ 
		if((player.Pos.getxPos()-this.Pos.getxPos())>player.existRange || (this.Pos.getxPos()-player.Pos.getxPos())>player.existRange) return false;
		else return true;
	}

	@Override
	public void hurt(int dec_hp) {
		// TODO Auto-generated method stub
		this.hp-=dec_hp;
	}

	@Override
	public void attack(Character target) {
		// TODO Auto-generated method stub
		if(this.isPlayerExist(target)) target.hurt(this.power);
	}
}
