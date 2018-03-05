package koulu2;
import java.util.*;

public class EnemyTest {

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int armor;
		int damage;
		int ap;
                int choice;
                ArrayList<Enemy> selected = new ArrayList<Enemy>();
           
		//this is list of selectable enemy types
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(new Enemy("Orkboy"));
		enemies.add(new Enemy("Stormboy"));
		enemies.add(new Enemy("Orknob"));
		enemies.add(new Enemy("Guardsman"));
		enemies.add(new Enemy("Servitor"));
		enemies.add(new Enemy("Ogryn")); 
                
                
                System.out.println("Selectable enemy types");
		//^print all selectable enemy types
		for(Enemy i : enemies) {
			System.out.println("[" + (1 + enemies.indexOf(i)) + "] " + i.getName());
		}
		
              
		do {
                    System.out.println("Select enemy type, 0 to continue");
                    choice = input.nextInt();
                    if(choice == 1) {
                    selected.add(new Enemy("Orkboy"));
                    }
                       else if(choice == 2){
                                selected.add(new Enemy("Stormboy"));
                                }
                      else if(choice ==3){
                                selected.add(new Enemy("Orknob"));
                                }
                     else if(choice == 4){
                             selected.add(new Enemy("Guardsman"));
                              }
                        else if(choice == 5){
                              selected.add(new Enemy("Servitor"));
                                }
                        else if(choice == 6){
                                selected.add(new Enemy("Ogryn"));
                            }
                               //else{ System.out.println("Wrong input, exiting");
                               //System.exit(0);
                               //}
                    for(Enemy i : selected){
                        System.out.println("[" + (1 + selected.indexOf(i)) + "] " + i.getName() + " " + i.getWounds());
                    }
                    } while(choice != 0);
		// Test ready-made list of enemies.	
		//
		//selected.add(new Enemy("Stormboy"));
		//selected.add(new Enemy("Servitor"));		
		
                
		
		while(selected.size() > 0) {
                    System.out.println("You have selected following enemy units");
                    for(Enemy i : selected) {
                        System.out.println("[" + (1 + selected.indexOf(i)) + "] " + i.getName() + " " + i.getWounds());
                    }    
                    System.out.print("Which enemy takes damage?");
			choice = input.nextInt() - 1;
			Enemy chosen = selected.get(choice);
			System.out.println("How much damage is inflicted to " + chosen.getName());
			damage = input.nextInt();
			System.out.println("How much AP");
			ap = input.nextInt();
                        
			armor = chosen.getArmor() - ap;
                        
			if(armor<0) {
				armor = 0;
                               
			}
                        //System.out.println("armor = " + armor);
			damage = damage - armor;
                        int tb = chosen.getTb();
                        //System.out.println("TBonus is " + tb);
                        damage = damage - chosen.getTb();
                        //next line is debugging
                        //System.out.printf("Damage is %d \n", damage);
			chosen.subWounds(damage);
                        
                        
			if(chosen.getWounds() <= 0) {
					System.out.println(chosen.getName() + " died (" + chosen.getWounds() + ")" );
				selected.remove(chosen);
			}
			
		}
		System.out.println("Battle over");

	}
}



