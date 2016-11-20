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



public class SetupPanel extends JPanel implements ActionListener {
    public static int amount = 1;
        public static int finalAmount;
    JFrame window;
    JPanel mainframe;
    Dimension size;
    double panelHeight;
    double panelWidth;
    JTextField link[];
    String selectedHint = "Temporary Placeholder, declared below in the function 'selectHint' ";
    private String[] task = {
        "do homework.", "write a report", "write a book", "build a rocket!",
        "do my homework!", 
        "invent something!", "eat lunch.", "stretch.", "study for an exam!", 
    };
    private String[] minutes = {
        "1", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "75", "90", "105", "120"
    };
    JComboBox < String > minutesComboBox = new JComboBox < String > (minutes);
JComboBox [] minuteCB;
    public SetupPanel(int amount) {
      JLabel textOne = new JLabel("Which tasks will you complete?");

      finalAmount = amount;
      minuteCB = new JComboBox[amount];
      for(int m = 0; m < amount; m++){
      minuteCB[m] =  new JComboBox < String > (minutes);
      }
      amount = amount;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        window = new JFrame();
              add(textOne);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        link = new JTextField[amount];
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        JLabel[] text = new JLabel[amount];
        for(int j= 0; j < amount; j++){
        text[j] = new JLabel("For the next");
        }
        JLabel text2[] = new JLabel[amount];
          for(int k= 0; k < amount; k++){
        text2[k] =  new JLabel("minute(s), I am going to ");
        }

        JButton jb = new JButton();
        for(int i = 0; i < amount; i++){
          link[i] = new JTextField(20);
          selectHint();
          link[i].setUI(new JTextFieldHintUI(selectedHint, Color.gray));
        }
        System.out.println("amt:  " + amount);
        for (int i = 0; i < amount; i++) {
            add(new taskPanel(text[i], minuteCB[i], text2[i], link[i]));

        }
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jb.setText("Start working!");
        jb.setHorizontalAlignment(JButton.CENTER);
        jb.addActionListener(this);
        window.getContentPane().add(this);
        add(jb);
        //window.getContentPane().add(mainframe);
        window.pack();
        window.setVisible(true);
        checkSize();
        setBounds((int)(width / 2) - (int)(panelWidth / 2), (int)(height / 2) - (int)(panelHeight / 2), (int) panelWidth, 100);

    }
    public void actionPerformed(ActionEvent start) {
        int[] minutes = new int[finalAmount];
        String[] tasks = new String[finalAmount];
        for (int i = 0; i< finalAmount; i++){
        minutes[i] = Integer.parseInt(minuteCB[i].getSelectedItem().toString());
        tasks[i] = link[i].getText();

        }
                System.out.println("array amt: "+finalAmount);
        new MinuteBudget(tasks, minutes);
        setVisible(false);
        window.dispose();
    }
    public void checkSize() {
        size = window.getContentPane().getSize();
        panelHeight = size.getHeight();
        panelWidth = size.getWidth();
    }
    public void selectHint() {
        Random newRandom = new Random();
        int i = newRandom.nextInt(task.length);
        selectedHint = task[i];
    }
    class DrawPane extends JPanel {
        public void paintComponent(Graphics g) {

        }
    }

}