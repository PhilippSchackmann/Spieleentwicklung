/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import javax.swing.JFrame;

/**
 *
 * @author Philipp
 */
public class MoveTest {
    public static void main(String[] args){
        
        Player player = new Player(300, 300, 50, 800, 600); // neuen Spieler erstellen
        //Namen der Klasse; Name des Objekts; = neue Instanz der Klasse
        
            Frame f = new Frame(player);  // Fenster initialisieren
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Beendet das Fenst wenn man auf das X klickt
            f.setSize(800, 600);  // Größe des Fensters
            f.setVisible(true);  // Fenster ist sichtbar
            f.setResizable(false);  // Fenster hat eine feste Größe und lest sich nicht verändern
            
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
                
                
                f.repaintScreen(); // ruft die Methode ab dass das Bild aktualiesiert wird
                
                
                try{
                 Thread.sleep(15);   // warte 15 ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
    }
}