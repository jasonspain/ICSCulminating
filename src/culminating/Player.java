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

public class Player {
    private int x, y;
    private PImage image;
    private int height,width;
    private PApplet app;
    private int currentFrame, sx, sy, row;
    private int delay;

    public Player(PApplet p, int x, int y, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
        this.height=64;
        this.width=64;
        this.currentFrame = 0;
        this.row = 40;
        this.delay=5;
        this.sx = 0;
        this.sy = 0;
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

    public void move(int dx, int dy) {
        if ((y + dy) > 0 && (y + dy) < 735 && (x + dx) < 840 && (x + dx) > 100) {
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
        
        sx = currentFrame * width;
        sy = row * height;

        if (delay == 0) {
            currentFrame = (currentFrame+1)%8;
        }
        
        delay=(delay+1)%5;
        
        if (dx == 0 && dy == 0) {
            currentFrame = 0;
            if(row>11){
                row=row-30;
            }
        }
    }
    public boolean isCollidingWith(Hurtbox other) {
        boolean isLeftOfOtherRight = (x + 15) <= other.getX() + other.getWidth();
        boolean isRightOfLeft = (x + 15)+ (width - 30) >= other.getX();
        boolean isAboveOtherBottom = (y + 12)+(height - 12) <= other.getY() + other.getHeight();
        boolean isBelowOtherTop = (y + 12) + (height - 12) >= other.getY();

        return isLeftOfOtherRight && isRightOfLeft && isAboveOtherBottom && isBelowOtherTop;
    }
    
    public boolean isCollidingWith(PowerUps other) {
        boolean isLeftOfOtherRight = (x + 15) <= other.getX() + other.getWidth();
        boolean isRightOfLeft = (x + 15)+ (width - 30) >= other.getX();
        boolean isAboveOtherBottom = (y + 12) <= other.getY() + other.getHeight();
        boolean isBelowOtherTop = (y + 12) + (height - 12) >= other.getY();

        return isLeftOfOtherRight && isRightOfLeft && isAboveOtherBottom && isBelowOtherTop;
    }
//    
//    public void displayInfo(PApplet p) {
//        app.fill(0);
//        app.text("X: " + x, x, y - 50);
//        app.text("Y: " + y, x, y - 30);
//    }

    public void draw() {
//        app.fill(255, 0, 0);
//        app.rect(x + 15, y + 12, width - 30, height - 12);
        app.copy(image, sx, sy, width, height, x, y, width, height);
    }

}
