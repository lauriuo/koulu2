package koulu2;
//Create class Enemy
public class Enemy {
	private int wounds;
	private int tb;
	private int armor;
	private String name;

		
	public Enemy() {
		//In this test phase, only one kind of enemy is possible.
		wounds = 12;
		tb = 6;
		armor = 2;
	}
	// constructor with class name given as string
	// correct attributes are given based on class name
	public Enemy(String classname) {
		name = classname;
		switch(name) {
			case "orkboy":
				name = "Orkboy";
				wounds = 12;
				tb = 6;
				armor = 2;
				break;
			case "stormboy":
				name = "Stormboy";
				wounds = 14;
				tb = 6;
				armor = 2;
				break;
			case "orknob":
				name = "Orknob";
				wounds = 25;
				tb = 9;
				armor = 2;
				break;
			case "guardsman":
				name = "Guardsman";
				wounds = 10;
				tb = 3;
				armor = 4;
				break;
			case "servitor":
				name = "Servitor";
				wounds = 10;
				tb = 4;
				armor = 4;
				break;
			case "ogryn":
				name = "Ogryn";
				wounds = 26;
				tb = 7;
				armor = 3;
				break;
		}
	}
		
	public void subWounds(int damage) {
		//After taking damage, calculate current wounds
		damage = damage - tb;
		if (damage - tb < 0) {
			damage = 0;
		}
		wounds -=  damage ;
		//calculations work now without taking armor into account
	}
	public String getName() {
		return name;
	}
	public int getTb() {
		return tb;
	}
	public int getArmor() {
		return armor;
	}
	public int getWounds() {
		return wounds;
	}
}

