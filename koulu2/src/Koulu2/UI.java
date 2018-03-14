package Koulu2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lauri
 */
import java.util.*;
import javax.swing.JOptionPane;


public class UI {
    public static ArrayList<Enemy> Initialize(ArrayList<Enemy> catalog) {

        ArrayList<Enemy> startEnemies = StartEnemyTest.CreateEnemyList(catalog); 
        return startEnemies;
    }
    public static int StatusUpdate(ArrayList<Enemy> enemies) {
        String status = "";
        int index=0;
        boolean flag=false;
        int num=0;
        
        for (Enemy enemy : enemies) {           //Creates the status screen for the user.
            
            status = status + index + ". " + enemy.getName() +
            "       HP: " + enemy.getWounds() + ", Armor: " + enemy.getArmor() + System.lineSeparator();
            index++;
        }
        while(!flag) {                 
            try{
                String chosen = JOptionPane.showInputDialog(null,
                                status,
                                "# " + "0 - " + (enemies.size()-1));
                
                if(chosen == null || chosen.equals("")) {
                    int quit = JOptionPane.showConfirmDialog(null,
                                "Do you really wish to quit?",
                                "",
                                JOptionPane.YES_NO_OPTION);
                    if(quit == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    } else {
                        return -1;      
                    }
                } else {
                    num = Integer.parseInt(chosen);
                }
                
                if(num >= 0 && num <= (enemies.size() - 1)) {
                    flag = true;                // if a proper index is given, we exit the flag while loop.
                } else {
                    JOptionPane.showMessageDialog(null,
                                "Choose an index between 0 - " + (enemies.size() - 1));
                }
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null,
                    "Not a valid input, choose an index between 0 - " + (enemies.size() -1));
            }
        }
        return num;
    }
    public static int AskDamage(int index, ArrayList<Enemy> enemies) {
        int num=0;
        try{
            String dmg = JOptionPane.showInputDialog(null,
                        "How much damage is done to " + enemies.get(index).getName() + 
                                      " (" + enemies.get(index).getArmor() + " Armor)",
                        "dmg:");
            
            if(dmg == null) {             // Means that no damage value was input
                return num;
            }
            num = Integer.parseInt(dmg);
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,
            "Not a valid input, enter a damage value");
        }
        return num;
    }
    
    public static int AskAP() {
        int apnum=0;
        try{
            String ap = JOptionPane.showInputDialog(null,
                        "How much AP (Armor penetration) do you have: ",
                        "AP: ");
            apnum = Integer.parseInt(ap);
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, 
            "Not a valid input");
        }
        return apnum;
    }
    public static boolean CheckIfDead(Enemy enemy) {
        if(enemy.getWounds() <= 0){
            return true;
            } else {
            return false;
        }
    }
    public static void EnemyDied(Enemy enemy) {
        JOptionPane.showMessageDialog(null,
        "The enemy " + enemy.getName() + " has died.");
    }
    public static void BattleEnd() {            // Pops up when all the enemies are dead.
        int yesno = JOptionPane.showConfirmDialog(null,
                    "All the enemies are dead. Simulate a new battle?",
                    "",
                    JOptionPane.YES_NO_OPTION);
        
        if(yesno == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
    }
}