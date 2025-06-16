/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating;

/**
 *
 * @author 343469953
 */
//Importing
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PApplet;

public class MySketch extends PApplet {
    // Declaring global variables
    private int screen = 1;
    private int count = 0;
    private String[] directions = new String[3];
    public static int delay = 0;
    public Player player;
    private HpBar hp;
    public Nian nian;
    public static boolean chasing = true;
    private Projectile projectile;
    private int firingDuration = 0;
    private PowerUps power;
    private boolean effect = false;
    private String effectImage;
    private int effectTimer = 0;
    private int effectDuration = 0;
    private Stars[] stars = new Stars[5];
    PImage startScreen;
    PImage bg;
    PImage bgTop;
    
    /**
     * Sets the screen size and loads images
     */
    public void settings() {
        size(1000, 1000);
        startScreen = loadImage("images/startScreen.png");
        bg = loadImage("images/background.png");
        bgTop = loadImage("images/backgroundTop.png");
    }//End method
    
    /*
    *Instaniating objecting and getting data from txt file
    */
    public void setup() {
        background(255);
        //Getting data from txt file
        try {
            Scanner fileInput = new Scanner(new File("directions.txt"));
            while (fileInput.hasNextLine()) {
                directions[count] = fileInput.nextLine();
                count++;
            }
            fileInput.close();
        } catch (IOException e) {
            System.out.println(e);
        }//End try catch
        
        //Instaniating objecting
        player = new Player(this, 468, 605, "images/player.png");
        nian = new Nian(this, 323, 50, "images/nian.png");
        hp = new HpBar(this, 60, 10, 100);
        power = new PowerUps(this, -100, -100, "images/powerups.png");
        projectile = new Projectile(this, 0, 0, 80, 80);
        //Intanting 5 Stars objects
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Stars(this, 275 + 100 * i, 575, "images/star.png");
        }//End loop
    }//End method
    /*
    *Draws everything in the window
    */
    public void draw() {
        //First screen
        if (screen == 1) {
            background(startScreen);
            textSize(128);
            text("Legend of Nian", 100, 350);
            textSize(64);
            text("Press Enter to Start", 250, 500);
            //Getting input to change screens
            if (keyPressed) {
                if (key == ENTER) {
                    screen = 2;
                }//End if
            }//End if
            //second screen
        } else if (screen == 2) {
            background(bg);
            fill(0, 0, 0, 100);
            rect(0, 0, 1000, 1000);
            fill(255);
            text(directions[0], 100, 250);
            text(directions[1], 175, 325);
            text(directions[2], 250, 400);
            text("Press Enter to Start", 275, 550);
            delay++;
            //Getting input to change screens
            if (keyPressed && delay > 100) {
                if (key == ENTER) {
                    screen = 3;
                }//End if
            }//End if
          //Winning screen
        } else if (nian.getHp() <= 0) {
            background(255);
            fill(0);
            textSize(128);
            text("You Win", 100, 250);
            textSize(64);
            text("You scared off Nian", 175, 325);
            //rating the game method
            rate();
            //Losing Screen
        } else if (hp.getHp() <= 0) {
            background(255);
            fill(0);
            textSize(128);
            text("You Lose", 100, 250);
            textSize(64);
            text("You got eaten by Nian", 175, 325);
            //rating the game method
            rate();
            //Main game sreen
        } else if (screen == 3) {
            background(bg);
            textSize(20);
            power.draw();
            //Drawing the lower one on top
            if (nian.getY() + nian.getHeight() > player.getY() + player.getHeight()) {
                player.draw();
                nian.draw();
            } else {
                nian.draw();
                player.draw();
            }
            //Boss movment
            nian.chase(player.getX(), player.getY(), chasing);
            
            //Top of roofs
            image(bgTop, 0, 0);
            
            //Hp bar
            hp.draw();
            
            //player movment
            if (keyPressed) {
                if (keyCode == LEFT) {
                    player.move(-5, 0);
                } else if (keyCode == RIGHT) {
                    player.move(5, 0);
                } else if (keyCode == UP) {
                    player.move(0, -5);
                } else if (keyCode == DOWN) {
                    player.move(0, 5);
                }
            } else {
                player.move(0, 0);
            }//End if
            
            //power ups
            if (effect) {
                powerupEffect();
            }//End if
            
            //Boss firing projectiles
            fire();
            
            //Colllision 
            collide();
        }//End if
    }//End method
    /*
    *Method to check if the Player object is colliding with GameObj
    */
    public void collide() {
        GameObj[][] gameobj = {{nian.getHurtbox(), projectile}, {power}};
        //Looping throught 2d array
        for (int i = 0; i < gameobj.length; i++) {
            for (int j = 0; j < gameobj[i].length; j++) {
                if (player.isCollidingWith(gameobj[i][j])) {
                    if (i == 0) {
                        if (gameobj[i][j] instanceof Hurtbox) {
                            //Taking damage
                            hp.damage(20);
                        } else {
                            hp.damage(9);
                        }
                    }else{
                        //Calling powerup method
                        powerup();
                    }
                }
            }
        }
    }//End method
    
    /*
    *Method to spawn powerups and the effects of each one
    */
    public void powerup() {
        power.setX(-100);
        power.setY(-100);
        //healing power up
        if (power.getSx() == 0) {
            hp.heal();
            effectImage = "images/healing.png";
            effect = true;
            effectDuration = 50;
            
            //Red paint power up
        } else if (power.getSx() == 64) {
            player.setImage("images/red.png");
            effectImage = "red";
            effect = true;
            effectDuration = 500;
            
            //Explosion power up
        } else if (power.getSx() == 128) {
            nian.damage(480);
            effectImage = "images/explosion.png";
            effect = true;
            effectDuration = 10;
            
            //Fire power up
        } else if (power.getSx() == 192) {
            effectImage = "images/fire.png";
            effect = true;
            effectDuration = 64;
        }
    }//End method
    /*
    *Method for the visial effects of the powerups
    */
    public void powerupEffect() {
        if (effectTimer < effectDuration) {
            //Explosion power up
            if (effectImage.equals("images/explosion.png")) {
                tint(255, 126);
                image(loadImage(effectImage), nian.getX() - 90, nian.getY() - 100);
                
                //Red paint power up
            } else if (effectImage.equals("red")) {
                HpBar.dmg = 0;
                
                //healing power up
            } else if (effectImage.equals("images/healing.png")) {
                image(loadImage(effectImage), player.getX(), player.getY());
                
                //Fire power up
            } else if (effectImage.equals("images/fire.png")) {
                nian.damage(4);
                tint(255, 126);
                image(loadImage(effectImage), nian.getX() - 90, nian.getY() - 90);
            }
            effectTimer++;
        } else {
            //When the effect duration is over
            player.setImage("images/player.png");
            HpBar.dmg = 10;
            effectTimer = 0;
            effect = false;
        }//End if
    }//End method
    /*
    *Method for the boss shooting projectiles
    */
    public void fire() {
        if (delay == 0) {
            chasing = false;
            //firing projectiles when delay is over
            if (firingDuration < 500) {
                projectile.draw();
                //Reseting projectile
                if (firingDuration % 50 == 0) {
                    //projectile target position
                    projectile.setTargetX(player.getX() + 32);
                    projectile.setTargetY(player.getY() + 32);
                    
                    //projectile start position
                    if (player.getX() < (nian.getX() + nian.getWidth() / 2)) {
                        projectile.setX(nian.getX());
                    } else {
                        projectile.setX(nian.getX() + nian.getWidth());
                    }
                    projectile.setY(nian.getY() + (nian.getHeight() / 2));
                    
                    //Projectile movment
                    projectile.change();
                }
                firingDuration++;
            } else {
                //When duration is over
                delay = round(random(300, 400));
                chasing = true;
                firingDuration = 0;
            }
        } else {
            delay--;
        }
    }//End method
    
    /*
    *display rating game section
    */
    public void rate() {
        text("Rate the game", 325, 550);
        for (int i = 0; i < stars.length; i++) {
            stars[i].draw();
        }//ENd if
    }//End method
    
    /*
    *Gets the rating the user clicked and storing it in a file
    */
    @Override
    public void mousePressed() {
        if (nian.getHp() <= 0 || hp.getHp() <= 0) {
            //Checking for every star
            for (int i = 0; i < stars.length; i++) {
                if (stars[i].isClicked(mouseX, mouseY)) {
                    //Colors the stars yellow
                    for (int j = 0; j <= i; j++) {
                        stars[j].setStarColor(255, 255, 0);
                    }//End loop
                    
                    //Storing rating in a file
                    try {
                        FileWriter w = new FileWriter("rating.txt", true);
                        w.write((i+1)+" stars");
                        w.write(" ");
                        w.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                    }//End try catch
                }//End if
            }//End loop
        }//End if
    }//End method
}//end class
