/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package MoveTest;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;


 *
 * @author Admin
 
public class ShowDisplayMode {
    public static void main(String[]args){
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice device = environment.getDefaultScreenDevice();
            
            DisplayMode[] ds = device.getDisplayModes();
            
            for(int i = 0; 1<ds.length; i++){
                System.out.println(ds(i).getWidth()+""+ds(i).getHeight()+""ds(i).getBitDepth()+"Hallo"+ds(i).getRefreshRate());
            }
    }
}
*/