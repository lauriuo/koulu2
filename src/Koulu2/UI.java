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
/* metodin startOptions testi, lis tarkotus olla lista vihollisluokista */
public class UI {
    public static void main(String[] args) { 
        /*String[] lis = {"Enemy0","Enemy1","Enemy2","Enemy3"};
        ArrayList lopputulos = Start.startOptions(lis);
   
        //print all selectable enemy types
        String[] list2 = enemies.toArray(new String[enemies.size()]);
        for (String string : list2) {
            System.out.println(string);
        }
        ArrayList lopputulos2 = Start.startOptions(list2);
        System.out.println(lopputulos);*/
        
        //this is list of selectable enemy types
        
        ArrayList<Enemy> enemies = new ArrayList<>();  
	enemies.add(new Enemy("Orkboy"));
	enemies.add(new Enemy("Stormboy"));
	enemies.add(new Enemy("Orknob"));
	enemies.add(new Enemy("Guardsman"));
	enemies.add(new Enemy("Servitor"));
	enemies.add(new Enemy("Ogryn"));
        
        ArrayList<Enemy> startEnemies = StartEnemyTest.CreateEnemyList(enemies);  //testaa starttia Enemy-luokkaa kayttaen, pitas toimia.
        
        for (Enemy startEnemy : startEnemies) {
            System.out.println(startEnemy.getName());
        }
    }
}