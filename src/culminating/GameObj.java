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
public class GameObj {
    //Variables
    protected int x, y;
    protected PImage image;
    protected PApplet app;
    protected int height, width;
    
    /*
    *Constuctor for GameObj
    *
    *@param PApplet object
    *@param y postion
    *@param x postion
    *@param image
    */
    public GameObj(PApplet p, int x, int y, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
    }
    
    /*
    * Overloaded constuctor for GameObj
    *
    *@param PApplet object
    *@param y postion
    *@param x postion
    */
    public GameObj(PApplet p, int x, int y) {
        this.app = p;
        this.x = x;
        this.y = y;
    }
    /*
    *Getter method
    *@return the x postion
    */
    public int getX() {
        return x;
    }
    
    /*
    *Getter method
    *@return the y postion
    */
    public int getY() {
        return y;
    }
    
    /*
    *Getter method
    *@return the height of the object
    */
    public int getHeight() {
        return height;
    }
    
    /*
    *Getter method
    *@return the width of the object
     */
    public int getWidth() {
        return width;
    }
    
    /*
    *method draws the object
    */
    public void draw() {
        app.rect(x, y, width, height);
    }
}
