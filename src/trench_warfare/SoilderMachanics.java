/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trench_warfare;

import environment.Environment;
import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author BBC132
 */
class SoilderMachanics extends Environment {
        int x2s;
//    new greenSoilder(350, 10, 180, 180);
        

    @Override
    public void initializeEnvironment() {
        greenSoilder = ResourceTools.loadImageFromResource("Trench_Warfare/Green soilder.gif");
        
    }
        Image greenSoilder;


    @Override
    public void timerTaskHandler() {

    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
//            greenSoilder.setX(x2s = greenSoilder.getX() + 50);         
//	} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            greenSoilder.setX(greenSoilder.getX() - 50);
//        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            greenSoilder.setY(greenSoilder.getY() + 50);
//        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
//            greenSoilder.setY(greenSoilder.getY() - 50);
//        }

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        graphics.drawImage(greenSoilder, x, y, this);



    }
    private int x;
    private int y;
    private int height;
    private int width;
     
}
