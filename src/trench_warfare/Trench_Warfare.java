/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trench_warfare;
import environment.ApplicationStarter;
import java.awt.Dimension;


/**
 *
 * @author BBC132
 */
public class Trench_Warfare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        ApplicationStarter.run(args, "Trench Warfare", new Dimension(1439,900), new SoldierMechanics());
        
        }
    
}
