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
    public void run2(){
        if (animator != null) {
            animator.setImageNames(runRight);
        }
    }
    
    public void stop(){
        if (animator != null) {
            animator.setImageNames(standLeft);
        }
    }    
    public void stop2(){
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
    private static String RUN_LEFT_01 = "RUN_LEFT_01";
    private static String RUN_LEFT_02 = "RUN_LEFT_02";
    private static String RUN_LEFT_03 = "RUN_LEFT_03";
    private static String RUN_LEFT_04 = "RUN_LEFT_04";
    private static String RUN_LEFT_05 = "RUN_LEFT_05";
    private static String RUN_LEFT_06 = "RUN_LEFT_06";
    private static String RUN_LEFT_07 = "RUN_LEFT_07";

    private static String STAND_RIGHT = "STAND_RIGHT";    
    private static String RUN_RIGHT_01 = "RUN_Right_01";
    private static String RUN_RIGHT_02 = "RUN_Right_02";
    private static String RUN_RIGHT_03 = "RUN_Right_03";
    private static String RUN_RIGHT_04 = "RUN_Right_04";
    private static String RUN_RIGHT_05 = "RUN_Right_05";
    private static String RUN_RIGHT_06 = "RUN_Right_06";
    private static String RUN_RIGHT_07 = "RUN_Right_07";
    
    
    private final static ArrayList<String> standLeft = new ArrayList<>();
    private final static ArrayList<String> standRight = new ArrayList<>();
    private final static ArrayList<String> runLeft = new ArrayList<>();
    private final static ArrayList<String> runRight = new ArrayList<>();
    
    private void loadImages() {
        standLeft.add(STAND_LEFT);
        standRight.add(STAND_RIGHT);
        runRight.add(RUN_RIGHT_01);
        runRight.add(RUN_RIGHT_02);
        runRight.add(RUN_RIGHT_03);
        runRight.add(RUN_RIGHT_04);
        runRight.add(RUN_RIGHT_05);
        runRight.add(RUN_RIGHT_06);
        runRight.add(RUN_RIGHT_07);
        runLeft.add(RUN_LEFT_01);
        runLeft.add(RUN_LEFT_02);
        runLeft.add(RUN_LEFT_03);
        runLeft.add(RUN_LEFT_04);
        runLeft.add(RUN_LEFT_05);
        runLeft.add(RUN_LEFT_06);
        runLeft.add(RUN_LEFT_07);
        
        
        String[] imageNames = {STAND_RIGHT, RUN_RIGHT_01, RUN_RIGHT_02, 
                               RUN_RIGHT_03, RUN_RIGHT_04, RUN_RIGHT_05, RUN_RIGHT_06,
                               RUN_RIGHT_07, STAND_LEFT, RUN_LEFT_01,RUN_LEFT_02,RUN_LEFT_03,
                               RUN_LEFT_04,RUN_LEFT_05,RUN_LEFT_06,RUN_LEFT_07};
        Image[] images = new Image[16];
        images[0] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_stand_right.jpg");
        images[1] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run01_right.jpg");
        images[2] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run02_right.jpg");
        images[3] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run03_right.jpg");
        images[4] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run04_right.jpg");
        images[5] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run05_right.jpg");
        images[6] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run06_right.jpg");
        images[7] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run07_right.jpg");
        images[8] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_stand_left.jpg");
        images[9] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run01_left.jpg");
        images[10] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run02_left.jpg");
        images[11] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run03_left.jpg");
        images[12] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run04_left.jpg");
        images[13] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run05_left.jpg");
        images[14] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run06_left.jpg");
        images[15] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run07_left.jpg");


        
        ImageManager imageManager = new ImageManager(imageNames, images);
        
        animator = new Animator(imageManager, standLeft, 200);
        
        if (type == SoldierType.GREEN){
            this.image = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_stand_right.jpg");
        } else {
            this.image = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_stand_left.jpg");
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
