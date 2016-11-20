//written by GKGKGKGK
//finished at 9:41 PM
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



public class beginPanel extends JPanel implements ActionListener{
 JFrame window;
 JButton begin, help;
 String introString = "Hi, welcome to MinuteBudget. MinuteBudget helps budget your time to complete multiple tasks efficiently, quickly, and ergonomically.";
         private String[] taskamountArray = {"1","2","3","4","5","6","7","8","9","10"};
                 JComboBox<String> taskAmountBox = new JComboBox<String>(taskamountArray);
  public beginPanel(){
          JLabel intro = new JLabel(introString);
   window = new JFrame();
   begin = new JButton();
      help = new JButton("What is this?");
   JLabel text = new JLabel("I am going to complete");
   JLabel text2 = new JLabel("tasks!");
    begin.setText("Set up your schedule!");
    begin.addActionListener(this);
        help.addActionListener(this);
    add(help);
    add(text);
    add(taskAmountBox);
        add(text2);
    add(begin);
    window.getContentPane().add(this);
     window.pack();
     window.setVisible(true);
  }

public void actionPerformed(ActionEvent start) {
  if(start.getSource() == begin){
           System.out.println(taskAmountBox.getSelectedItem());
          SetupPanel newPanel = new SetupPanel(Integer.parseInt(taskAmountBox.getSelectedItem().toString()));
          setVisible(false); 
          window.dispose();}
  else{
  new whatIsMinuteBudget();
  }
        }

class whatIsMinuteBudget extends JFrame{
  public whatIsMinuteBudget(){
    JPanel one = new JPanel();
    JLabel string = new JLabel(introString);
    one.add(string);
     pack();
     setSize(800, 200);
    getContentPane().add(one);
    setVisible(true);
  }
}
}