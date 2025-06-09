/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating;

import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author jasonwu
 */
public class Enemy {
    protected int x, y;
    protected PImage image;
    protected PApplet app;
    protected int height, width;
    protected Hurtbox hurtbox1;
    
    public Enemy(PApplet p, int x, int y, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    public Hurtbox getHurtbox1(){
        return hurtbox1;
    }
}
