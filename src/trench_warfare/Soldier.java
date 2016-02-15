/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trench_warfare;

import environment.Actor;
import environment.Velocity;
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
public class Soldier extends Actor {

    ArrayList<Bullet> bullets;
    private int x;
    private int y;
    private SoldierState state = SoldierState.RUN_LEFT;
    private SoldierType type;
    private Image image;
    private Animator animator;
    private int speed;

    {
        state = SoldierState.RUN_LEFT;
        x = 0;
        y = 0;
    }

    public Soldier(Point position, SoldierType type) {
        super(position, new Velocity(0, 0));
        speed = 5;
        this.type = type;
        loadImages();
    }

    public void draw(Graphics graphics) {
        if (getType() == SoldierType.GREEN) {
            graphics.setColor(Color.GREEN);
        } else {
            graphics.setColor(Color.RED);
        }

        graphics.drawRect(getPosition().x, getPosition().y, 60, 90);

        graphics.drawImage(getCharacterImage(), getX(), getY(), null);
//        graphics.fillOval(getCenterOfMass().x, getCenterOfMass().y, 10, 10);
    }

    public Point getCenterOfMass() {
        return new Point(getX() + (getCharacterImage().getWidth(null) / 2), getY() + (getCharacterImage().getHeight(null) / 2));
    }

//<editor-fold defaultstate="collapsed" desc="Moving Animator">
    public void runLeft() {
        setState(SoldierState.RUN_LEFT);
    }

    public void runRight() {
        setState(SoldierState.RUN_RIGHT);
    }

