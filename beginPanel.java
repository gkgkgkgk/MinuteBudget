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



public class beginPanel extends JPanel implements ActionListener{
 JFrame window;
         private String[] taskamountArray = {"1","2","3","4","5","6","7","8","9","10"};
                 JComboBox<String> taskAmountBox = new JComboBox<String>(taskamountArray);
  public beginPanel(){
   window = new JFrame();
   JButton begin = new JButton();
   JLabel text = new JLabel("I am going to complete");
   JLabel text2 = new JLabel("tasks!");
    begin.setText("Set up your schedule!");
    begin.addActionListener(this);
    add(text);
    add(taskAmountBox);
        add(text2);
    add(begin);
    window.getContentPane().add(this);
     window.pack();
     window.setVisible(true);
  }

public void actionPerformed(ActionEvent start) {
            System.out.println(taskAmountBox.getSelectedItem());
          SetupPanel newPanel = new SetupPanel(Integer.parseInt(taskAmountBox.getSelectedItem().toString()));
          setVisible(false); 
          window.dispose();
        }
}