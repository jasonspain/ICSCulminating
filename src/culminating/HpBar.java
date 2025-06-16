/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating;

import processing.core.PApplet;

/**
 *
 * @author jasonwu
 */
public class HpBar extends GameObj {
    //variables
    private int hp;
    private int delay;
    public static int dmg = 10;
    /*
    *Constructor for HpBar obejct
    */
    public HpBar(PApplet p, int x, int y, int hp) {
        super(p, x, y);
        this.hp = hp;
        this.delay = 20;
    }
    /*
    *getter method
    *@return the hp of the player
    */
    public int getHp() {
        return hp;
    }
    
    /*
    *method for healing the hp of the player
    */
    public void heal() {
        if ((hp + 30) <= 100) {
            hp += 30;
        } else if ((hp + 30) >= 100) {
            hp = 100;
        }
    }
    
    /*
    *method when player takes damage
    */
    public void damage(int maxdelay) {
        if (delay == 0 && hp > 0) {
            hp -= dmg;
        }

        delay = (delay + 1) % maxdelay;
    }
    
    /*
    *draws the HpBar object
    */
    @Override
    public void draw() {
        app.fill(0);
        app.text("HP", x - 40, y + 20);
        app.noStroke();
        app.fill(255);
        app.rect(x, y, 200, 30);
        app.fill(255, 0, 0);
        app.rect(x, y, 2 * hp, 30);
        app.fill(0);
        app.text(hp, x + 10, y + 20);

    }
}
