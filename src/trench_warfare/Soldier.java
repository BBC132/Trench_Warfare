/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trench_warfare;

import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author BBC132
 */
public class Soldier {

    private int x, y;
    private SoldierState state = SoldierState.STAND_RIGHT;
    private SoldierType type;
    private Image image;

    public Soldier(int x, int y, SoldierType type) {
        this.x = x;
        this.y = y;

        this.type = type;
        loadImages();
    }

    public void draw(Graphics graphics) {
        if (type == SoldierType.GREEN) {
            graphics.setColor(Color.GREEN);
        } else {
            graphics.setColor(Color.RED);
        }
        graphics.drawRect(x, y, 100, 100);
        
        graphics.drawImage(getImage(), x, y, null);
    }

    private void loadImages() {
        
        if (type == SoldierType.GREEN){
            this.image = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_stand_left.gif");
            
        } else {
            this.image = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_stand_right.gif");
        
        }
    }

    private Image getImage() {
        return image; 
    }

}
