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
public class Soldier {

    private int x, y;
    private SoldierState state = SoldierState.STAND_RIGHT;
    private SoldierType type;
    private Image image;
    private Animator animator;


    public Soldier(int x, int y, SoldierType type) {
        this.x = x;
        this.y = y;

        this.type = type;
        loadImages();
    }
    
    public void run(){
        if (animator != null) {
            animator.setImageNames(runLeft);
        }
    }
    
    public void stop(){
        if (animator != null) {
            animator.setImageNames(standRight);
        }
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

    private static String STAND_LEFT = "STAND_LEFT";
    private static String STAND_RIGHT = "STAND_RIGHT";
    private static String RUN_LEFT_01 = "RUN_LEFT_01";
    private static String RUN_LEFT_02 = "RUN_LEFT_02";
    
    private final static ArrayList<String> standLeft = new ArrayList<>();
    private final static ArrayList<String> standRight = new ArrayList<>();
    private final static ArrayList<String> runLeft = new ArrayList<>();
    
    private void loadImages() {
        standLeft.add(STAND_LEFT);
        standRight.add(STAND_RIGHT);
        runLeft.add(RUN_LEFT_01);
        runLeft.add(RUN_LEFT_02);
        
        
        String[] imageNames = {STAND_LEFT, STAND_RIGHT, RUN_LEFT_01, RUN_LEFT_02};
        Image[] images = new Image[4];
        images[0] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_stand_left.gif");
        images[1] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_stand_right.gif");
        images[2] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_run01_left.gif");
        images[3] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_run02_left.gif");
        
        ImageManager imageManager = new ImageManager(imageNames, images);
        
        animator = new Animator(imageManager, standLeft, 200);
        
        if (type == SoldierType.GREEN){
            this.image = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_stand_right.gif");
        } else {
            this.image = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_stand_left.gif");
        }
    }

    private Image getImage() {
        if (animator != null) {
            return animator.getCurrentImage();
        } else {
            System.out.println("OUCH - Animator is broken!!!");
            return image;
        }
        
    }

}
