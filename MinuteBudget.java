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
import javax.swing.JLabel;
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
extends JPanel
implements ActionListener {
    public static int current = 0;
    public static int time = 10000;
    public static int[] timeMinutesFinal;
    public static String[] userTaskFinal;
    private static int stand = 8*60;
    private static int sit = 20*60;
    private static int move = 2*60;
    private static String postureString = "";
    private static Font font = null;
    private static Font font2 = null;
    private static Font font3 = null;
    private static Font font4 = null;
    public static JFrame window;
    public MinuteBudget(String[] userTask, int[] timeMinutes) {
      window = new JFrame();
      setLayout(new GridBagLayout());

      setBackground(Color.RED);
      timeMinutesFinal =  timeMinutes;
      Timer clock = new Timer(1000, this);
        window.setTitle("MinuteBudget");
       window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setVisible(true);
        window.getContentPane().add(this);
        clock.start();
        System.out.print("Length: "+userTask.length);
        System.out.print(timeMinutes[0]);
        JLabel mainTime = new JLabel(String.valueOf(timeMinutes[current]));
        JLabel taskLabel = new JLabel(String.valueOf(userTask[current]));
        makeFonts();
        mainTime.setFont(font);
        taskLabel.setFont(font);
        mainTime.setHorizontalAlignment(JLabel.CENTER);
        add(mainTime);
        add(taskLabel);
    }

    public void actionPerformed(ActionEvent e) {
        time--;
        if(timeMinutesFinal[current]>0){
        timeMinutesFinal[current] -=1;
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