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
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author BBC132
 */
public class Soldier {

    private int x;
    private int y;
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

    public Point getCenterOfMass() {
        return new Point(getX() + (image.getWidth(null) / 2), getY() + (image.getHeight(null)/ 2));
    }
//<editor-fold defaultstate="collapsed" desc="Moving Animator">

    public void runLeft() {
        
        setState(SoldierState.RUN_LEFT);
//        if (animator != null) {
//            animator.setImageNames(runLeft);
//        }
    }

    public void runRight() {
        setState(SoldierState.RUN_RIGHT);
    }

    public void runUP() {
        setState(SoldierState.RUN_RIGHT);
    }

    public void runDOWN() {
        setState(SoldierState.RUN_DOWN);
    }

    public void stopLeft() {
        setState(SoldierState.STAND_LEFT);

    }

    public void stopRight() {
        setState(SoldierState.STAND_RIGHT);

    }

    public void draw(Graphics graphics) {
        if (getType() == SoldierType.GREEN) {
            graphics.setColor(Color.GREEN);
        } else {
            graphics.setColor(Color.RED);
        }

        graphics.drawRect(getX(), getY(), 100, 100);

        graphics.drawImage(getImage(), getX(), getY(), null);
        graphics.fillOval(getCenterOfMass().x, getCenterOfMass().y, 10, 10);
//        graphics.fillOval(getX() + 50, getY() + 50, 10, 10);
    }

//    LEFT OFF HERE
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
    private final static ArrayList<String> runUP = new ArrayList<>();
    private final static ArrayList<String> runDOWN = new ArrayList<>();

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
        runUP.add(RUN_RIGHT_01);
        runUP.add(RUN_RIGHT_02);
        runUP.add(RUN_RIGHT_03);
        runUP.add(RUN_RIGHT_04);
        runUP.add(RUN_RIGHT_05);
        runUP.add(RUN_RIGHT_06);
        runUP.add(RUN_RIGHT_07);
        runDOWN.add(RUN_RIGHT_01);
        runDOWN.add(RUN_RIGHT_02);
        runDOWN.add(RUN_RIGHT_03);
        runDOWN.add(RUN_RIGHT_04);
        runDOWN.add(RUN_RIGHT_05);
        runDOWN.add(RUN_RIGHT_06);
        runDOWN.add(RUN_RIGHT_07);
        runLeft.add(RUN_LEFT_01);
        runLeft.add(RUN_LEFT_02);
        runLeft.add(RUN_LEFT_03);
        runLeft.add(RUN_LEFT_04);
        runLeft.add(RUN_LEFT_05);
        runLeft.add(RUN_LEFT_06);
        runLeft.add(RUN_LEFT_07);

        String[] imageNames = {STAND_RIGHT, RUN_RIGHT_01, RUN_RIGHT_02,
            RUN_RIGHT_03, RUN_RIGHT_04, RUN_RIGHT_05, RUN_RIGHT_06,
            RUN_RIGHT_07, STAND_LEFT, RUN_LEFT_01, RUN_LEFT_02, RUN_LEFT_03,
            RUN_LEFT_04, RUN_LEFT_05, RUN_LEFT_06, RUN_LEFT_07};
        Image[] images = new Image[16];
        images[0] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_stand_right.png");
        images[1] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run01_right.png");
        images[2] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run02_right.png");
        images[3] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run03_right.png");
        images[4] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run04_right.png");
        images[5] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run05_right.png");
        images[6] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run06_right.png");
        images[7] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run07_right.png");
        images[8] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_stand_left.png");
        images[9] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run01_left.png");
        images[10] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run02_left.png");
        images[11] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run03_left.png");
        images[12] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run04_left.png");
        images[13] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run05_left.png");
        images[14] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run06_left.png");
        images[15] = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_run07_left.png");

        ImageManager imageManager = new ImageManager(imageNames, images);

        animator = new Animator(imageManager, standLeft, 200);

        if (getType() == SoldierType.GREEN) {
            this.image = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_stand_right.png");
        } else {
            this.image = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_stand_left.png");
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

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="property">
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
     * @return the state
     */
    public SoldierState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(SoldierState state) {
        if (this.state != state) {
            this.state = state;

            if (animator != null) {
                if (state == SoldierState.RUN_RIGHT) {
                    animator.setImageNames(runRight);
                } else if (state == SoldierState.RUN_LEFT) {
                    animator.setImageNames(runLeft);
                } else if (state == SoldierState.STAND_LEFT) {
                    animator.setImageNames(standLeft);
                } else if (state == SoldierState.STAND_RIGHT) {
                    animator.setImageNames(standRight);
                } else if (state == SoldierState.RUN_DOWN) {
                    animator.setImageNames(runRight);
                } else if (state == SoldierState.RUN_UP) {
                    animator.setImageNames(runRight);
                }

            }

        }

    }

    /**
     * @return the type
     */
    public SoldierType getType() {
        return type;
    }

}
//</editor-fold>
