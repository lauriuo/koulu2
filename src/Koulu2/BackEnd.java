/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koulu2;
import java.util.*;
        
public class BackEnd {
    
    public static ArrayList<Enemy> catalogue() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("orkboy"));
        enemies.add(new Enemy("stormboy"));
        enemies.add(new Enemy("orknob"));
        enemies.add(new Enemy("guardsman"));
        enemies.add(new Enemy("servitor"));
        enemies.add(new Enemy("ogryn"));
        
        return enemies;
    }
 
    public void subDamage(Enemy chosen, int damage, int ap) {
        int armor = chosen.getArmor() - ap;
        if(armor < 0) {
            armor = 0;
        }
        damage = damage - armor - chosen.getTb();
        if(damage < 0){
            damage = 0;
        }
        
        chosen.subWounds(damage);
    }
    
    
        
     
        
        
    }
}
