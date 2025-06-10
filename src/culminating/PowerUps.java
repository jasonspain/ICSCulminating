/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating;

import processing.core.PApplet;
import static processing.core.PApplet.round;
import processing.core.PImage;

/**
 *
 * @author 343469953
 */
public class PowerUps {
    private int x, y;
    private int height, width;
    private int currentFrame, sx;
    private int delay;
    private PImage image;
    private PApplet app;
    
    public PowerUps(PApplet p, int x, int y,String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.width = 64;
        this.height = 64;
        this.currentFrame = 0;
        this.sx = 0;
        this.delay = 100;
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
    
    public int getSx() {
        return sx;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y += y;
    }
    
    public void draw() {
        if(delay==0){
            x = round(app.random(110, 800));
            y = round(app.random(80, 650));
            sx = 0;
        }
        
        app.copy(image, sx, 0, width, height, x, y, width, height);
        delay = (delay + 1) % 500;
    }
}
