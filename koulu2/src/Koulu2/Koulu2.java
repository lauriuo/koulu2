/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koulu2;

/**
 *
 * @author lauri
 */
import java.util.*;

public class Koulu2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean flag = false;
        while(!flag) {                                            //Loops as long as the user chooses to quit.
            ArrayList<Enemy> startEnemies = UI.Initialize(BackEnd.catalogue());

            while(startEnemies.isEmpty() == false) {              //Continues as long as there are enemies left.
                int index = UI.StatusUpdate(startEnemies);

                if(index != -1) {                                 //-1 indicates that the user chose NO on "do you wish to quit"
                    int dmg = UI.AskDamage(index, startEnemies);

                    if(dmg != 0) {                                //Asks AP only if we are actually going to do some damage.
                        int ap = UI.AskAP();
                        BackEnd.subDamage(startEnemies.get(index), dmg, ap);

                        if(UI.CheckIfDead(startEnemies.get(index)) == true) {  //Removes dead enemies from the status list.
                            UI.EnemyDied(startEnemies.get(index));
                            startEnemies.remove(index);
                        }
                    }
                }
            }
        UI.BattleEnd();             // Asks if the user wants to simulate a new battle.
        }
    }
}
