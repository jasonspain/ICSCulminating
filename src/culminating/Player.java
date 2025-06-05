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
    public int x,y;
    private PImage image;
    private PApplet app;
    private int currentFrame,sx,sy,row;
    private static final int HEIGHT= 64;
    private static final int WIDTH= 64;
    
    public Player(PApplet p, int x, int y, String imagePath) {
        this.app=p;
        this.x=x;
        this.y=y;
        this.image = app.loadImage(imagePath);
        this.currentFrame=0;
        this.row=0;
        sx=0;
        sy=0;
    }  
    
    public void move(int dx, int dy) {
        if((y+dy)>0&&(y+dy)<735){
            x += dx;
            y += dy;
        }
        if(dx>0){
            row=11;
        }
        if(dx<0){
          row=9;
        }
        if(dy>0){
          row=10; 
        }
        if(dy<0){
          row=8;
        }
        if(dx==0 && dy==0){
          currentFrame=0;  
        }
        sx=currentFrame*WIDTH;
        sy=row*HEIGHT;
        
        currentFrame++;
        if(currentFrame==9){
            currentFrame=0;
        }
    }
    public void displayInfo(PApplet p) {
        app.fill(0);
        app.text("X: " + x, x, y - 50);
        app.text("Y: " + y, x, y - 30);
    }
    public void draw(){
        app.copy(image,sx,sy,WIDTH,HEIGHT,x,y,WIDTH,HEIGHT);
    }

}

