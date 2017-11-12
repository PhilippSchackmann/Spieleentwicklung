/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveTest;

import java.awt.Color;
import javax.swing.JFrame;  //JFrame wird importiert
import java.awt.Graphics;
import javax.swing.JLabel;  //JLabel importieren
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;  //KeyListener importieren, zum erfragen der Tasten
/**
 *
 * @author Philipp
 */
public class Frame extends JFrame {   //erbt von JFrame
    private Screen screen;  //Attribut
    
    final Player player;  // Player wird gespeichert
    
    
    private boolean key_up = false;  
    private boolean key_down = false;
    private boolean key_left = false;
    private boolean key_right = false;
    /*
    * 4 Variablen die für die Bewegungsrichtungen stehen.
    * Können jeweils true oder false sein.
    * Sind privat.
    * Boolean steht für
    */  
    
    public Frame(Player player){  // Constructor
        super("Mein erstes Spiel"); //Name des Fensters
        screen = new Screen();
        screen.setBounds(0, 0, 800, 600); // Größe des Fensters
        add(screen);
        addKeyListener(new KeyHandler());  //
        this.player = player;
    } 
    
    public boolean getUp(){
        return key_up;
    }
    public boolean getDown(){
        return key_down;
    }
    public boolean getLeft(){
        return key_left;
    }
    public boolean getRight(){
        return key_right;
    }
    /*
    4 Get Methoden
    */
    
    
    public void repaintScreen(){  //Methode
        screen.repaint();  //Bild wird aktualisiert
    }

    
    
    private class Screen extends JLabel{   //erbt von JLabel
        @Override
        protected void paintComponent(Graphics g){  //geschützte Klasse
          
            super.paintComponent(g); 
            g.setColor(Color.GREEN); //Farbe des Spielers festlegen
            g.fillRect(player.getBounding().x, player.getBounding().y, player.getBounding().width, player.getBounding().height);
            /*
            * Hier wird der Spieler "erstellt" .
            *Dazu werden die Informationen aus der Playerklasse abgerufen.
            */
        }     
    } 
    private class KeyHandler implements KeyListener{
        
        @Override
        public void keyPressed(KeyEvent e){  //Abfrage: ist die Taste getrückt?
            if(e.getKeyCode() == KeyEvent.VK_W)key_up = true;
            if(e.getKeyCode() == KeyEvent.VK_S)key_down = true;
            if(e.getKeyCode() == KeyEvent.VK_A)key_left = true;
            if(e.getKeyCode() == KeyEvent.VK_D)key_right = true;
            /*
            * Abfrage: ist die jeweilige Taste gedrückt?
            * Die Taste W ist z.B.: VK_W  
            * Wenn die Taste gedrückt ist soll key_up auf true gesetzt werden
            */
        }
        @Override
        public void keyReleased(KeyEvent e){  //Abfrage: ist die Taste nicht getrückt?
            if(e.getKeyCode() == KeyEvent.VK_W)key_up = false;
            if(e.getKeyCode() == KeyEvent.VK_S)key_down = false;
            if(e.getKeyCode() == KeyEvent.VK_A)key_left = false;
            if(e.getKeyCode() == KeyEvent.VK_D)key_right = false;
            /*
            * Abfrage: ist die jeweilige Taste nicht mehr gedrückt?
            * Die Taste W ist z.B.: VK_W  
            * Wenn die Taste nicht mehr gedrückt ist soll key_up auf false gesetzt werden
            */
        }

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}