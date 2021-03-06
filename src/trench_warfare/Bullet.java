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
public class Bullet {

    private int x;
    private int y;
//    private SoldierState state = SoldierState.STAND_RIGHT;
    private Image image;
    private BulletState state;
    private BulletReload reload;
    private BulletShot shot;

    public Bullet(Image image, int x, int y, BulletState state, BulletShot shot) {
        this.shot = shot;
        this.state = state;
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics graphics) {
//        graphics.fillOval(getCenterOfMass().x, getCenterOfMass().y, 10, 10);
        graphics.drawImage(image, getX() + 40, getY() + 30, null);
//        graphics.drawRect(x, y, image.getWidth(null), image.getHeight(null));
//        graphics.drawRect(rectangle().x, rectangle().y, rectangle().width, rectangle().height);
    }

    public void green() {
        setShot(BulletShot.SHOT_BY_GREEN);
    }

    public void grey() {
        setState(BulletState.Grey);
    }

    public boolean Green() {
        return ((shot != BulletShot.SHOT_BY_GREY));
    }

    public boolean Grey() {
        return ((shot != BulletShot.SHOT_BY_GREEN));
    }


    public void move() {
        if (state == BulletState.SHOT_LEFT) {
            x -= 50;
        } else if (state == BulletState.SHOT_RIGHT) {
            x += 50;
        }

    }

    public Point getCenterOfMass() {
        return new Point(getX() + (image.getWidth(null)), getY() + (image.getHeight(null)));
    }

    private static int bulletWidth = 6;
    private static int bulletHeight = 4;

    public Rectangle rectangle() {
        return new Rectangle(x + (image.getWidth(null)), y + (image.getHeight(null))- 15, bulletWidth, bulletHeight);
//        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }

    public void setState(BulletState state) {
        if (this.state != state) {
            this.state = state;

        }
    }
//<editor-fold defaultstate="collapsed" desc="Property">

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
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }
//</editor-fold>

    /**
     * @param shot the shot to set
     */
    public void setShot(BulletShot shot) {
        this.shot = shot;
    }

    /**
     * @param reload the reload to set
     */
    public void setReload(BulletReload reload) {
        this.reload = reload;
    }
}
