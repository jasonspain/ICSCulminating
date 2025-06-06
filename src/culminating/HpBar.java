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
public class HpBar {

    private int x, y;
    private int hp;
    private PApplet app;

    public HpBar(PApplet p, int x, int y, int hp) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.hp = hp;
    }

    public void draw() {
        app.fill(0);
        app.text("HP", x - 40, y + 20);
        app.fill(255);
        app.rect(x, y, 250, 30);
        app.fill(255, 0, 0);
        app.rect(x, y, 10 * hp, 30);

    }
}
