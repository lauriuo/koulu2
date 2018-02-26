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
        /* String[] startList = {"Enemy0", "Enemy1", "Enemy2", "Enemy3"}; */
        
        boolean flag = false;
        
        Map<String, Integer> map = new HashMap<>();   /* ei oikeestaan liity tähän, testi vaan */
        int i = 0;                                    /* vois olla järkevää käyttää hashmappia ja numeroi vihut */  
        for (String string : startList) {                 /* eli olis lopussa lista vihuihin kohdistuvia indeksinumeroita nimien sijaan */
            map.put(string, i);
            i++;
        }

        while(!flag) {                  /* Kysyy vihuja niin kauan ku käyttäjä valitsee NO lopussa */
            String message = (String) JOptionPane.showInputDialog(null,
                        "Choose an enemy",
                        "Enemy",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        startList,
                        startList[0]);
            if(message == null) {       /* CANCEL lopettaa ohjelman */
                System.exit(0);
            }
            
                
            try{                       /* Pyytää valitun vihun määrän */
                String num = JOptionPane.showInputDialog(null,  
                            "Number of enemies type " + "(" + message + ")" + " :",
                            "#",
                            JOptionPane.QUESTION_MESSAGE);
                int value = Integer.parseInt(num);
                
                for (int j = 0; j < value; j++) {   /* laittaa vihuja listaan annetun arvon verran */
                    listofenemies.add(message);
                }
                
                int yesno = JOptionPane.showConfirmDialog(null, 
                        "Add more enemies?",
                        "",
                        JOptionPane.YES_NO_OPTION);
                
                if(yesno == JOptionPane.NO_OPTION) {
                    flag = true;
                }
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Not a valid input.");
           }
        }
        listofenemies.size();
        
        return listofenemies;
    }
    public static void main(String[] args) {
    }
}
