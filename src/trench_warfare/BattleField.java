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
    MrGreen mrGreen;
    MrGrey mrGrey;
    private ArrayList<Bullet> bullets;
    private ArrayList<Trench> trenchs;
    private ArrayList<Mines> mines;
    private ArrayList<MrGrey> mrGreys;
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
    private ArrayList<Item> items;

//    new greenSoilder(350, 10, 180, 180);
    @Override
    public void initializeEnvironment() {
        backGround = ResourceTools.loadImageFromResource("Trench_Warfare/BattleGround1.png");
        backGround = ResourceTools.loadImageFromResource("Trench_Warfare/BattleGround1.png");
        grid = new Grid(10, 6, 145, 145, new Point(0, 0), Color.black);
        bulletType = ResourceTools.loadImageFromResource("Trench_Warfare/Bullet.png");
//        greenSoilder = ResourceTools.loadImageFromResource("Trench_Warfare/Green soilder.gif");
        mrGreen = new MrGreen(collum1X, collum1Y, SoldierType.GREEN);
        mrGrey = new MrGrey(800, 400, SoldierType.GREY);
        trench1 = ResourceTools.loadImageFromResource("Trench_Warfare/Trench1.png");
        trenchs = new ArrayList<>();
        bullets = new ArrayList<>();
        mines = new ArrayList<>();
        mrGreys = new ArrayList<>();
        items = new ArrayList<>();
//        items.add(new Item(4, 5, true, Item.ITEMS_TYPE_FLAMETHROWER, this, this));
        mrGreys.add(mrGrey);

    }

    @Override
    public void timerTaskHandler() {

        if (bullets != null) {
            for (Bullet bullet : bullets) {
                bullet.move();
                this.validateMove(bullet.getCenterOfMass());

            }
        }
        shot();

        if (mrGreys != null) {
            if (moveDelay >= moveDelayLimit) {
//                mrGrey.setX(mrGrey.getX() + moveSpeed); 
//                mrGrey.runRight();
                moveDelay = 0;

            } else {
                moveDelay++;
            }

        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mrGreen.runLeft();
            mrGreen.move();
            this.validateMove(mrGreen.getCenterOfMass());
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mrGreen.runRight();
            mrGreen.move();
            this.validateMove(mrGreen.getCenterOfMass());
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            mrGreen.runDOWN();
            mrGreen.move();
            this.validateMove(mrGreen.getCenterOfMass());
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            mrGreen.runUP();
            mrGreen.move();
            this.validateMove(mrGreen.getCenterOfMass());
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            AudioPlayer.play("/trench_warfare/RifleShooting.wav");
            bullets.add(new Bullet(bulletType, mrGreen.getX() - 50, mrGreen.getY() - 10));
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
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            mrGreen.stopRight();
        }

    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
        System.out.println("mouse click at system point " + e.getPoint());
        System.out.println("mouse click in cell grid " + grid.getCellCoordinateFromSystemCoordinate(e.getPoint()));
        System.out.println("mouse click in cell " + grid.getCellLocationFromSystemCoordinate(e.getPoint()));
        System.out.println("");
//        trenchs.add(new Trench(grid.getCellCoordinateFromSystemCoordinate(e.getPoint()), trench1, this));
        mines.add(new Mines(grid.getCellCoordinateFromSystemCoordinate(e.getPoint()), mine, this));
//                if (mines != null){
//            mines.setX(e.getX());
//            mines.setY(e.getY());
//    }
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

        if (bullets != null) {
            for (Bullet bullet : bullets) {
                bullet.draw(graphics);

            }
        }
        if (mrGrey != null) {
            mrGrey.draw(graphics);

        }
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
        //check if that grid cell contains a trench
//        return (gridLocation.equals(trench));
//        return this.trenchs.contains(gridLocation);
        for (Mines mine : mines) {
            if (mine.getLocation().equals(gridLocation)) {
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
                mines.clear();
                System.out.println("ouch");
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

    private void shot() {
        if (mrGrey != null) {
            if (bullets != null) {
                for (Bullet bullet : bullets) {
                    for (MrGrey mrGrey : mrGreys) {
                        if (bullet.rectangle().intersects(mrGrey.rectangle())) {
                            System.out.println("Shot");
                            mrGrey.deadLeft();
                        } else {
                            mrGrey.runLeft();
                        }
                    }
                }
            }
        }
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
