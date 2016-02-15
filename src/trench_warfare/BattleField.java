/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trench_warfare;

import audio.AudioPlayer;
import audio.Playlist;
import audio.SoundManager;
import audio.Source;
import audio.Track;
import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Font;
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

//<editor-fold defaultstate="collapsed" desc="Properties">
    int collum1X = 20;
    int collum1Y = 20;

    Soldier soldierGreen;
    Soldier soldierGrey;

    private ArrayList<Bullet> bullets;
    private ArrayList<Trench> trenchs;
    private ArrayList<Mines> mines;
    private ArrayList<Soldier> soldierGreys;

    Image mine;
    Image mine2;
    Image trench1;
    Image bulletType;
    Image backGround;
    Image radio;

    Grid grid;

    int dogTags = 0;
    int moveSpeed = 55;
    Image greenSoilder;
    int counter;

    double moveDelay = 0;
    double moveDelayLimit = 10;
    double deathDelay = 0;
    double deathDelayLimit = 10;

    private ArrayList<Item> items;

    private GameState state;

    String SongName;

    /**
     * @param state the state to set
     */
    public void setState(GameState state) {
        this.state = state;
    }

    private ArrayList<Bullet> getCopyOfBullets() {
        ArrayList<Bullet> copyOfBullets = new ArrayList<>();
        copyOfBullets.addAll(bullets);
        return copyOfBullets;
    }
//</editor-fold>

    public BattleField() {
        setUpSound();
        setState(GameState.PAUSED);
        backGround = ResourceTools.loadImageFromResource("Trench_Warfare/BattleGround1.png");
        radio = ResourceTools.loadImageFromResource("Trench_Warfare/Radio.png");

        grid = new Grid(10, 6, 145, 145, new Point(0, 0), Color.black);

        bulletType = ResourceTools.loadImageFromResource("Trench_Warfare/Bullet.png");
//        greenSoilder = ResourceTools.loadImageFromResource("Trench_Warfare/Green soilder.gif");

        soldierGreen = new Soldier(new Point(collum1X, collum1Y), SoldierType.GREEN);
        soldierGrey = new Soldier(new Point(800, 400), SoldierType.GREY);

        trenchs = new ArrayList<>();
        bullets = new ArrayList<>();
        mines = new ArrayList<>();
        soldierGreys = new ArrayList<>();
        items = new ArrayList<>();
//        items.add(new Item(4, 5, true, Item.ITEMS_TYPE_FLAMETHROWER, this, this));
        soldierGreys.add(soldierGrey);
    }

    SoundManager soundManager;
    private static final String SOUND_RIFLE = "RIFLE";
    private static final String ITS_A_LONG_WAY_TO_BERLIN = "IALWTB";

    private void setUpSound() {
        //set up a list of tracks in a playlist
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track(SOUND_RIFLE, Source.RESOURCE, "/trench_warfare/RifleShooting.wav"));
        tracks.add(new Track(ITS_A_LONG_WAY_TO_BERLIN, Source.RESOURCE, "/trench_warfare/It's A Long Way To Berlin.wav"));
        Playlist playlist = new Playlist(tracks);
        //passs the playlist to a sound manager
        soundManager = new SoundManager(playlist);

    }
