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
public class Stars extends GameObj{
    //Variables
    private int r=255;
    private int g=255;
    private int b=255;
    
    /*
    *Constructor for Stars obejct
    */
    public Stars(PApplet p, int x, int y, String imagePath) {
        super(p, x, y, imagePath);
        this.width = 100;
        this.height = 100;
    }
    
    /*
    *Setter method for the color
    *@param the r in rgb
    *@param the g in rgb
    *@param the b in rgb
    */
    public void setStarColor(int r,int g,int b){
        this.r=r;
        this.g=g;
        this.b=b;
    }
    
    /*
    *method to check if the object is clicked
    *param the mouse x position
    *param the mouse y position
    */
    public boolean isClicked(int mouseX,int mouseY){
        int centerX = x +(image.pixelWidth/2);
        int centerY = y + (image.pixelHeight/2);

        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        return d < (image.pixelWidth/2);
    }
    
    //Method to draw the Stars object
    @Override
    public void draw(){
        app.fill(r,g,b);
        app.rect(x, y, 100, 100);
        app.image(image, x, y);
    }
}
