/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trench_warfare;

import java.awt.Graphics;
import java.awt.Image;
import grid.Grid;
import java.awt.Point;

/**
 *
 * @author BBC132
 */
public class Trench {
    private int x;
    private int y;

    Trench(int x, int y, Image image, CellDataProviderIntf cellData) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.cellData = cellData;
    }
    
    public void draw(Graphics graphics) {
        graphics.drawImage(getImage(), location.x, location.y, null);
//        graphics.drawImage(getImage(), getCellData().getSystemCoordX(getLocation().x, 
//                getLocation().y),getCellData().getSystemCoordY(getLocation().x, 
//                getLocation().y), getCellData().getCellWidth(), 
//                getCellData().getCellHeight(), null);
    }

//<editor-fold defaultstate="collapsed" desc="Property">
    private Point location;
    private Image image;
    private CellDataProviderIntf cellData;

    /**
     * @return the location
     */
    public Point getPoint() {
        return getLocation();
    }

    /**
     * @param point the location to set
     */
    public void setPoint(Point point) {
        this.setLocation(point);
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
     * @return the location
     */
    public Point getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Point location) {
        this.location = location;
    }

    /**
     * @return the cellData
     */
    public CellDataProviderIntf getCellData() {
        return cellData;
    }

    /**
     * @param cellData the cellData to set
     */
    public void setCellData(CellDataProviderIntf cellData) {
        this.cellData = cellData;
    }

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
}
