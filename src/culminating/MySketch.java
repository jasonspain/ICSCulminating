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
    private boolean chassing=false;
    private PowerUps power;
    private boolean effect=false;
    private String effectImage;
    private int effectTimer = 0;
    private int effectDuration=0;
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
        power = new PowerUps(this,-100,-100,"images/powerups.png");
    }

    public void draw() {
        background(bg);
        power.draw();
        if (nian.getY() + nian.getHeight() > player.getY() + player.getHeight()) {
            player.draw();
            nian.draw();
        } else {
            nian.draw();
            player.draw();
        }
        nian.chase(player.getX(),player.getY(),chassing);
        image(bgTop, 0, 0);
        hp.draw();
//        player.displayInfo(this);

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
        powerup();
        if(effect){
            powerupEffect();
        }
    }
    
    public void damage() {
        Hurtbox[] hurtboxes = {nian.getHurtbox1(),nian.getHurtbox2()};
        for(int i=0;i<hurtboxes.length;i++){
            if (player.isCollidingWith(hurtboxes[i])) {
                hp.damage();
            }
        }
    }
    public void powerup(){
        if (player.isCollidingWith(power)) {
            power.setX(-100);
            power.setY(-100);
            if (power.getSx() == 0) {
                hp.heal();
                effectImage = "images/healing.png";
                effect = true;
                effectDuration=50;
            } else if (power.getSx() == 64) {
                
            } else if (power.getSx() == 128) {
                nian.damage(240);
                effectImage = "images/explosion.png";
                effect = true;
                effectDuration=15;
            } else if (power.getSx() == 192) {
                effectImage = "images/fire.png";
                effect = true;
                effectDuration=64;
            }else{
                
            }
        }
        
    }
    
    public void powerupEffect() {
        if (effectTimer < effectDuration) {
            if (effectImage.equals("images/explosion.png")) {
                tint(255, 126);
                image(loadImage(effectImage), nian.getX()-90,nian.getY()-100);
            } else if (effectImage.equals("images/healing.png")) {
                image(loadImage(effectImage), player.getX(), player.getY());
            } else if(effectImage.equals("images/fire.png")){
                nian.damage(2);
                tint(255, 126);
                image(loadImage(effectImage), nian.getX()-90,nian.getY()-90);
            }
            
            effectTimer++;
        }else{
            effectTimer=0;
            effect=false;
            
        }
    }
}//end class
