package Koulu2;
import java.util.*;

public class EnemyTest {

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
                
		int armor; // this value will be enemy armor points with attacks ap-value subtracted
		int damage; // player-inflicted damage value
		int ap; // armor-piercing value
                
                int choice; // in CLI-based version, this is used to store users input
                
                ArrayList<Enemy> selected = new ArrayList<Enemy>(); // select enemies to be put into this list for a battle.
           
		//this is list of selectable enemy types. Feel free to add your own. Remember to add them to Enemy.java class too.
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(new Enemy("Orkboy"));
		enemies.add(new Enemy("Stormboy"));
		enemies.add(new Enemy("Orknob"));
		enemies.add(new Enemy("Guardsman"));
		enemies.add(new Enemy("Servitor"));
		enemies.add(new Enemy("Ogryn")); 
                
                
                System.out.println("Select enemy");
		//print all selectable enemy types
		for(Enemy i : enemies) {
			System.out.println("[" + (1 + enemies.indexOf(i)) + "] " + i.getName());
		}
		
              
		do { // add enemies until user gives 0.
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
                               else{ System.out.println("Wrong input, try again");}
                               
                               
                    for(Enemy i : selected){
                        System.out.println("[" + (1 + selected.indexOf(i)) + "] " + i.getName() + " " + i.getWounds());
                    }
                    } while(choice != 0);	
		
                System.out.println(""); // Print empty line for visual purposes
		// now program advances to battle. First we print selected units
                
		while(selected.size() > 0) {
                    System.out.println("You have selected following enemy units");
                    for(Enemy i : selected) {
                        System.out.println("[" + (1 + selected.indexOf(i)) + "] " + i.getName() + " " + i.getWounds());
                    }    
                    
                    System.out.print("Which enemy takes damage?");// ask user to input damage-receiving enemy
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



