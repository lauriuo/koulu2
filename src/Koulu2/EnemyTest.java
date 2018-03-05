package koulu2;
import java.util.*;

public class EnemyTest {

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int armor;
		int damage;
		int ap;
	
               
		//this is list of selectable enemy types
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(new Enemy("Orkboy"));
		enemies.add(new Enemy("Stormboy"));
		enemies.add(new Enemy("Orknob"));
		enemies.add(new Enemy("Guardsman"));
		enemies.add(new Enemy("Servitor"));
		enemies.add(new Enemy("Ogryn")); 
                
                

		//print all selectable enemy types
		for(Enemy i : enemies) {
			System.out.println("[" + (1 + enemies.indexOf(i)) + "] " + i.getName());
		}
		
                
		// Test ready-made list of enemies.	
		ArrayList<Enemy> selected = new ArrayList<Enemy>();
		selected.add(new Enemy("Stormboy"));
		selected.add(new Enemy("Servitor"));		
		
		
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
                        System.out.println("armor = " + armor);
			damage = damage - armor;
                        int tb = chosen.getTb();
                        System.out.println("TBonus is " + tb);
                        damage = damage - chosen.getTb();
                        //next line is debugging
                        System.out.printf("Damage is %d \n", damage);
			chosen.subWounds(damage);
                        //debugging...
                        
                        
			if(chosen.getWounds() <= 0) {
					System.out.println(chosen.getName() + " died (" + chosen.getWounds() + ")" );
				selected.remove(chosen);
			}
			
		}
		System.out.println("Battle over");

	}
}	
	



