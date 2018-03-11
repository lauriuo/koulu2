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
        
        for (Enemy enemy : enemies) {
            status = status + index + ". " + enemy.getName() +
            ", HP: " + enemy.getWounds() + System.lineSeparator();
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
                                "Do you really wish to quit?",
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
                    flag = true;
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
                                      "(" + enemies.get(index).getArmor() + " Armor)",
                        "How much damage:");
            
            if(dmg == null) {
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
                        "How much AP (Armor Penetration) do you have: ",
                        "how much AP: ");
            apnum = Integer.parseInt(ap);
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, 
            "Not a valid input");
        }
        return apnum;
    }
}