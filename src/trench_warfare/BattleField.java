/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trench_warfare;

import audio.AudioPlayer;
import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author BBC132
 */
class BattleField extends Environment implements CellDataProviderIntf, MoveValidatorIntf {

    int collum1X = 20;
    int collum1Y = 20;
    int x2s;
    Soldier mrGreen, mrGrey;
    private ArrayList<Soldier> soldiers;
    private ArrayList<Bullet> bullets;
    private ArrayList<Trench> trenchs;
    private ArrayList<Mines> mines;
    private ArrayList<Mines> mines2;

    private ArrayList<Soldier> getSoldierCopy() {
        return new ArrayList<>(soldiers);
    }
    Image mine;
    Image mine2;
    Image trench1;
    Image bulletType;
    Image backGround;
    Grid grid;
    int moveSpeed = 55;
    Image greenSoilder;
    int counter;
    double moveDelay = 0;
    double moveDelayLimit = 10;

//    new greenSoilder(350, 10, 180, 180);
    @Override
    public void initializeEnvironment() {
        backGround = ResourceTools.loadImageFromResource("Trench_Warfare/BattleGround1.png");
        backGround = ResourceTools.loadImageFromResource("Trench_Warfare/BattleGround1.png");
        grid = new Grid(10, 6, 145, 145, new Point(0, 0), Color.black);
        bulletType = ResourceTools.loadImageFromResource("Trench_Warfare/Bullet.png");
//        greenSoilder = ResourceTools.loadImageFromResource("Trench_Warfare/Green soilder.gif");
//        mrGreen = new Soldier(collum1X, collum1Y, SoldierType.GREEN);
        mrGrey = new Soldier(400, 400, SoldierType.GREY);
        trench1 = ResourceTools.loadImageFromResource("Trench_Warfare/Trench1.png");
        trenchs = new ArrayList<>();
        soldiers = new ArrayList<>();
        bullets = new ArrayList<>();
        mines = new ArrayList<>();
        mines2 = new ArrayList<>();
    }

    @Override
    public void timerTaskHandler() {
        if (bullets != null) {
            for (Bullet bullet : bullets) {
                bullet.move();
            }
        }
        if (soldiers != null) {
            if (moveDelay >= moveDelayLimit) {
                for (Soldier soldier : soldiers) {
                    soldier.setX(soldier.getX() + moveSpeed);
                    validateMove(soldier.getCenterOfMass());

                }

                moveDelay = 0;

            } else {
                moveDelay++;
            }

        }
    }

