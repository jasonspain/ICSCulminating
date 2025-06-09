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
public class Hurtbox {
    private int x, y;
    private int height,width;
    

    public Hurtbox(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y+=y;
    }
    public void changeX(int x) {
         this.x+=x;
    }

    public void changeY(int y) {
        this.y+=y;
    }
    
    public void draw(PApplet app){
        app.fill(255, 0, 0, 100); 
        app.noStroke();
        app.rect(x,y, width, height);
    }
}
