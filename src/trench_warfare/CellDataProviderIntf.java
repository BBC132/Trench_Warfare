/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trench_warfare;

/**
 *
 * @author BBC132
 */
public interface CellDataProviderIntf {
        
    public int getCellWidth();
    public int getCellHeight();
    
    public int getSystemCoordX(int x, int y); 
    public int getSystemCoordY(int x, int y);
    
}
