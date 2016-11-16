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
    private static int time = 10000;
    private static int timeMinutes = 1000;
    private static String userTask = "temp!";
    private static int finalTime = 0;
    private static int seconds = 0;
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

    static class startPanel extends JFrame implements ActionListener {
        JPanel mainframe;
        Dimension size;
        double panelHeight;
        double panelWidth;
        JTextField link;
        String selectedHint = "Temporary, declared below in the function 'selectHint' ";
      private String[] task = { "conquer the world!", "build a rocket!", 
        "find the highest prime number!", "do my homework!", "find a new element!",
      "invent something!"
      };
        private String[] minutes = {"5","10","15","20","25","30","35","40","45","50","55","60", "75","90","105", "120"};

        JComboBox minutesComboBox = new JComboBox(minutes);
        public startPanel() {

           selectHint();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            double width = screenSize.getWidth();
            double height = screenSize.getHeight();
            JLabel text = new JLabel("For the next ");
            JLabel text2 = new JLabel("minutes, I am going to ");
            JButton jb = new JButton();
            link = new JTextField(20);
            link.setUI(new JTextFieldHintUI(selectedHint, Color.gray)); 
            mainframe = new JPanel();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jb.setText("Start task!");
            jb.setHorizontalAlignment(JButton.CENTER);
            jb.addActionListener(this);
            mainframe.add(text);
            mainframe.add(minutesComboBox);
            mainframe.add(text2);
            mainframe.add(link);
            mainframe.add(jb);
            getContentPane().add(mainframe);
            pack();
            setVisible(true);
            checkSize();
            setBounds((int)(width/2)-(int)(panelWidth/2),(int)(height/2)-(int)(panelHeight/2), (int)panelWidth, 100);

        }
        public void actionPerformed(ActionEvent start) {
          System.out.print(link.getText().toString());
          new MinuteBudget();
          userTask = link.getText().toString();
          time = 60*(Integer.parseInt(minutesComboBox.getSelectedItem().toString())); //amount of seconds
          timeMinutes = Integer.parseInt(minutesComboBox.getSelectedItem().toString()); //amount of minutes
          finalTime = time/60;
          seconds = 60;
          setVisible(false); 
          dispose();
        }
        public void checkSize(){
            size = getContentPane().getSize();
            panelHeight = size.getHeight();
            panelWidth = size.getWidth();
            System.out.print("Width"+panelWidth+"Height"+ panelHeight);
        }
        public void selectHint(){
        Random newRandom = new Random();
        int i = newRandom.nextInt(task.length);
        selectedHint = task[i];
        }
        class DrawPane extends JPanel {
            public void paintComponent(Graphics g) {

            }
        }
    }

    class DrawPane extends JPanel {
        public void paintComponent(Graphics g) {
            Dimension screenSize = this.getBounds().getSize();
            double width = screenSize.getWidth();
            double height = screenSize.getHeight();
            makeFonts();
            g.setFont(font);
            FontMetrics fontMetrics = g.getFontMetrics(font);
            FontMetrics fontMetrics2 = g.getFontMetrics(font2);
            FontMetrics fontMetrics3 = g.getFontMetrics(font3);
            FontMetrics fontMetrics4 = g.getFontMetrics(font4);
            String printString = "You have " + Integer.toString(finalTime) + " minutes left!";
            String printStringSeconds = "and " + seconds + " seconds";
            int timeLength = fontMetrics.stringWidth(printString);
            int timeHeight = fontMetrics.getHeight();
            int universalLength = fontMetrics.stringWidth(printString);
            int universalHeight = fontMetrics.getHeight();
            Color mainText = new Color(255, 255, 255, 255);
            super.paintComponent(g);
            setBackground(Color.WHITE);
            g.setColor(Color.BLACK);
            g.drawString(printString, (int)((width / 2) - (timeLength / 2)), (int)((height / 2) - (timeHeight / 2)));
            g.setFont(font2);
            g.drawString(printStringSeconds, (int)((width / 2) - (timeLength / 2)), (int)((height / 2) - (timeHeight / 2))+50);
            g.setFont(font3);
            universalLength = fontMetrics3.stringWidth(postureString);
            universalHeight = fontMetrics3.getHeight();
            g.drawString(postureString, 0,(int)(height-(universalHeight)));
            g.setFont(font4);
            universalLength = fontMetrics4.stringWidth(userTask);
            universalHeight = fontMetrics4.getHeight();
            g.drawString(userTask, (int)((width / 2) - (universalLength / 2)), 0+ (universalHeight));
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
        new startPanel();

    }

}