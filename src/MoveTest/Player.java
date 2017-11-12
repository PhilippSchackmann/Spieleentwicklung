
package MoveTest;

import java.awt.Rectangle;

/**
 *
 * @author Philipp
 */
public class Player {
    private Rectangle bounding;
    private float f_posx;
    private float f_posy;
    
    public Player(int x, int y, int size){
        bounding = new Rectangle(x, y, size, size);
        f_posx = x;
        f_posy = y;
        /*
        * Die "Hitbock" wird festgelegt
        * Bekommt die selben Maße wie der Spieler
        */
    }
    
    public void update(boolean up, boolean down, boolean left, boolean right){
        if(up)f_posy-=5;
        if(down)f_posy+=5;
        if(right)f_posx+=5;
        if(left)f_posx-=5;
        /*
        * Position des Spielers wird geupdatet
        */
        bounding.x=(int)f_posx;
        bounding.y=(int)f_posy;
        /*
        * Position der "Hitbock" wird geupdatet
        */
    }
    
    public Rectangle getBounding(){
        return bounding;
    }
}
