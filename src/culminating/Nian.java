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

public class Nian extends GameObj{
    //Variables
    private int currentFrame,totalFrames, sx, sy, row;
    private int delay;
    private int hp;
    private Hurtbox hurtbox;
    
    /*
    *Constructor for Nian obejct
    */
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
        this.hurtbox= new Hurtbox(app,x+(width/2),y+80,width/2,height-80);
        this.hp=1600;
    }
    
    /*
    *getter method
    *@return hp of the Nian obejct
    */
    public int getHp() {
        return hp;
    }
    
    /*
    *getter method
    *@return Hurtbox of the Nian obejct
    */
    public Hurtbox getHurtbox(){
        return hurtbox;
    }
    /*
    *method for when the boss takes damage
    *@param the damage done
    */
    public void damage(int owch) {
        hp -=owch;
    }
    
    /*
    *Method for the boss to move to the players position
    *@param the players x postion
    *@param the players y postion
    *@param a toggle for it chasing
    */
    public void chase(int playerx,int playery, boolean chasing){
        if(chasing){
            totalFrames=7;
            //When player is left
            if(playerx<(x+width/2)){
                moveHurtbox(false);
                row=2;
                if(playerx<x){
                    x -= 2;
                    hurtbox.changeX(-2);
                }
            }
            //When player is right
            if(playerx+64>(x+width/2)){
                moveHurtbox(true);
                row=3;
                if (playerx + 64 > (x + width)){
                    x += 2;
                    hurtbox.changeX(2);
                }
            }
            //When player is on top
            if(playery<(y+height/3)){
                y -= 2;
                hurtbox.changeY(-2);
            }
            //When player is on the bottom
            if((playery+100)>(y+height)){
                y += 2;
                hurtbox.changeY(2);
            }
        }else{
            //Nians sprite when its standing still
            if(playerx<(x+width/2)){
                moveHurtbox(false);
                row=0;
            }
            if(playerx+64>(x+width/2)){
                moveHurtbox(true);
                row=1;
            }
        }
    }
    
    /*
    *Method to flip the hurtbox horizontally
    *@param the direction its facing
    */
    public void moveHurtbox(boolean direction){
        if(direction){
            hurtbox.setX(x+(width/2));
        }else{
            hurtbox.setX(x);
        }
    }
    
    /*
    *Draws the Nian object
    */
    @Override
    public void draw() {
        //Gets the frame in the spritesheet
        sx = currentFrame * width;
        sy = row * height;
        
        //changing frams after a delay
        if (delay == 0) {
            currentFrame=(currentFrame+1)%totalFrames;
        }
        //delay increase and resets after 5
        delay = (delay + 1) % 5;
        
        //Drawing the boss
        hurtbox.draw();
        app.copy(image, sx, sy, width, height, x, y, width, height);
        
        //Boss hp bar
        app.fill(255);
        app.strokeWeight(5);
        app.stroke(0);
        app.rect( x, y+50,400,10,5);
        app.fill(255,0,0);
        app.rect( x, y+50,hp/4,10,5);
    }
}