//    new greenSoilder(350, 10, 180, 180);

    @Override
    public void initializeEnvironment() {

    }

    @Override
    public void timerTaskHandler() {
        if (state == GameState.RUNNING) {

            if (soldierGreys != null) {
                for (Soldier soldierGrey : soldierGreys) {
                    if (moveDelay >= moveDelayLimit) {
                        soldierGrey.move();
                        moveDelay = 0;
                    } else {
                        moveDelay++;
                    }
                }

            }

            soldierGreen.timerTaskHandler();
            System.out.println("DogTags = " + dogTags);
            if (bullets != null) {
                for (Bullet bullet : getCopyOfBullets()) {
                    bullet.move();
                    validateMove(bullet.getCenterOfMass());
                    shot();
                }
            }
        }
    }

    private int random(int value) {
        return (int) (Math.random() * value);
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            soldierGreen.runLeft();
            this.validateMove(soldierGreen.getCenterOfMass());
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            soldierGreen.runRight();
            this.validateMove(soldierGreen.getCenterOfMass());
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            soldierGreen.runDOWN();
            this.validateMove(soldierGreen.getCenterOfMass());
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            soldierGreen.runUP();
            this.validateMove(soldierGreen.getCenterOfMass());
        } else if (e.getKeyCode() == KeyEvent.VK_B) {
            if (state == GameState.PAUSED) {
                state = GameState.RUNNING;
            }
            if (state == GameState.PAUSED) {
                state = GameState.RUNNING;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            soundManager.play(SOUND_RIFLE);
            if ((soldierGreen.getState() == SoldierState.RUN_RIGHT) || (soldierGreen.getState() == SoldierState.STAND_RIGHT)
                    || (soldierGreen.getState() == SoldierState.RUN_UP) || (soldierGreen.getState() == SoldierState.RUN_DOWN)) {
                bullets.add(new Bullet(bulletType, soldierGreen.getX() + 10, soldierGreen.getY() - 10, BulletState.SHOT_RIGHT));
            } else {
                bullets.add(new Bullet(bulletType, soldierGreen.getX() - 10, soldierGreen.getY() - 10, BulletState.SHOT_LEFT));
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_1) {
            for (int i = 0; i < 5; i++) {
                soldierGreys.add(new Soldier(new Point(800, random(400)), SoldierType.GREY));
                soldierGreys.get(i).runLeft();
//                mrGreen.runRight();

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_2) {
            for (int i = 0; i < 5; i++) {
                soldierGreys.add(new Soldier(new Point(400, random(400)), SoldierType.GREY));
                soldierGreys.get(i).runLeft();
//                mrGreen.runRight();

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_COMMA) {
            soundManager.play(ITS_A_LONG_WAY_TO_BERLIN);
            SongName = "Its A Long Way To Berlin";
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            soldierGreen.stopLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            soldierGreen.stopRight();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            soldierGreen.stopRight();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            soldierGreen.stopRight();
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
        graphics.drawImage(radio, 950, 510, this);
        graphics.setFont(new Font("Calibri", Font.ITALIC, 32));
//        graphics.drawString(SongName, 1100, 590);

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

        if (soldierGreen != null) {
            soldierGreen.draw(graphics);
        }

        if (bullets != null) {
            for (Bullet bullet : getCopyOfBullets()) {
                bullet.draw(graphics);

            }
        }
        if (soldierGreys != null) {
            for (Soldier soldier : soldierGreys) {
                soldier.draw(graphics);
            }

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

//        if (trench.getLocation().x == soldierGreen.getX()) {
//            if (trench.getLocation().y == soldierGreen.getY()) {
//                moveSpeed = 5;
//            }
//        } else {
//            System.out.println("!");
//        }
        return proposedLocation;
    }

    private void death() {
        if (soldierGrey != null) {
            if (deathDelay >= deathDelayLimit) {
                soldierGrey.dead();
            } else {
                deathDelay++;
            }

        }
    }

    private void shot() {
        if (soldierGrey != null) {
            if (bullets != null) {

                ArrayList<Bullet> toBulletRemoves = new ArrayList<>();

                for (Bullet bullet : getCopyOfBullets()) {
                    for (Soldier soldierGrey : soldierGreys) {
                        if ((bullet.getX() < -20) || (bullet.getX() > this.getWidth())) {
                            //bullet off screen: delete
                            toBulletRemoves.add(bullet);
                        } else if (true) {
                            if (soldierGrey.isAlive() && (bullet.rectangle().intersects(soldierGrey.rectangle()))) {
                                toBulletRemoves.add(bullet);
                                System.out.println("Shot");
                                soldierGrey.deadLeft();
                                dogTags += 5;
                            }
                        }
                    }
                    bullets.removeAll(toBulletRemoves);
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
    public int getSystemCoordX(int x, int y
    ) {
        return grid.getCellSystemCoordinate(x, y).x;
    }

    @Override
    public int getSystemCoordY(int x, int y
    ) {
        return grid.getCellSystemCoordinate(x, y).y;
    }
//</editor-fold>

}
