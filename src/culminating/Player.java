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

public class Player extends GameObj {
    //Variables
    private int currentFrame, sx, sy, row;
    private int delay;
    
    /*
    *Constructor for Player obejct
    */
    public Player(PApplet p, int x, int y, String imagePath) {
        super(p, x, y, imagePath);
        this.height = 64;
        this.width = 64;
        this.currentFrame = 0;
        this.row = 40;
        this.delay = 5;
        this.sx = 0;
        this.sy = 0;
    }
    /*
    *Setter method
    *@param the spritesheet of the player
    */
    public void setImage(String imagePath) {
        this.image = app.loadImage(imagePath);
    }
    
    /*
    *Method for the players movement
    *@param the change in x
    *@param the change in y
    */
    public void move(int dx, int dy) {
        if ((y + dy) > 115 && (y + dy) < 770 && (x + dx) < 840 && (x + dx) > 80) {
            x += dx;
            y += dy;
        }
        if (dx > 0) {
            row = 41;
        }
        if (dx < 0) {
            row = 39;
        }
        if (dy > 0) {
            row = 40;
        }
        if (dy < 0) {
            row = 38;
        }
        
        //Gets the frame in the spritesheet
        sx = currentFrame * width;
        sy = row * height;
        
        //changing frams after a delay
        if (delay == 0) {
            currentFrame = (currentFrame + 1) % 8;
        }
        
        //delay increase and resets after 5
        delay = (delay + 1) % 5;
        
        //If player isn't moving
        if (dx == 0 && dy == 0) {
            currentFrame = 0;
            if (row > 11) {
                row = row - 30;
            }
        }
    }
    
    /*
    *method for checking collision with the player
    *@param the object its checking collision with
    *@return whether its colliding or not
    */
    public boolean isCollidingWith(GameObj other) {
        if(other instanceof Projectile){
            int centerX=x+32;
            int centerY=y+32;
            int otherCenterX=other.getX();
            int otherCenterY=other.getY();
            
            float d = PApplet.dist(otherCenterX,otherCenterY,centerX,centerY);
            return d<54;
        }else{
            boolean isLeftOfOtherRight = (x + 15) <= other.getX() + other.getWidth();
            boolean isRightOfLeft = (x + 15) + (width - 30) >= other.getX();
            boolean isAboveOtherBottom = (y + 12) + (height - 12) <= other.getY() + other.getHeight();
            if (other instanceof PowerUps) {
                isAboveOtherBottom = (y + 12) <= other.getY() + other.getHeight();
            }
            boolean isBelowOtherTop = (y + 12) + (height - 12) >= other.getY();

            return isLeftOfOtherRight && isRightOfLeft && isAboveOtherBottom && isBelowOtherTop;
        }
    }
    
    /*
    *Method to draw the player
    */
    @Override
    public void draw() {
        app.copy(image, sx, sy, width, height, x, y, width, height);
    }

}
