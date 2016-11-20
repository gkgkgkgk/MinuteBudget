//written by GKGKGKGK
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.FontFormatException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

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
    int stepCounter = 0;
    public static int current = 0;
    public static int time = 10000;
    public static int[] timeMinutesFinal;
    public static String[] userTaskFinal;
    private static int stand = 8 * 60;
    private static int sit = 20 * 60;
    private static int move = 2 * 60;
    public int currentSeconds;
    private static String postureString = "";
    private static Font font, font2, font3, font4;
    
    public static JFrame window;
    
    int secondsInMinute = 59;
    JLabel seconds, taskLabel, mainTime, action;
    JButton showTasks;
    public MinuteBudget(String[] userTask, int[] timeMinutes) {
      userTaskFinal = userTask;
        window = new JFrame();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        setBackground(Color.WHITE);
        timeMinutesFinal = timeMinutes;
        currentSeconds = timeMinutesFinal[current] * 60;
        Timer clock = new Timer(1000, this);
        window.setTitle("MinuteBudget");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setVisible(true);
        window.getContentPane().add(this);
        clock.start();
        System.out.print("Length: " + userTask.length);
        System.out.print(timeMinutes[0]);
        mainTime = new JLabel(String.valueOf((int)(currentSeconds / 60) - 1) + " minutes left");
        taskLabel = new JLabel(String.valueOf(userTask[current]));
        action = new JLabel("Sit down... Relax...");
        seconds = new JLabel("60");
        taskList e = new taskList();
        showTasks = new JButton("Show Tasks");
        showTasks.addActionListener(e);
        makeFonts();
        mainTime.setFont(font4);
        taskLabel.setFont(font);
        action.setFont(font);
        seconds.setFont(font2);
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 2;
        c.gridy = 0;
        add(action, c);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        add(taskLabel, c);

        c.gridwidth = 0;
        c.gridheight = 0;
        c.gridx = 1;
        c.gridy = 3;
        add(seconds, c);

        c.gridx = 1;
        c.gridy = 1;
        add(mainTime, c);
        

        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.gridx = 0;
        c.gridy = 3; 
        add(showTasks, c);
        
    }

    public void actionPerformed(ActionEvent e) {
        time--;
        int step = 0;
        if(step == 0){
        action.setText("Sit down... Relax...");
        }
        else if(step == 1){
        action.setText("Stand up for a bit");
        }
        else {
        action.setText("Stretch! Take a walk for two minutes.");
        }
        //System.out.print(step);
        stepCounter +=1;
        if(stepCounter<= 20*60){
        step = 0;
        }
        else if(stepCounter <= ((20*60)+(8*60)) && stepCounter > 20*60){
        step = 1;
        }
        else if(stepCounter > (20*60)+(8*60) && stepCounter <= (30*60)){
        step = 2;
        }
        else{
        step = 0;
        stepCounter = 0;
        }
        
        System.out.println(userTaskFinal.length +"   " +current);
        if (currentSeconds > 0) {
            seconds.setText(String.valueOf(secondsInMinute));
            currentSeconds -= 1;
            secondsInMinute -= 1;
            if (secondsInMinute < 0) {
                secondsInMinute = 59;
                mainTime.setText(String.valueOf((int)(currentSeconds / 60)) + " minutes left");
            }
        } 
        else if (userTaskFinal.length > current) {
            current += 1;
            taskLabel.setText(userTaskFinal[current]);
            currentSeconds = timeMinutesFinal[current] * 60;
        } 
        else {
            taskLabel.setText("You have finished! (Hopefully)");
            //completed!
        }
      
        repaint();
    }

    public void makeFonts() {
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
 public class taskList extends JFrame implements ActionListener {
  public void actionPerformed(ActionEvent open) {
    JFrame window = new JFrame();
    JPanel content = new JPanel();
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    for(int i = current; i < userTaskFinal.length; i++){
    content.add(new JLabel(userTaskFinal[i]));
    }
    window.setTitle("Current Tasks");
    window.getContentPane().add(content);
    window.setVisible(true);
            window.pack();
   }
  }
 
    public static void main(String[] args) {
        beginPanel beginPanel = new beginPanel();
    }
}