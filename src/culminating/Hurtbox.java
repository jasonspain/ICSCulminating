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
public class Hurtbox extends GameObj {   
    /*
    *Constructor for Hurtbox obejct
    */
    public Hurtbox(PApplet p, int x, int y, int width, int height) {
        super(p, x, y);
        this.width = width;
        this.height = height;
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
        this.y= y;
    }
    
    /*
    *method to change the x postion
    *@param the change in x postion
    */
    public void changeX(int x) {
        this.x += x;
    }
    
    /*
    *method to change the y postion
    *@param the change in y postion
    */
    public void changeY(int y) {
        this.y += y;
    }
    
    /*
    *Method to draw the Hurtbox object
    */
    @Override
    public void draw() {
        app.fill(255, 0, 0, 0);
        app.noStroke();
        app.rect(x, y, width, height);
    }
}
