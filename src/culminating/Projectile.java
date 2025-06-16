/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating;

import processing.core.PApplet;
import static processing.core.PApplet.round;

/**
 *
 * @author jasonwu
 */
public class Projectile extends GameObj{
    //Variables
    private int targetX,targetY;
    public int dx,dy;
    private int duration;
    
    /*
    *Constructor for Projectile obejct
    */
    public Projectile(PApplet p, int x, int y, int width, int height) {
        super(p, x, y);
        this.width = width;
        this.height = height;
        this.duration = 0;
    }
    
    /*
    *Setter method
    *@param the target x postion
    */
    public void setTargetX(int targetX){
        this.targetX=targetX;
    }
    
    /*
    *Setter method
    *@param the target y postion
    */
    public void setTargetY(int targetY){
        this.targetY=targetY;
    }
    
    /*
    *Setter method
    *@param the x postion
    */
    public void setX(int x) {
        this.x = x;
    }

    /*
    *Setter method
    *@param the y postion
    */
    public void setY(int y) {
        this.y = y;
    }
    
    /*
    *method to find the rise and the run
    */
    public void change(){
        dx=(targetX-x)/25;
        dy=(targetY-y)/25;
    }
    
    /*
    *method to draw the Projectile object
    */
    public void draw(){
        x += dx;
        y += dy;
        app.strokeWeight(0);
        app.fill(255,0,0);
        app.ellipse(x, y, width, height);
    }
}
