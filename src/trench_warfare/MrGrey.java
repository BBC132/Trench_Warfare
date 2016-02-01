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
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author BBC132
 */
public class MrGrey {

    ArrayList<Bullet> bullets;
    private int x;
    private int y;
    private SoldierState state = SoldierState.RUN_LEFT;
    private SoldierType type;
    private Image image;
    private Animator animator;

    {
        state = SoldierState.RUN_LEFT;
        x = 0;
        y = 0;
    }

    public MrGrey(int x, int y, SoldierType type) {
        this.x = x;
        this.y = y;

        this.type = type;
        loadImages();
    }

    public void draw(Graphics graphics) {
        if (getType() == SoldierType.GREEN) {
            graphics.setColor(Color.GREEN);
        } else {
            graphics.setColor(Color.RED);
        }

        graphics.drawRect(x, y, 60, 90);

        graphics.drawImage(getImage(), getX(), getY(), null);
        graphics.fillOval(getCenterOfMass().x, getCenterOfMass().y, 10, 10);
//        graphics.fillOval(getX() + 50, getY() + 50, 10, 10);
    }

    public Point getCenterOfMass() {
        return new Point(getX() + (getImage().getWidth(null) / 2), getY() + (getImage().getHeight(null) / 2));
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

    public void deadLeft() {
        setState(SoldierState.DEAD_LEFT);
    }

    public Rectangle rectangle() {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
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

    private static String DEADTH_LEFT = "Death_Left";
    private static String DEADTH_LEFT_01 = "Death_Left_01";
    private static String DEADTH_LEFT_02 = "Death_Left_02";
    private static String DEADTH_LEFT_03 = "Death_Left_03";
    private static String DEADTH_LEFT_04 = "Death_Left_04";
    private static String DEADTH_LEFT_05 = "Death_Left_05";
    private static String DEADTH_LEFT_06 = "Death_Left_06";
    private static String DEADTH_LEFT_07 = "Death_Left_07";
    private static String DEADTH_LEFT_08 = "Death_Left_08";
    private static String DEADTH_LEFT_09 = "Death_Left_09";
    private static String DEADTH_LEFT_10 = "Death_Left_10";
    private static String DEADTH_LEFT_11 = "Death_Left_11";
    private static String DEADTH_LEFT_12 = "Death_Left_12";
    private static String DEADTH_LEFT_13 = "Death_Left_13";
    private static String DEADTH_LEFT_14 = "Death_Left_14";
    private static String DEADTH_LEFT_15 = "Death_Left_15";
    private static String DEADTH_LEFT_16 = "Death_Left_16";
    private static String DEADTH_LEFT_17 = "Death_Left_17";
    private static String DEADTH_LEFT_18 = "Death_Left_18";
    private static String DEADTH_LEFT_19 = "Death_Left_19";
    private static String DEADTH_LEFT_20 = "Death_Left_20";
    private static String DEADTH_LEFT_21 = "Death_Left_21";
    private static String DEADTH_LEFT_22 = "Death_Left_22";
    private static String DEADTH_LEFT_23 = "Death_Left_23";
    private static String DEADTH_LEFT_24 = "Death_Left_24";
    private static String DEADTH_LEFT_25 = "Death_Left_25";
    private static String DEADTH_LEFT_26 = "Death_Left_26";
    private static String DEADTH_LEFT_27 = "Death_Left_27";

    private final static ArrayList<String> standLeft = new ArrayList<>();
    private final static ArrayList<String> standRight = new ArrayList<>();
    private final static ArrayList<String> runLeft = new ArrayList<>();
    private final static ArrayList<String> runRight = new ArrayList<>();
    private final static ArrayList<String> runUP = new ArrayList<>();
    private final static ArrayList<String> runDOWN = new ArrayList<>();
    private final static ArrayList<String> deadLeft = new ArrayList<>();

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

        deadLeft.add(DEADTH_LEFT);
        deadLeft.add(DEADTH_LEFT_01);
        deadLeft.add(DEADTH_LEFT_02);
        deadLeft.add(DEADTH_LEFT_03);
        deadLeft.add(DEADTH_LEFT_04);
        deadLeft.add(DEADTH_LEFT_05);
        deadLeft.add(DEADTH_LEFT_06);
        deadLeft.add(DEADTH_LEFT_07);
        deadLeft.add(DEADTH_LEFT_08);
        deadLeft.add(DEADTH_LEFT_09);
        deadLeft.add(DEADTH_LEFT_10);
        deadLeft.add(DEADTH_LEFT_11);
        deadLeft.add(DEADTH_LEFT_12);
        deadLeft.add(DEADTH_LEFT_13);
        deadLeft.add(DEADTH_LEFT_14);
        deadLeft.add(DEADTH_LEFT_15);
        deadLeft.add(DEADTH_LEFT_16);
        deadLeft.add(DEADTH_LEFT_17);
        deadLeft.add(DEADTH_LEFT_18);
        deadLeft.add(DEADTH_LEFT_19);
        deadLeft.add(DEADTH_LEFT_20);
        deadLeft.add(DEADTH_LEFT_21);
        deadLeft.add(DEADTH_LEFT_22);
        deadLeft.add(DEADTH_LEFT_23);
        deadLeft.add(DEADTH_LEFT_24);
        deadLeft.add(DEADTH_LEFT_25);
        deadLeft.add(DEADTH_LEFT_26);
        deadLeft.add(DEADTH_LEFT_27);

        String[] imageNames = {STAND_RIGHT, RUN_RIGHT_01, RUN_RIGHT_02,
            RUN_RIGHT_03, RUN_RIGHT_04, RUN_RIGHT_05, RUN_RIGHT_06,
            RUN_RIGHT_07, STAND_LEFT, RUN_LEFT_01, RUN_LEFT_02, RUN_LEFT_03,
            RUN_LEFT_04, RUN_LEFT_05, RUN_LEFT_06, RUN_LEFT_07, DEADTH_LEFT,
            DEADTH_LEFT_01, DEADTH_LEFT_02,
            DEADTH_LEFT_03, DEADTH_LEFT_04, DEADTH_LEFT_05, DEADTH_LEFT_06,
            DEADTH_LEFT_07, DEADTH_LEFT_08, DEADTH_LEFT_09, DEADTH_LEFT_10, DEADTH_LEFT_11,
            DEADTH_LEFT_12, DEADTH_LEFT_13, DEADTH_LEFT_14, DEADTH_LEFT_15, DEADTH_LEFT_16,
            DEADTH_LEFT_17, DEADTH_LEFT_18, DEADTH_LEFT_19, DEADTH_LEFT_20, DEADTH_LEFT_21,
            DEADTH_LEFT_22, DEADTH_LEFT_23, DEADTH_LEFT_24, DEADTH_LEFT_25, DEADTH_LEFT_26,
            DEADTH_LEFT_27};
        Image[] images = new Image[44];
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
        images[16] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead01_left.png");
        images[17] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead02_left.png");
        images[18] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead03_left.png");
        images[19] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead04_left.png");
        images[20] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead05_left.png");
        images[21] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead06_left.png");
        images[22] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead07_left.png");
        images[23] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead08_left.png");
        images[24] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead09_left.png");
        images[25] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead10_left.png");
        images[26] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead11_left.png");
        images[27] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead12_left.png");
        images[28] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead13_left.png");
        images[29] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead14_left.png");
        images[30] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead15_left.png");
        images[31] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead16_left.png");
        images[32] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead17_left.png");
        images[33] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead18_left.png");
        images[34] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead19_left.png");
        images[35] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead20_left.png");
        images[36] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead21_left.png");
        images[37] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead22_left.png");
        images[38] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead23_left.png");
        images[39] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead24_left.png");
        images[40] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead25_left.png");
        images[41] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead26_left.png");
        images[42] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead27_left.png");
        images[43] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_dead28_left.png");

        ImageManager imageManager = new ImageManager(imageNames, images);

        animator = new Animator(imageManager, standLeft, 200);

    }

    private Image getImage() {
        if (animator != null) {
            return animator.getCurrentImage();
        } else {
            System.out.println("OUCH - Animator is broken!!!");

            if (image == null) {
                if (getType() == SoldierType.GREY) {
                    this.image = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_stand_right.png");
                } else {
                    this.image = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_stand_left.png");
                }
            }
            return image;
        }

    }
//</editor-fold>

//    
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
                if (getType() == SoldierType.GREEN) {
                    
                }if (getType() == SoldierType.GREY) {
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
                } else if (state == SoldierState.DEAD_LEFT) {
                    animator.setImageNames(deadLeft);
                } else {
                    animator.setImageNames(runRight);
                    System.out.println(state);
                }
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

