/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trench_warfare;

import audio.AudioEvent;
import audio.AudioEventListenerIntf;
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
class BattleField extends Environment implements CellDataProviderIntf,
        MoveValidatorIntf, AudioEventListenerIntf {

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
    Image mag;
    Image mag1;
    Image mag2;
    Image mag3;
    Image mag4;
    Image mag5;
    Image mine2;
    Image trench1;
    Image bulletLeft;
    Image bulletRight;
    Image backGround;
    Image naziScalps;
    Image radio;

    Grid grid;

    int dogTags = 0;
    int moveSpeed = 55;
    Image greenSoilder;
    int counter;

    double moveDelay = 0;
    double moveDelayLimit = 2;
    double rienformentDelay = 0;
    double rienformentDelayLimit = 40;
    double shootDelay = 5;
    double shootDelayLimit = 0;
    double health = 100;
    double healthLimit = 0;
    double magSize = 5;
    double magSizeLimit = 0;

    private ArrayList<Item> items;

    private GameState state;

    String songName;
    String score;
    String healthGreen;

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
        naziScalps = ResourceTools.loadImageFromResource("Trench_Warfare/nazi_scalps.png");
        mag = ResourceTools.loadImageFromResource("Trench_Warfare/mag_empty.png");
        mag1 = ResourceTools.loadImageFromResource("Trench_Warfare/mag_01_bullet.png");
        mag2 = ResourceTools.loadImageFromResource("Trench_Warfare/mag_02_bullet.png");
        mag3 = ResourceTools.loadImageFromResource("Trench_Warfare/mag_03_bullet.png");
        mag4 = ResourceTools.loadImageFromResource("Trench_Warfare/mag_04_bullet.png");
        mag5 = ResourceTools.loadImageFromResource("Trench_Warfare/mag_05_bullet.png");
        radio = ResourceTools.loadImageFromResource("Trench_Warfare/Radio.png");

        grid = new Grid(10, 6, 145, 145, new Point(0, 0), Color.black);

        bulletLeft = ResourceTools.loadImageFromResource("Trench_Warfare/bullet_left.png");
        bulletRight = ResourceTools.loadImageFromResource("Trench_Warfare/bullet_right.png");
//        greenSoilder = ResourceTools.loadImageFromResource("Trench_Warfare/Green soilder.gif");

        soldierGreen = new Soldier(new Point(collum1X, collum1Y), SoldierType.GREEN);
        soldierGrey = new Soldier(new Point(1800, 400), SoldierType.GREY);

        trenchs = new ArrayList<>();
        bullets = new ArrayList<>();
        mines = new ArrayList<>();
        soldierGreys = new ArrayList<>();
        items = new ArrayList<>();
//        items.add(new Item(4, 5, true, Item.ITEMS_TYPE_FLAMETHROWER, this, this));
        soldierGreys.add(soldierGrey);
        soundManager.play(BACKGROUND);

    }

    SoundManager soundManager;
    private static final String SOUND_RIFLE = "RIFLE";
    private static final String BACKGROUND = "BACKGROUND";
    private static final String DEATH = "DEATH";
    private static final String SOUND_ITS_A_LONG_WAY_TO_BERLIN = "Its A Long Way To Berlin";

    private void setUpSound() {
        //set up a list of tracks in a playlist
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track(SOUND_RIFLE, Source.RESOURCE, "/trench_warfare/RifleShooting.wav"));
        tracks.add(new Track(BACKGROUND, Source.RESOURCE, "/trench_warfare/gun_battle_sound.wav"));
        tracks.add(new Track(DEATH, Source.RESOURCE, "/trench_warfare/death.wav"));
        tracks.add(new Track(SOUND_ITS_A_LONG_WAY_TO_BERLIN, Source.RESOURCE, "/trench_warfare/It's A Long Way To Berlin.wav"));
        Playlist playlist = new Playlist(tracks);
        //passs the playlist to a sound manager
        soundManager = new SoundManager(playlist, this);

    }
