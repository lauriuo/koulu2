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
        
        ArrayList<Enemy> startEnemies = UI.Initialize(BackEnd.catalogue());

        while(startEnemies.isEmpty() == false) {
            
            int index = UI.StatusUpdate(startEnemies);
            System.out.println(index);
            if(index != -1) {
                int dmg = UI.AskDamage(index, startEnemies);
                if(dmg != 0) {
                    int ap = UI.AskAP();
                    BackEnd.subDamage(startEnemies.get(index), dmg, ap);
                }
            }
        }
    }
}
