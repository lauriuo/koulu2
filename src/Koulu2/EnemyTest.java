package koulu2;
import java.util.*;

public class EnemyTest {

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int armor;
		int damage;
		int ap;
		int enemynum;

		//this is list of selectable enemy types
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(new Enemy("orkboy"));
		enemies.add(new Enemy("stormboy"));
		enemies.add(new Enemy("orknob"));
		enemies.add(new Enemy("guardsman"));
		enemies.add(new Enemy("servitor"));
		enemies.add(new Enemy("ogryn")); 

		//print all selectable enemy types
		for(Enemy i : enemies) {
			System.out.println("[" + (1 + enemies.indexOf(i)) + "] " + i.getName());
		}
		/*
		switch(int){
			case 0:
				selected.add(new Enemy("orkboy"));
				break;
			case 1:
				selected.add(new enemy("stormboy"));
				break;
			case 2:
				selected.add(new enemy("orknob"));
				break;
			case 3:
				selected.add(new enemy("guardsman"));
				break;
			case 4:
				selected.add(new enemy("servitor"));
		          		break;
			case 5:
				selected.add(new enemy("ogryn"));
				break;
			}
			*/

	 	
		// Test ready-made list of enemies.	
		ArrayList<Enemy> selected = new ArrayList<Enemy>();
		selected.add(new Enemy("stormboy"));
		selected.add(new Enemy("servitor"));		
		
		
		while(selected.size() > 0) {
			for(Enemy i : selected) {
				System.out.println("[" + (1 + selected.indexOf(i)) + "] " + i.getName() + " " + i.getWounds());
			}

			System.out.print("Which enemy takes damage?");
			int choice = input.nextInt() - 1;
			Enemy chosen = selected.get(choice);
			System.out.println("How much damage is inflicted to " + chosen.getName());
			damage = input.nextInt();
			System.out.println("How much AP");
			ap = input.nextInt();
			armor = chosen.getArmor() - ap;
			if(armor<0) {
				armor = 0;
			}
			damage = damage - armor;
			chosen.subWounds(damage);
			if(chosen.getWounds() <= 0) {
					System.out.println(chosen.getName() + "died (" + chosen.getWounds() + ")" );
				selected.remove(chosen);
			}
			
		}
		System.out.println("Battle over");

		
		
		/*
		Enemy stormBoy = new Enemy("stormboy");
		System.out.println(stormBoy.getName() + " " + stormBoy.getWounds());
		System.out.println("Enter damage");
		damage = input.nextInt();
		System.out.println("Enter AP");
		ap = input.nextInt();

		// calculate damage
		armor = stormBoy.getArmor() - ap;
		if(armor < 0) {
			armor = 0;
		}
		damage = damage - armor;
		// call method subWounds
		stormBoy.subWounds(damage);
		System.out.print(stormBoy.getName() + " " + stormBoy.getWounds());
		*/
	}
}
		
	



