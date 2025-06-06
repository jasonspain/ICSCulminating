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
    private PApplet app;
    private int currentFrame, sx, sy, row;
    private int delay;
    private static final int HEIGHT = 64;
    private static final int WIDTH = 64;

    public Player(PApplet p, int x, int y, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
        this.currentFrame = 0;
        this.row = 40;
        this.delay=5;
        sx = 0;
        sy = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
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
        
        sx = currentFrame * WIDTH;
        sy = row * HEIGHT;

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
    public boolean isCollidingWith(Nian other) {
        boolean isLeftOfOtherRight = x < other.getX() + other.getWIDTH();
        boolean isRightOfLeft = x + WIDTH > other.getX();
        boolean isAboveOtherBottom = y+HEIGHT < other.getY() + other.getHEIGHT();
        boolean isBelowOtherTop = y + HEIGHT > other.getY();

        return isLeftOfOtherRight && isRightOfLeft && isAboveOtherBottom && isBelowOtherTop;
    }
    public void displayInfo(PApplet p) {
        app.fill(0);
        app.text("X: " + x, x, y - 50);
        app.text("Y: " + y, x, y - 30);
    }

    public void draw() {
        app.fill(255, 0, 0);
        app.rect(x + 15, y + 12, WIDTH - 30, HEIGHT - 12);
        app.copy(image, sx, sy, WIDTH, HEIGHT, x, y, WIDTH, HEIGHT);
    }

}