    public void runUP() {
        setState(SoldierState.RUN_UP);
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

    public void dead() {
        setState(SoldierState.DEAD);
    }

    public Rectangle rectangle() {
            return new Rectangle(getPosition().x, getPosition().y, getCharacterImage().getWidth(null), getCharacterImage().getHeight(null));
    }

    public boolean isAlive(){
        return ((state != SoldierState.DEAD) && (state != SoldierState.DEAD_LEFT));
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

    private static String STAND_LEFT_GREY = "STAND_LEFT_GREY";
    private static String RUN_LEFT_01_GREY = "STAND_LEFT_01_GREY";
    private static String RUN_LEFT_02_GREY = "STAND_LEFT_02_GREY";
    private static String RUN_LEFT_03_GREY = "STAND_LEFT_03_GREY";
    private static String RUN_LEFT_04_GREY = "STAND_LEFT_04_GREY";
    private static String RUN_LEFT_05_GREY = "STAND_LEFT_05_GREY";
    private static String RUN_LEFT_06_GREY = "STAND_LEFT_06_GREY";
    private static String RUN_LEFT_07_GREY = "STAND_LEFT_07_GREY";

    private static String STAND_RIGHT = "STAND_RIGHT";
    private static String RUN_RIGHT_01 = "RUN_Right_01";
    private static String RUN_RIGHT_02 = "RUN_Right_02";
    private static String RUN_RIGHT_03 = "RUN_Right_03";
    private static String RUN_RIGHT_04 = "RUN_Right_04";
    private static String RUN_RIGHT_05 = "RUN_Right_05";
    private static String RUN_RIGHT_06 = "RUN_Right_06";
    private static String RUN_RIGHT_07 = "RUN_Right_07";

    private static String DEATH_LEFT = "Death_Left";
    private static String DEATH_LEFT_01 = "Death_Left_01";
    private static String DEATH_LEFT_02 = "Death_Left_02";
    private static String DEATH_LEFT_03 = "Death_Left_03";
    private static String DEATH_LEFT_04 = "Death_Left_04";
    private static String DEATH_LEFT_05 = "Death_Left_05";
    private static String DEATH_LEFT_06 = "Death_Left_06";
    private static String DEATH_LEFT_07 = "Death_Left_07";
    private static String DEATH_LEFT_08 = "Death_Left_08";
    private static String DEATH_LEFT_09 = "Death_Left_09";
    private static String DEATH_LEFT_10 = "Death_Left_10";
    private static String DEATH_LEFT_11 = "Death_Left_11";
    private static String DEATH_LEFT_12 = "Death_Left_12";
    private static String DEATH_LEFT_13 = "Death_Left_13";
    private static String DEATH_LEFT_14 = "Death_Left_14";
    private static String DEATH_LEFT_15 = "Death_Left_15";
    private static String DEATH_LEFT_16 = "Death_Left_16";
    private static String DEATH_LEFT_17 = "Death_Left_17";
    private static String DEATH_LEFT_18 = "Death_Left_18";
    private static String DEATH_LEFT_19 = "Death_Left_19";
    private static String DEATH_LEFT_20 = "Death_Left_20";
    private static String DEATH_LEFT_21 = "Death_Left_21";
    private static String DEATH_LEFT_22 = "Death_Left_22";
    private static String DEATH_LEFT_23 = "Death_Left_23";
    private static String DEATH_LEFT_24 = "Death_Left_24";
    private static String DEATH_LEFT_25 = "Death_Left_25";
    private static String DEATH_LEFT_26 = "Death_Left_26";
    private static String DEATH_LEFT_27 = "Death_Left_27";

    private final static ArrayList<String> standLeft = new ArrayList<>();
    private final static ArrayList<String> standRight = new ArrayList<>();
    private final static ArrayList<String> runLeft = new ArrayList<>();
    private final static ArrayList<String> runLeftGrey = new ArrayList<>();
    private final static ArrayList<String> runRight = new ArrayList<>();
    private final static ArrayList<String> runUP = new ArrayList<>();
    private final static ArrayList<String> runDOWN = new ArrayList<>();
    private final static ArrayList<String> deadLeft = new ArrayList<>();
    private final static ArrayList<String> dead = new ArrayList<>();

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

        runLeftGrey.add(RUN_LEFT_01_GREY);
        runLeftGrey.add(RUN_LEFT_02_GREY);
        runLeftGrey.add(RUN_LEFT_03_GREY);
        runLeftGrey.add(RUN_LEFT_04_GREY);
        runLeftGrey.add(RUN_LEFT_05_GREY);
        runLeftGrey.add(RUN_LEFT_06_GREY);
        runLeftGrey.add(RUN_LEFT_07_GREY);

        deadLeft.add(DEATH_LEFT);
        deadLeft.add(DEATH_LEFT_01);
        deadLeft.add(DEATH_LEFT_02);
        deadLeft.add(DEATH_LEFT_03);
        deadLeft.add(DEATH_LEFT_04);
        deadLeft.add(DEATH_LEFT_05);
        deadLeft.add(DEATH_LEFT_06);
        deadLeft.add(DEATH_LEFT_07);
        deadLeft.add(DEATH_LEFT_08);
        deadLeft.add(DEATH_LEFT_09);
        deadLeft.add(DEATH_LEFT_10);
        deadLeft.add(DEATH_LEFT_11);
        deadLeft.add(DEATH_LEFT_12);
        deadLeft.add(DEATH_LEFT_13);
        deadLeft.add(DEATH_LEFT_14);
        deadLeft.add(DEATH_LEFT_15);
        deadLeft.add(DEATH_LEFT_16);
        deadLeft.add(DEATH_LEFT_17);
        deadLeft.add(DEATH_LEFT_18);
        deadLeft.add(DEATH_LEFT_19);
        deadLeft.add(DEATH_LEFT_20);
        deadLeft.add(DEATH_LEFT_21);
        deadLeft.add(DEATH_LEFT_22);
        deadLeft.add(DEATH_LEFT_23);
        deadLeft.add(DEATH_LEFT_24);
        deadLeft.add(DEATH_LEFT_25);
        deadLeft.add(DEATH_LEFT_26);
        deadLeft.add(DEATH_LEFT_27);

        dead.add(DEATH_LEFT_27);

        String[] imageNames = {STAND_RIGHT, RUN_RIGHT_01, RUN_RIGHT_02,
            RUN_RIGHT_03, RUN_RIGHT_04, RUN_RIGHT_05, RUN_RIGHT_06,
            RUN_RIGHT_07, STAND_LEFT, RUN_LEFT_01, RUN_LEFT_02, RUN_LEFT_03,
            RUN_LEFT_04, RUN_LEFT_05, RUN_LEFT_06, RUN_LEFT_07, DEATH_LEFT,
            DEATH_LEFT_01, DEATH_LEFT_02,
            DEATH_LEFT_03, DEATH_LEFT_04, DEATH_LEFT_05, DEATH_LEFT_06,
            DEATH_LEFT_07, DEATH_LEFT_08, DEATH_LEFT_09, DEATH_LEFT_10, DEATH_LEFT_11,
            DEATH_LEFT_12, DEATH_LEFT_13, DEATH_LEFT_14, DEATH_LEFT_15, DEATH_LEFT_16,
            DEATH_LEFT_17, DEATH_LEFT_18, DEATH_LEFT_19, DEATH_LEFT_20, DEATH_LEFT_21,
            DEATH_LEFT_22, DEATH_LEFT_23, DEATH_LEFT_24, DEATH_LEFT_25, DEATH_LEFT_26,
            DEATH_LEFT_27, STAND_LEFT_GREY, RUN_LEFT_01_GREY, RUN_LEFT_02_GREY, RUN_LEFT_03_GREY,
            RUN_LEFT_04_GREY, RUN_LEFT_05_GREY, RUN_LEFT_06_GREY, RUN_LEFT_07_GREY};
        Image[] images = new Image[52];
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
        images[44] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_stand_left.png");
        images[45] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_run01_left.png");
        images[46] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_run02_left.png");
        images[47] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_run03_left.png");
        images[48] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_run04_left.png");
        images[49] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_run05_left.png");
        images[50] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_run06_left.png");
        images[51] = ResourceTools.loadImageFromResource("trench_warfare/soldier_grey_rifle_run07_left.png");
        ImageManager imageManager = new ImageManager(imageNames, images);

        animator = new Animator(imageManager, runLeftGrey, 200);

    }

    private Image getCharacterImage() {
        if (animator != null) {
            if (animator.getCurrentImageName().equals(DEATH_LEFT_27)) {
                setState(SoldierState.DEAD);
            }
            return animator.getCurrentImage();
        } else {
            System.out.println("OUCH - Animator is broken!!!");

            if (image == null) {
//                if (getType() == SoldierType.GREY) {
//                    this.image = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_stand_right.png");
//                } else {
//                    this.image = ResourceTools.loadImageFromResource("trench_warfare/soldier_green_rifle_stand_left.png");
//                }
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
        return getPosition().x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        setPosition(x, getPosition().y);
    }

    /**
     * @return the y
     */
    public int getY() {
        return getPosition().y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        setPosition(getPosition().x, y);
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
                if (getType() == SoldierType.GREY) {
                    if (state == SoldierState.RUN_LEFT) {
                        animator.setImageNames(runLeftGrey);
                    } else if (state == SoldierState.DEAD_LEFT) {
                        animator.setImageNames(deadLeft);
                    } else if (state == SoldierState.DEAD) {
                        animator.setImageNames(dead);
                    } else {
                        animator.setImageNames(runLeftGrey);
//                        System.out.println(state);
                    }
                }
                if (getType() == SoldierType.GREEN) {
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
//                        System.out.println(state);
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

    public void timerTaskHandler() {
        move();
    }

    @Override
    public void move() {
        setVelocity(0, 0);
        if (state == SoldierState.RUN_LEFT) {
            setVelocity(-speed, 0);
        } else if (state == SoldierState.RUN_RIGHT) {
            setVelocity(speed, 0);
        } else if (state == SoldierState.RUN_UP) {
            setVelocity(0, -speed);
        } else if (state == SoldierState.RUN_DOWN) {
            setVelocity(0, speed);
        } else if (state == SoldierState.DEAD_LEFT) {
            setVelocity(0, 0);
        } else if (state == SoldierState.DEAD) {
            setVelocity(0, 0);
        }
        super.move();
    }

}
//</editor-fold>

