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

public class Nian {
    private int x,y;
    private PImage image;
    private PApplet app;
    private int currentFrame,sx,sy,row;
    private int delay;
    private static final int HEIGHT= 240;
    private static final int WIDTH= 354;

public Nian(PApplet p, int x, int y, String imagePath) {
    this.app = p;
    this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
        this.currentFrame = 0;
        this.row = 0;
        this.delay=5;
        sx = 0;
        sy = 0;
    }
        
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getHEIGHT(){
        return HEIGHT;
    }
    
    public int getWIDTH() {
        return WIDTH;
    }
    
    public void draw() {   
        sx=currentFrame*WIDTH;
        sy=row*HEIGHT;
        
        if(delay==0){
            currentFrame++;
            if (currentFrame == 5 && row == 0) {
                currentFrame = 0;
                row = 1;
            } else if (currentFrame == 3 && row == 1) {
                currentFrame = 0;
                row = 0;
            }
        }
        
        delay=(delay+1)%5;
        app.copy(image, sx, sy, WIDTH, HEIGHT, x, y, WIDTH, HEIGHT);
    }
}

