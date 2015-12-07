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


    Trench(Point point, Image image, Grid grid) {
        this.point = point;
        this.image = image;
        this.grid = grid;
        point.x = this.x;
        point.y = this.y;
    }

    private int x;
    private int y;
    private  Point point;
    private Image image;
    private Grid grid;

    public void draw(Graphics graphics) {
      
        graphics.drawImage(getImage(), x, y, null);

}

//<editor-fold defaultstate="collapsed" desc="Property">
    /**
     * @return the point
     */
    public Point getPoint() {
        return point;
    }
    
    /**
     * @param point the point to set
     */
    public void setPoint(Point point) {
        this.point = point;
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
    
    /**
     * @return the grid
     */
    public Grid getGrid() {
        return grid;
    }
    
    /**
     * @param grid the grid to set
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
 }        
//</editor-fold>
  
}
