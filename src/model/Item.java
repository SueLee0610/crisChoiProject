package model;

public abstract class Item {
	protected int inc_hp;
	protected int inc_mp;
	private boolean isItem;
	
	boolean isItem() {
		if(isItem) return true;
		else return false;
	}
	int increase_hp() {
		this.isItem=false;
		return inc_hp;
	}
	int increase_mp() {
		this.isItem=false;
		return inc_mp;
	}
}
