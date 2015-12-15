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

    int xSoldier = 100;
    int ySoldier = 100;
    int x2s;
    Soldier mrGreen, mrGrey;
    private ArrayList<Bullet> bullets;
    private ArrayList<Trench> trenchs;
    private ArrayList<Mines> mines;
    Image mine;
    Image mine2;
    Image trench1;
    Image bulletType;
    Image backGround;
    Grid grid;
    int moveSpeed = 55;
    int moveDelay;

//    new greenSoilder(350, 10, 180, 180);
    @Override
    public void initializeEnvironment() {
        backGround = ResourceTools.loadImageFromResource("Trench_Warfare/BattleGround1.png");
        backGround = ResourceTools.loadImageFromResource("Trench_Warfare/BattleGround1.png");
        grid = new Grid(10, 6, 145, 145, new Point(0, 0), Color.black);
        bulletType = ResourceTools.loadImageFromResource("Trench_Warfare/Bullet.png");
        mines =  new ArrayList<>();

//        greenSoilder = ResourceTools.loadImageFromResource("Trench_Warfare/Green soilder.gif");
        mrGreen = new Soldier(xSoldier, ySoldier, SoldierType.GREEN);
        mrGrey = new Soldier(400, 400, SoldierType.GREY);
        trench1 = ResourceTools.loadImageFromResource("Trench_Warfare/Trench1.png");
        trenchs = new ArrayList<>();
        bullets = new ArrayList<>();

    }
    Image greenSoilder;

    @Override
    public void timerTaskHandler() {
        if (bullets != null) {
            for (Bullet bullet : bullets) {
                bullet.move();
            }
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mrGreen.setX(mrGreen.getX() - moveSpeed);
            mrGreen.runLeft();
            this.validateMove(mrGreen.getCenterOfMass());

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mrGreen.setX(mrGreen.getX() + moveSpeed);
            mrGreen.runRight();
            this.validateMove(mrGreen.getCenterOfMass());
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            mrGreen.setY(mrGreen.getY() + moveSpeed);
            mrGreen.runRight();
            this.validateMove(mrGreen.getCenterOfMass());
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            mrGreen.setY(mrGreen.getY() - moveSpeed);
            mrGreen.runUP();
            this.validateMove(mrGreen.getCenterOfMass());
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            AudioPlayer.play("/trench_warfare/RifleShooting.wav");
            bullets.add(new Bullet(bulletType, mrGreen.getX(), mrGreen.getY()));
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
        if (e.getKeyCode() == KeyEvent.VK_B) {
        
  
        }
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {

        System.out.println("mouse click at system point " + e.getPoint());
        System.out.println("mouse click in cell grid " + grid.getCellCoordinateFromSystemCoordinate(e.getPoint()));
        System.out.println("mouse click in cell " + grid.getCellLocationFromSystemCoordinate(e.getPoint()));
        System.out.println("");

        mines.add(new Mines(grid.getCellCoordinateFromSystemCoordinate(e.getPoint()), mine, this));
        
//        trenchs.add(new Trench(grid.getCellCoordinateFromSystemCoordinate(e.getPoint()), trench1, this));
        mines.add(new Mines(grid.getCellCoordinateFromSystemCoordinate(e.getPoint()), mine, this));
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
        
        if (mines == null) {
            mine = ResourceTools.loadImageFromResource("Trench_Warfare/MinesHole.png");

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
        graphics.drawRect(0, 0, 1438, 850);
    }

    public boolean isInTrench(Point systemLocation) {
        //decode the sysLoc to a grid cell
        Point gridLocation = grid.getCellCoordinateFromSystemCoordinate(systemLocation);
        //check if that grid cell contains a trench
//        return (gridLocation.equals(trench));
//        return this.trenchs.contains(gridLocation);
        for (Trench trench : trenchs){
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
        for (Mines mine : mines){
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
            System.out.println("trench");
        } else {
            moveSpeed =15;
            System.out.println(" no trench");
        }
        if (isInMineField(proposedLocation)) {
            mine = null;
            mrGreen = null;
            System.out.println("ouch");
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
