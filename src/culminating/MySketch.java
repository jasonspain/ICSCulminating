/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating;

/**
 *
 * @author 343469953
 */
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PApplet;

public class MySketch extends PApplet {
    public PApplet MySketchP = this;
    private Player player;
    private HpBar hp;
    private Nian nian;
    private PowerUps power;
    PImage bg;
    PImage bgTop;

    public void settings() {
        size(1000, 1000);
        bg = loadImage("images/background.png");
        bgTop = loadImage("images/backgroundTop.png");
    }

    public void setup() {
        background(255);
        textSize(20);
        player = new Player(MySketchP, 468, 605, "images/player.png");
        nian = new Nian(MySketchP, 323, 0, "images/nian.png");
        hp = new HpBar(MySketchP, 60, 10, 100);
    }

    public void draw() {
        background(bg);
        if (nian.getY() + nian.getHeight() > player.getY() + player.getHeight()) {
            player.draw();
            nian.draw();
        } else {
            nian.draw();
            player.draw();
        }
        nian.chase(player.getX(),player.getY(),false);
        image(bgTop, 0, 0);
        hp.draw();
        player.displayInfo(this);

        if (keyPressed) {
            if (keyCode == LEFT) {
                player.move(-5, 0);
            }
            if (keyCode == RIGHT) {
                player.move(5, 0);
            }
            if (keyCode == UP) {
                player.move(0, -5);
            }
            if (keyCode == DOWN) {
                player.move(0, 5);
            }
        } else {
            player.move(0, 0);
        }
        
        damage();
    }
    
    public void damage() {
        Hurtbox[] hurtboxes = {nian.getHurtbox1(),nian.getHurtbox2()};
        for(int i=0;i<hurtboxes.length;i++){
            if (player.isCollidingWith(hurtboxes[i])) {
                hp.damage();
            }
        }
    }
    
    public void spawnPowerUps(PowerUps power) {
        int randX = round(random(110, 800));
        int randY = round(random(80, 650));
        power = new PowerUps(this,randX,randY);
    }
}//end class
