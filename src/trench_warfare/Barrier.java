/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trench_warfare;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author BBC132
 */
public class Barrier {

    public void draw(Graphics graphics){
       graphics.setColor(color);
       graphics.fill3DRect(cellData.getSystemCoordX(x, y),cellData.getSystemCoordX(x, y) , cellData.getCellWidth() , cellData.getCellHeight(), true);
    }
    
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Barrier(int x,int y, Color color, CellDataProviderIntf cellData){
//       boolean breakable
        this.x = x;
        this.y = y;
        
        this.color = color;
        this.cellData = cellData; 
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Properties">
    
    private    int x, y;
    private Color color;
    private boolean breakable = false;
    private CellDataProviderIntf cellData;
    
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
     * @return the color
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    
//</editor-fold>
    
    

}
