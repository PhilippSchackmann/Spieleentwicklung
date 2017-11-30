/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Admin
 */
public class Background {
    private float f_posx;
    private float f_speed;
    private BufferedImage look;
    
    public Background(float f_speed){
        this.f_speed = f_speed;
        try {
            look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/weltraum"));
        } catch (IOException e) {e.printStackTrace();}
        
    }
    
    public void update(float timeSinceLastFrame){
        f_posx-=f_speed*timeSinceLastFrame;
        if(f_posx<-look.getWidth())f_posx+=look.getWidth();
    }
    public int getX(){
        return (int)f_posx;
    }
    
    public BufferedImage getLook(){
        return look;
    }
}
