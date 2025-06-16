/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating;

import processing.core.PApplet;
import static processing.core.PApplet.round;

/**
 *
 * @author 343469953
 */
public class PowerUps extends GameObj {
    //Variables
    private int currentFrame, sx;
    private int delay;
    
    /*
    *Constructor for PowerUps obejct
    */
    public PowerUps(PApplet p, int x, int y, String imagePath) {
        super(p, x, y, imagePath);
        this.width = 64;
        this.height = 64;
        this.currentFrame = 0;
        this.sx = 0;
        this.delay = 100;
    }
    
    /*
    *getter method
    *@return the x postion of the frame of the spritesheet
    */
    public int getSx() {
        return sx;
    }
    
    /*
    *setter method
    *@param the new x postion 
    */
    public void setX(int x) {
        this.x = x;
    }
    
    /*
    *setter method
    *@param the new y postion 
    */
    public void setY(int y) {
        this.y += y;
    }
    
    /*
    *Method to draw the PowerUps object
    */
    @Override
    public void draw() {
        //After a delay set a random postion in the window and the spritesheet
        if (delay == 0) {
            x = round(app.random(150, 750));
            y = round(app.random(100, 700));
            sx = round(app.random(0, 3)) * 64;
        }
        //draws the power up
        app.copy(image, sx, 0, width, height, x, y, width, height);
        
        //delay increase and reset at 500
        delay = (delay + 1) % 500;
    }
}
