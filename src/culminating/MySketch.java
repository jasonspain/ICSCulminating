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
import processing.core.PApplet;

public class MySketch extends PApplet {
  private Player player; 
  PImage bg;
  PImage bgTop;
  
  public void settings() {
    size(1000, 1000);
    bg = loadImage("images/background.png");
    bgTop = loadImage("images/backgroundTop.png");
  }
  public void setup() {
    background(255);
    textSize(20);
    player = new Player(this,100,100,"images/player.png");
  } 
  public void draw() {
    background(bg);
    player.draw();
    image(bgTop,0,0);
    player.displayInfo(this);
    
    if (keyPressed) {
          if (keyCode == LEFT) {
              player.move(-5, 0);
          }
          if (keyCode == RIGHT) {
              player.move(5, 0);
          }
          if (keyCode == UP) {
              player.move(0, -5);
          } 
          if (keyCode == DOWN) {
              player.move(0, 5);
          }
     }else{
        player.move(0, 0);
    }
  }
}//end class