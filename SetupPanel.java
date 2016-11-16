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



public class SetupPanel extends JPanel implements ActionListener{
  public static int taskAmount = 1;
  JFrame window;
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
        private String[] taskamountArray = {"1","2","3","4","5","6","7","8","9","10"};
        JComboBox taskAmountBox = new JComboBox(minutes);
        JComboBox minutesComboBox = new JComboBox(taskamountArray);
       
        
        public SetupPanel() {
            window  = new JFrame();
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
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jb.setText("Start task!");
            jb.setHorizontalAlignment(JButton.CENTER);
            jb.addActionListener(this);
            mainframe.add(text);
            mainframe.add(minutesComboBox);
            mainframe.add(text2);
            mainframe.add(link);
            mainframe.add(jb);
            mainframe.add(minutesComboBox);
            window.getContentPane().add(mainframe);
            window.pack();
            window.setVisible(true);
            checkSize();
            setBounds((int)(width/2)-(int)(panelWidth/2),(int)(height/2)-(int)(panelHeight/2), (int)panelWidth, 100);

        }
        public void actionPerformed(ActionEvent start) {
          System.out.print(link.getText().toString());
          new MinuteBudget();
          MinuteBudget.userTask = link.getText().toString();
         MinuteBudget.time = 60*(Integer.parseInt(minutesComboBox.getSelectedItem().toString())); //amount of seconds
          MinuteBudget.timeMinutes = Integer.parseInt(minutesComboBox.getSelectedItem().toString()); //amount of minutes
          MinuteBudget.finalTime = MinuteBudget.time/60;
          MinuteBudget.seconds = 60;
          setVisible(false); 
          window.dispose();
        }
        public void checkSize(){
            size = window.getContentPane().getSize();
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