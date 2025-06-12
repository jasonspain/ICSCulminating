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

public class Nian extends Enemy{
    private int currentFrame,totalFrames, sx, sy, row;
    private int delay;
    private int hp;
    private Hurtbox hurtbox2;

    public Nian(PApplet p, int x, int y, String imagePath) {
        super(p,x, y, imagePath);
        this.height = 294;
        this.width = 378;
        this.currentFrame = 0;
        this.totalFrames = 8;
        this.row = 1;
        this.delay = 5;
        this.sx = 0;
        this.sy = 0;
        this.hurtbox1= new Hurtbox(x,y+140,width/2,height-160);
        this.hurtbox2= new Hurtbox(x+(width/2),y+20,width/2,height-40);
        this.hp=1600;
    }
    
    public Hurtbox getHurtbox2(){
        return hurtbox2;
    }
    
    public void damage(int owch) {
        hp -=owch;
    }
    
    public void chase(int playerx,int playery, boolean chasing){
        if(chasing){
            totalFrames=7;
            if(playerx<(x+width/2)){
                x-=2;
                hurtbox1.changeX(-2);
                hurtbox2.changeX(-2);
                flipHurtbox(false);
                row=2;
            }
            if(playerx+64>(x+width/2)){
                x += 2;
                hurtbox1.changeX(2);
                hurtbox2.changeX(2);
                flipHurtbox(true);
                row=3;
            }
            if(playery<y){
                y -= 2;
                hurtbox1.changeY(-2);
                hurtbox2.changeY(-2);
            }
            if((playery+100)>(y+height)){
                y += 2;
                hurtbox1.changeY(2);
                hurtbox2.changeY(2);
            }
        }else{
            if(playerx<(x+width/2)){
                flipHurtbox(false);
                row=0;
            }
            if(playerx+64>(x+width/2)){
                flipHurtbox(true);
                row=1;
            }
        }
    }
    
    public void flipHurtbox(boolean direction){
        if(direction){
            hurtbox1.setX(x);
            hurtbox2.setX(x+(width/2));
        }else{
            hurtbox1.setX(x+(width/2));
            hurtbox2.setX(x);
        }
    }
    
    public void draw() {
        sx = currentFrame * width;
        sy = row * height;

        if (delay == 0) {
            currentFrame=(currentFrame+1)%totalFrames;
        }
        delay = (delay + 1) % 5;
        hurtbox1.draw(app);
        hurtbox2.draw(app);
        app.copy(image, sx, sy, width, height, x, y, width, height);
        app.fill(255);
        app.strokeWeight(5);
        app.stroke(0);
        app.rect( x, y+50,400,10,5);
        app.fill(255,0,0);
        app.rect( x, y+50,hp/4,10,5);
    }
}
