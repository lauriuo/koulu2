package Koulu2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author lauri
 */
public class Start {
       public static ArrayList<String> startOptions(String[] startList) {
           ArrayList<String> listofenemies = new ArrayList<>();

        int value=0;
        boolean flag = false;
        String stringofenemies = System.lineSeparator(); // Total of all chosen enemies, will be displayed in the last InputDialog. 
        
        while(!flag) {                  // Asks the user to choose an enemy class.
            String message = (String) JOptionPane.showInputDialog(null,
                        "Choose an enemy",
                        "Enemy",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        startList,
                        startList[0]);
            if(message == null) {       // Cancel returns null, stops the program.
                System.exit(0);
            }
            
                
            try{                       // Asks for the number of units of the chosen enemy type.
                String num = JOptionPane.showInputDialog(null,  
                            "Number of enemies type " + "(" + message + ")" + " :",
                            "#",
                            JOptionPane.QUESTION_MESSAGE);
                value = Integer.parseInt(num);
                
                for (int j = 0; j < value; j++) {   
                    listofenemies.add(message);
                }
                
                int yesno = JOptionPane.showConfirmDialog(null, 
                        "Add more enemies?",
                        "Add more enemies?",
                        JOptionPane.YES_NO_OPTION);
                
                if(yesno == JOptionPane.NO_OPTION) {
                    flag = true;
                }
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Not a valid input.");
           }
            
        stringofenemies = stringofenemies + value + " " + message + System.lineSeparator(); 

        if(flag) {    
            int continueOrCancel = JOptionPane.showConfirmDialog(null,
                    "Continue with enemies: " + stringofenemies,
                    "",
                    JOptionPane.YES_NO_OPTION);
            if(continueOrCancel == JOptionPane.YES_OPTION) {
                return listofenemies;
            } else {
                listofenemies.removeAll(listofenemies);
                flag = false;
            }
        }
    }
        
        return listofenemies;
    }
}
