//written by GKGKGKGK
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.FontFormatException;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.JComboBox;

import java.lang.*;

import java.io.*;
import java.io.InputStream;

import java.util.*;
import java.util.TimerTask;
import java.util.Random;




public class MinuteBudget
extends JFrame
implements ActionListener {
public static int current = 0;
    public static int time = 10000;
    public static int timeMinutes = 1000;
    public static String userTask[] = new String[SetupPanel.amount];
    public static int finalTime = 0;
    public static int seconds = 0;
    private static int stand = 8*60;
    private static int sit = 20*60;
    private static int move = 2*60;
    private static String postureString = "";
    private static Font font = null;
    private static Font font2 = null;
    private static Font font3 = null;
    private static Font font4 = null;
    public MinuteBudget() {
        Timer clock = new Timer(1000, this);
        setLayout(null);
        setTitle("MinuteBudget");
        setContentPane(new DrawPane());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        clock.start();
    }

 
    class DrawPane extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            makeFonts();
            FontMetrics fontMetrics = g.getFontMetrics(font);
            FontMetrics fontMetrics2 = g.getFontMetrics(font2);
            FontMetrics fontMetrics3 = g.getFontMetrics(font3);
            FontMetrics fontMetrics4 = g.getFontMetrics(font4);
            Dimension screenSize = this.getBounds().getSize();
            double width = screenSize.getWidth();
            double height = screenSize.getHeight();
            String printString = "You have " + Integer.toString(finalTime) + " minutes left!";
            String printStringSeconds = "and " + seconds + " seconds";
            int timeLength = fontMetrics.stringWidth(printString);
            int timeHeight = fontMetrics.getHeight();
            int universalLength = fontMetrics.stringWidth(printString);
            int universalHeight = fontMetrics.getHeight();
            Color mainText = new Color(255, 255, 255, 255);
            setBackground(Color.WHITE);

            g.setFont(font);
            g.setColor(Color.BLACK);

            g.drawString(printString, (int)((width / 2) - (timeLength / 2)), (int)((height / 2) - (timeHeight / 2)));

            g.setFont(font2);
            g.drawString(printStringSeconds, (int)((width / 2) - (timeLength / 2)), (int)((height / 2) - (timeHeight / 2))+50);

            g.setFont(font3);
            universalLength = fontMetrics3.stringWidth(postureString);
            universalHeight = fontMetrics3.getHeight();
            g.drawString(postureString, 0,(int)(height-(universalHeight)));

            g.setFont(font4);
            universalLength = fontMetrics4.stringWidth(userTask[current]);
            universalHeight = fontMetrics4.getHeight();
            g.drawString(userTask[current], (int)((width / 2) - (universalLength / 2)), 0+ (universalHeight));

        }
    }


    public void actionPerformed(ActionEvent e) {
        time--;
        
        if(sit>0){
        sit -=1;
        postureString = "Sit down! Relax...";
        }
        else if (sit <=0 && stand >0){
        stand -=1;
        postureString = "Why don't you work standing up for a bit!";
        }
        else if(sit <=0 && stand<=0 && move >0) {
        postureString = "Take a walk around the room! Stretch!";
        move-=1;
        }
        else{
        sit = 20*60;
        stand = 8*60;
        move = 2*60;
        }
      
      if(time > 60){
      finalTime = time/60;
      if(seconds >0){
      seconds -= 1; 
      }
      else {
      seconds = 59;
      }
      }
      else{
      finalTime = time;
      }
        repaint();
    }

    public void makeFonts(){
          try {
                font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("CaviarDreams.ttf"))).deriveFont(Font.PLAIN, 36);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                font2 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("CaviarDreams.ttf"))).deriveFont(Font.ITALIC, 12);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
             try {
                font3 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("CaviarDreams.ttf"))).deriveFont(Font.PLAIN, 24);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
             try {
                font4 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("CaviarDreams.ttf"))).deriveFont(Font.PLAIN, 48);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            
    }

    public static void main(String[] args) {
      
        beginPanel beginPanel = new beginPanel();

}
}