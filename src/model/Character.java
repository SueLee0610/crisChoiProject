package model;

public abstract class Character implements Recoverable, fightable, moveable {
	protected int hp;
	Position Pos;
	protected boolean last_stage;
	protected int existRange;
	protected int speed;
	
	public void move(int a) {	//a媛�?�씠 1�씠硫� �삤?��몄そ�쑝濡�, 2硫� �쇊履쎌?��濡� 
		switch(a) {
		case 1 : this.Pos.go(); break;
		case 2 : this.Pos.back(); break;
		case 3 : if(last_stage) this.Pos.up(); break;
		case 4 : if(last_stage) this.Pos.down(); break;
		default : break;
		}
	}
}
