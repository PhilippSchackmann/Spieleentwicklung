
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
    private int worldsize_x;
    private int worldsize_y;
    
    
    public Player( int x, int y, int size, int worldsize_x, int worldsize_y){
        bounding = new Rectangle(x, y, size, size);
        f_posx = x;
        f_posy = y;
        /*
        * Die "Hitbock" wird festgelegt
        * Bekommt die selben Maße wie der Spieler
        */
        this.worldsize_x = worldsize_x;
        this.worldsize_y = worldsize_y;
        /*
        * Der Bereich in dem sich der Spieler bewegen darf wird festgelegt
        * Der Bereich ist das Fenster
        */
    }
    
    public void update(float timeSinceLastFrame, boolean up, boolean down, boolean left, boolean right){
        if(up)f_posy-=500*timeSinceLastFrame;
        if(down)f_posy+=500*timeSinceLastFrame;
        if(right)f_posx+=500*timeSinceLastFrame;
        if(left)f_posx-=500*timeSinceLastFrame;
        /*
        * Position des Spielers wird geupdatet
        */
        
        if(f_posx<0)f_posx=0;
        if(f_posy<0)f_posy=0;
        if(f_posx>worldsize_x-bounding.width)f_posx=worldsize_x-bounding.width;
        if(f_posy>worldsize_y-bounding.height)f_posy=worldsize_y-bounding.height;
        /*
        * Hier wird der Bereich festgelegt in dem sich der Spieler bewegen darf.
        * wenn der Spieler den Bereich verlässt dann wird er zurückgesetzt.
        * Dies wird mit hilfe der Vaiable worldsize gemacht.
        * Da die Position des Spieler mit der linken oberen Ecke definiert ist, müssen am rechten und unteren Ende des Fensters die Größen des Spielers abgezogen werden.
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