//    new greenSoilder(350, 10, 180, 180);

    @Override
    public void initializeEnvironment() {

    }

    @Override
    public void timerTaskHandler() {

        score = "Nazi Scalps = " + dogTags;
        healthGreen = "Your Health = " + health;
        if (state == GameState.RUNNING) {
            greyshooting();

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
            if (rienformentDelay >= rienformentDelayLimit) {
                soldierGreys.add(new Soldier(new Point(1500, random(getHeight() - 100)), SoldierType.GREY));
                rienformentDelay = 0;
            } else {
                rienformentDelay++;

            }

            soldierGreen.timerTaskHandler();
            System.out.println("Nazi Scalps = " + dogTags);
            if (bullets != null) {
                for (Bullet bullet : getCopyOfBullets()) {
                    bullet.move();
                    validateMove(bullet.getCenterOfMass());
                    shotGreen();
//                    shotGrey();
                }
            }
        }
    }

    private int random(int value) {
        return (int) (Math.random() * value);
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_B) {
            if (state == GameState.PAUSED) {
                state = GameState.RUNNING;
            }
            if (state == GameState.PAUSED) {
                state = GameState.RUNNING;
            }
        }
        if (state == GameState.RUNNING) {
            if (soldierGreen.getState() != SoldierState.DEAD_LEFT || soldierGreen.getState() != SoldierState.DEAD) {
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
                }
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    magSize = 5;
                }

                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (magSize > magSizeLimit) {
                        magSize = magSize - 1;
                        soundManager.play(SOUND_RIFLE);
                        if ((soldierGreen.getState() == SoldierState.RUN_RIGHT) || (soldierGreen.getState() == SoldierState.STAND_RIGHT)
                                || (soldierGreen.getState() == SoldierState.RUN_UP) || (soldierGreen.getState() == SoldierState.RUN_DOWN)) {
                            bullets.add(new Bullet(bulletRight, soldierGreen.getX() + 10, soldierGreen.getY() - 10, BulletState.SHOT_RIGHT, BulletShot.SHOT_BY_GREEN));
                        } else {
                            bullets.add(new Bullet(bulletLeft, soldierGreen.getX() - 10, soldierGreen.getY() - 10, BulletState.SHOT_LEFT, BulletShot.SHOT_BY_GREEN));
                        }

                    } else {
                        magSize = 0;
                    }
                }
            } else {
                soldierGreen.dead();
            }

            if (e.getKeyCode() == KeyEvent.VK_1) {
                for (int i = 0; i < 5; i++) {
                    soldierGreys.add(new Soldier(new Point(1500, random(getHeight() - 100)), SoldierType.GREY));
                    soldierGreys.get(i).runLeft();
//                mrGreen.runRight();

                }
            }
            if (e.getKeyCode() == KeyEvent.VK_COMMA) {
                soundManager.play(SOUND_ITS_A_LONG_WAY_TO_BERLIN);
                songName = "Its A Long Way To Berlin";
            }

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
//        System.out.println("mouse click at system point " + e.getPoint());
//        System.out.println("mouse click in cell grid " + grid.getCellCoordinateFromSystemCoordinate(e.getPoint()));
//        System.out.println("mouse click in cell " + grid.getCellLocationFromSystemCoordinate(e.getPoint()));
//        System.out.println("");
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
//        graphics.drawImage(radio, 950, 510, this);
        graphics.setFont(new Font("Calibri", Font.ITALIC, 32));
//        graphics.drawString(score, 1100, 590);
        graphics.drawString(score, 1120, 50);
        graphics.drawString(healthGreen, 0, 50);
        graphics.drawImage(naziScalps, 1020, 0, this);
        if (magSize >= 5) {
            graphics.drawImage(mag5, 1300, 50, this);
        } else if (magSize >= 4) {
            graphics.drawImage(mag4, 1300, 50, this);
        } else if (magSize >= 3) {
            graphics.drawImage(mag3, 1300, 50, this);
        } else if (magSize >= 2) {
            graphics.drawImage(mag2, 1300, 50, this);
        } else if (magSize >= 1) {
            graphics.drawImage(mag1, 1300, 50, this);
        } else if (magSize <= 0) {
            graphics.drawImage(mag, 1300, 50, this);

        }

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
//            System.out.println("ouch");
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

