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
public class HpBar {
    private int x, y;
    private int hp;
    private int delay;
    private PApplet app;

    public HpBar(PApplet p, int x, int y, int hp) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.delay=20;
    }
    
    public void heal() {
        if((hp+30)<=100){
            hp+=30;
        }else if((hp+30)>=100){
            hp=100;
        }
    }
    
    public void damage(){
        if(delay==0 &&hp>0){
            hp-=10;
        }
        
        delay=(delay+1)%20;
    }

    public void draw() {
        app.fill(0);
        app.text("HP", x - 40, y + 20);
        app.noStroke();
        app.fill(255);
        app.rect(x, y, 200, 30);
        app.fill(255, 0, 0);
        app.rect(x, y, 2 * hp, 30);
        app.fill(0);
        app.text(hp, x+10, y + 20);

    }
}
