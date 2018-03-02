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
import java.util.ArrayList;

public class StartEnemyTest {
    public static ArrayList<Enemy> CreateEnemyList(ArrayList <Enemy> enemies) {
        
        ArrayList<String> namelist = new ArrayList<>();
        
        for (Enemy enemy : enemies) { //luo ArrayList<String> enemy nimien perusteella
            namelist.add(enemy.getName());
        }
        
        String[] startlist = namelist.toArray(new String[namelist.size()]); //luodaan String Array starttia varten
        
        ArrayList<String> startEnemies = Start.startOptions(startlist); 
        
        ArrayList<Enemy> finalEnemies = new ArrayList<>();
        
        for (String enemy : startEnemies) {     //luo startOptionsin listan nimien perusteella uuden Enemy-luokkaa sisaltavan ArrayListin.
            finalEnemies.add(new Enemy(enemy));
            
        }
        return finalEnemies;
    }
}