//</editor-fold>
    private void shotGreen() {
        if (soldierGreen != null) {
            if (soldierGrey != null) {
                if (bullets != null) {
                    ArrayList<Bullet> toBulletRemoves = new ArrayList<>();
                    for (Bullet bullet : getCopyOfBullets()) {
                        for (Soldier soldierGrey : soldierGreys) {
                            if ((bullet.getX() < -20) || (bullet.getX() > this.getWidth())) {
                                //bullet off screen: delete
                                toBulletRemoves.add(bullet);
                            } else if (true) {
                                if (soldierGrey.isAlive() && (bullet.rectangle().intersects(soldierGrey.rectangle())) && bullet.Green()) {
                                    toBulletRemoves.add(bullet);
                                    soundManager.play(DEATH);
//                                System.out.println("Shot");
                                    soldierGrey.deadLeft();
                                    dogTags += 1;
                                } else if ((bullet.rectangle().intersects(soldierGreen.rectangle())) && bullet.Grey()) {
                                    toBulletRemoves.add(bullet);
                                    health = health - 1;
//                                System.out.println("Shot");
                                    if (health <= healthLimit) {
                                        soldierGreen.deadLeft();
                                        soundManager.play(DEATH);
                                    }
                                }
                            }
                        }
                    }
                    bullets.removeAll(toBulletRemoves);
                }
            }
        }

    }

    public void rienforcment() {
        soldierGreys.add(new Soldier(new Point(1500, random(getHeight() - 100)), SoldierType.GREY));
    }

    public void greyshooting() {
        if (soldierGreys != null) {
            for (Soldier soldierGrey : soldierGreys) {
                if (random(200) <= 2) {
                    if (soldierGrey.isAlive()) {
                        bullets.add(new Bullet(bulletLeft, soldierGrey.getX() - 20, soldierGrey.getY() - 10, BulletState.SHOT_LEFT, BulletShot.SHOT_BY_GREY));
                    }
                }
            }

        }
    }

//    private void shotGrey() {
//        if (soldierGreen != null) {
//            if (bullets != null) {
//
//                ArrayList<Bullet> toBulletRemoves = new ArrayList<>();
//
//                for (Bullet bullet : getCopyOfBullets()) {
//                    if ((bullet.getX() < -20) || (bullet.getX() > this.getWidth())) {
//                        //bullet off screen: delete
//                        toBulletRemoves.add(bullet);
//                    } else if (true) {
//                        if (soldierGreen.isAlive() && (bullet.rectangle().intersects(soldierGreen.rectangle()))) {
//                            toBulletRemoves.add(bullet);
////                                System.out.println("Shot");
//                            soldierGrey.deadLeft();
//                        }
//                    }
//                    bullets.removeAll(toBulletRemoves);
//                }
//            }
//        }
//    }
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

//<editor-fold defaultstate="collapsed" desc="AudioEventListenerIntf Interface Methods">
    @Override
    public void onAudioEvent(AudioEvent event, String trackName) {
        System.out.println("Audio Event = " + event.name() + " " + trackName);

        if ((event == AudioEvent.ON_COMPLETE)
                && ((trackName.equals(SOUND_ITS_A_LONG_WAY_TO_BERLIN)
                || (trackName.equals(SOUND_ITS_A_LONG_WAY_TO_BERLIN)
                || (trackName.equals(SOUND_ITS_A_LONG_WAY_TO_BERLIN)))))) {
            playRandomSong();
        }
    }
//</editor-fold>

    private void playRandomSong() {
        double songChoice = Math.random();
        if (soundManager != null) {
            if (songChoice < .33) {
                soundManager.play(SOUND_ITS_A_LONG_WAY_TO_BERLIN);
                songName = SOUND_ITS_A_LONG_WAY_TO_BERLIN;
            } else if (songChoice < .66) {
                soundManager.play(SOUND_ITS_A_LONG_WAY_TO_BERLIN);
            } else {
                soundManager.play(SOUND_ITS_A_LONG_WAY_TO_BERLIN);
            }
        }
    }

}
