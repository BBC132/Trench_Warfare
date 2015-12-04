/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trench_warfare;

import environment.Environment;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author BBC132
 */
class SoldierMechanics extends Environment {

    int xSoldier = 100;
    int ySoldier = 100;
    int x2s;
    Soldier mrGreen, mrGrey;
    private ArrayList<Bullet> bullet;
    Image bulletType;

    
    
//    new greenSoilder(350, 10, 180, 180);
    @Override
    public void initializeEnvironment() {
        bulletType = ResourceTools.loadImageFromResource("Trench_Warfare/Bullet.png");

//        greenSoilder = ResourceTools.loadImageFromResource("Trench_Warfare/Green soilder.gif");
        mrGreen = new Soldier(xSoldier, ySoldier, SoldierType.GREEN);
        mrGrey = new Soldier(400, 400, SoldierType.GREY);
        bullet = new ArrayList<>();
        
        
        
    }
    Image greenSoilder;

    @Override
    public void timerTaskHandler() {
        if (bullet != null) {
            for (Bullet bullet : bullet) {
                bullet.move();
                
            }
           
        }
    }
    int moveSpeed = 15;
    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mrGreen.setX(mrGreen.getX() - moveSpeed);
            mrGreen.runLeft();
            
        } else  if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mrGreen.setX(mrGreen.getX() + moveSpeed);
            mrGreen.runRight();
        } else  if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            mrGreen.setY(mrGreen.getY() + moveSpeed);
            mrGreen.runRight();
        } else  if (e.getKeyCode() == KeyEvent.VK_UP) {
            mrGreen.setY(mrGreen.getY() - moveSpeed);
            mrGreen.runUP();
        } 
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bullet.add(new Bullet(bulletType, mrGreen.getX(),mrGreen.getY() ));
        }

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mrGreen.stopLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mrGreen.stopRight();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            mrGreen.stopRight();
        } else if (e.getKeyCode() == KeyEvent.VK_UP)
            mrGreen.stopRight();
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {

    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (mrGreen != null) {
            mrGreen.draw(graphics);
            
        }
        if (bullet != null) {
            for (Bullet bullet : bullet) {
                bullet.draw(graphics);
                
            }
        }
        if (mrGrey != null) {
            mrGrey.draw(graphics);
            
            
        }
       graphics.drawRect(0,0, 1439,768);
    }
    
    

}
