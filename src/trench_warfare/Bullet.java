/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trench_warfare;

import images.Animator;
import images.ImageManager;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author BBC132
 */
public class Bullet {

    private int x;
    private int y;
    private SoldierState state = SoldierState.STAND_RIGHT;
    private SoldierType type;
    private Image image;
    private Animator animator;


    public Bullet(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics graphics){

        
        graphics.drawImage(image, getX(), getY(), null);
        
    }

    public void move(){
       this.x = x + 10;
       
    }
    
//<editor-fold defaultstate="collapsed" desc="Property">
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    
    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
    
    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    
    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }
    
    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }
//</editor-fold>
}