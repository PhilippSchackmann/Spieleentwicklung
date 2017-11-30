/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import static sun.audio.AudioDevice.device;

/**
 *
 * @author Philipp 
 */
public class MoveTest {
    public static void main(String[] args){
        
        Player player = new Player(300, 300, 1920, 1080); // neuen Spieler erstellen
        //Namen der Klasse; Name des Objekts; = neue Instanz der Klasse
        Background bg = new Background(100);
        
            Frame f = new Frame(player, bg);  // Fenster initialisieren
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Beendet das Fenst wenn man auf das X klickt
            f.setSize(1920, 1080);  // Größe des Fensters
            f.setUndecorated(true);
            //f.setVisible(true);  // Fenster ist sichtbar
            f.setResizable(false);  // Fenster hat eine feste Größe und lest sich nicht verändern
            DisplayMode displayMode = new DisplayMode(1920, 1080, 32, 60); // Breite; Höhe; Bittiefe(Welche Farben angezeigt werden können); Bildwiederholungsrate;
            GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice device = environment.getDefaultScreenDevice();
            
            device.setFullScreenWindow(f);
            device.setDisplayMode(displayMode);
            
            long lastFrame = System.currentTimeMillis();  // aktuelle Systemzeit speichern als LastFrame
            while(true){
                long thisFrame = System.currentTimeMillis();  // aktuelle Systemzeit speichern als thisFrame
                float timeSinceLastFrame = ((float)(thisFrame-lastFrame))/1000f;  
                /* 
                * Die Zeit seit dem letzten Frame ist die aktuelle Zeit minus den letzten Zeitpunkt
                * In Sekunden umgerechnet
                * In Kommerzahl umgewandelt 
                * 1000f  ist 1000 als Kommerzahl damit Kommerzahl durch Kommerzahl gerechnet werden kann
                */

                lastFrame=thisFrame;  // Setze lastFrame auf die neue Zeit
                
                player.update(timeSinceLastFrame, f.getUp(), f.getDown(), f.getLeft(), f.getRight());
                bg.update(timeSinceLastFrame);
                
                f.repaintScreen(); // ruft die Methode ab dass das Bild aktualiesiert wird
                
                
                try{
                 Thread.sleep(15);   // warte 15 ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
    }
}