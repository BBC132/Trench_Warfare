/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trench_warfare;

import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author BBC132
 */
public class Item {
    private int x;
    private int y;
    private String type;
    private CellDataProviderIntf cellData;
    private MoveValidatorIntf moveValidator;
    private Image image;
    
    
    public Item(int x, int y, boolean alive, String type,CellDataProviderIntf cellData, MoveValidatorIntf moveValidator){
        this.x = x;
        this.y = y;
        this.type = type;
        this.cellData =cellData;
        this.moveValidator = moveValidator;
        

        
        if (type.equals(Item.ITEMS_TYPE_FLAMETHROWER)) {
//            image = ResourceTools.loadImageFromResource("trench_warfare/flame-thrower.png");
        }
    }
            public void draw(Graphics graphics){
                if (image != null) {
                    graphics.drawImage(image, x, y, null);
                }
        }
    public static final String ITEMS_TYPE_FLAMETHROWER = "FlameThrower";
    
}