    private void explosion() {
        if (soldiers != null) {
            if (mines != null) {
                ArrayList<Soldier> toSoldierRemoves = new ArrayList<>();
                for (Soldier soldier : soldiers) {
                    toSoldierRemoves.add(soldier);
                    soldiers.removeAll(toSoldierRemoves);

                }
            }
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            mrGreen.setX(mrGreen.getX() - moveSpeed);
//            mrGreen.runLeft();
//            this.validateMove(mrGreen.getCenterOfMass());
//
//        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            mrGreen.setX(mrGreen.getX() + moveSpeed);
//            mrGreen.runRight();
//            this.validateMove(mrGreen.getCenterOfMass());
//        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            mrGreen.setY(mrGreen.getY() + moveSpeed);
//            mrGreen.runRight();
//            this.validateMove(mrGreen.getCenterOfMass());
//        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
//            mrGreen.setY(mrGreen.getY() - moveSpeed);
//            mrGreen.runUP();
//            this.validateMove(mrGreen.getCenterOfMass());
//        }
//        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            AudioPlayer.play("/trench_warfare/RifleShooting.wav");
//            bullets.add(new Bullet(bulletType, mrGreen.getX(), mrGreen.getY()));
//        }

    }

    private int random(int value) {
        return (int) (Math.random() * value);
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            mrGreen.stopLeft();
//        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            mrGreen.stopRight();
//        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            mrGreen.stopRight();
//        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
//            mrGreen.stopRight();
//        }
        if (e.getKeyCode() == KeyEvent.VK_1) {
            //clear out the current soldiers
            soldiers.clear();
            for (int i = 0; i < 5; i++) {
                soldiers.add(new Soldier(random(90), random(75), SoldierType.GREEN));
                soldiers.get(i).runRight();
//                mrGreen.runRight();
            }

        }
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
        System.out.println("mouse click at system point " + e.getPoint());
        System.out.println("mouse click in cell grid " + grid.getCellCoordinateFromSystemCoordinate(e.getPoint()));
        System.out.println("mouse click in cell " + grid.getCellLocationFromSystemCoordinate(e.getPoint()));
        System.out.println("");

//        trenchs.add(new Trench(grid.getCellCoordinateFromSystemCoordinate(e.getPoint()), trench1, this));
                if (mines != null){
            mines.setX(e.getX());
            mines.setY(e.getY());
    }
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        graphics.drawImage(backGround, 0, 0, this);

        if (trenchs != null) {
            for (Trench trench : trenchs) {
                trench.draw(graphics);
            }
        }
        if (mines != null) {
            mine = ResourceTools.loadImageFromResource("Trench_Warfare/Mines.png");
            for (Mines mine : mines) {
                mine.draw(graphics);
            }
        }
        if (grid != null) {
            grid.paintComponent(graphics);

//            grid2.paintComponent(graphics);
        }

        if (mrGreen != null) {
            mrGreen.draw(graphics);
        }
        if (soldiers != null) {
            for (Soldier soldier : soldiers) {
                soldier.draw(graphics);
            }
        }

        if (bullets != null) {
            for (Bullet bullet : bullets) {
                bullet.draw(graphics);

            }
        }
        if (mrGrey != null) {
            mrGrey.draw(graphics);

        }
        graphics.drawRect(0, 0, 1438, 850);
    }

    public boolean isInTrench(Point systemLocation) {
        //decode the sysLoc to a grid cell
        Point gridLocation = grid.getCellCoordinateFromSystemCoordinate(systemLocation);
        //check if that grid cell contains a trench
//        return (gridLocation.equals(trench));
//        return this.trenchs.contains(gridLocation);
        for (Trench trench : trenchs) {
            if (trench.getLocation().equals(gridLocation)) {
                return true;
            }
        }
        return false;

    }

    public boolean isInMineField(Point systemLocation) {
        //decode the sysLoc to a grid cell
        Point gridLocation = grid.getCellCoordinateFromSystemCoordinate(systemLocation);
        ArrayList<Mines> toMinesRemove = new ArrayList<>();
        //check if that grid cell contains a trench
//        return (gridLocation.equals(trench));
//        return this.trenchs.contains(gridLocation);
        for (Mines mine : mines) {
            if (mine.getLocation().equals(gridLocation)) {
                toMinesRemove.add(mine);

                return true;

            }
        }

        return false;

    }

    //<editor-fold defaultstate="collapsed" desc="ValidateMove">
    @Override
    public Point validateMove(Point proposedLocation) {
        if (isInTrench(proposedLocation)) {
            moveSpeed = 2;
        } else {
            moveSpeed = 15;
        }
        if (isInMineField(proposedLocation)) {
            if (true) {
//                explosion();
                mines.clear();
                
                System.out.println("ouch");
            }

        } else {
            System.out.println(" he is ok ");
        }

//        if (trench.getLocation().x == mrGreen.getX()) {
//            if (trench.getLocation().y == mrGreen.getY()) {
//                moveSpeed = 5;
//            }
//        } else {
//            System.out.println("!");
//        }
        return proposedLocation;
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="CellDataProviderIntf">
    @Override
    public int getCellWidth() {
        return grid.getCellWidth();
    }

    @Override
    public int getCellHeight() {
        return grid.getCellHeight();
    }

    @Override
    public int getSystemCoordX(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).x;
    }

    @Override
    public int getSystemCoordY(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).y;
    }
//</editor-fold>

}
