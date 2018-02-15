package koulu2;
//Create class Enemy
public class Enemy {
	private int wounds;
	private int tb;
	private int armor;

		
	public Enemy() {
		//In this test phase, only one kind of enemy is possible.
		wounds = 12;
		tb = 6;
		armor = 2;
	}
	public void subWounds(int damage) {
		//After taking damage, calculate current wounds
		wounds =- wounds - (damage - armor )- tb;
		//calculations are incorrect, output is very wrong
	}
	public int getWounds() {
		return wounds;
	}
}

