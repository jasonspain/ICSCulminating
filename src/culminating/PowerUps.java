/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminating;

import processing.core.PApplet;

/**
 *
 * @author 343469953
 */
public class PowerUps {
    private int x, y;
    private int currentFrame, sx;
    private int delay;
    private PApplet app;
    
    public PowerUps(PApplet p, int x, int y) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.currentFrame = 0;
        this.sx = 0;
        this.delay = 100;
    }
    
}
