package Koulu2;
//Create class Enemy
public class Enemy {
	private int wounds;
	private int tb;
	private int armor;
	private String name;

	// constructor with class name given as string
	// correct attributes are given based on class name
	public Enemy(String classname) {
		name = classname;
		switch(name) {
			case "Orkboy":
				name = "Orkboy";
				wounds = 12;
				tb = 6;
				armor = 2;
				break;
			case "Stormboy":
				name = "Stormboy";
				wounds = 14;
				tb = 6;
				armor = 2;
				break;
			case "Orknob":
				name = "Orknob";
				wounds = 25;
				tb = 9;
				armor = 2;
				break;
			case "Guardsman":
				name = "Guardsman";
				wounds = 10;
				tb = 3;
				armor = 4;
				break;
			case "Servitor":
				name = "Servitor";
				wounds = 10;
				tb = 4;
				armor = 4;
				break;
			case "Ogryn":
				name = "Ogryn";
				wounds = 26;
				tb = 7;
				armor = 3;
				break;
		}
	}
		
	public void subWounds(int damage) {
		//After taking damage, calculate current wounds
		
		wounds = wounds - damage ;
		
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

