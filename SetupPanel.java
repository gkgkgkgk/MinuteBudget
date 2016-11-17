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
    JFrame window;
    JPanel mainframe;
    Dimension size;
    double panelHeight;
    double panelWidth;
    JTextField link[];
    String selectedHint = "Temporary, declared below in the function 'selectHint' ";
    private String[] task = {
        "conquer the world!", "build a rocket!",
        "find the highest prime number!", "do my homework!", "find a new element!",
        "invent something!"
    };
    private String[] minutes = {
        "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "75", "90", "105", "120"
    };
    JComboBox < String > minutesComboBox = new JComboBox < String > (minutes);

    public SetupPanel(int amount) {
      JComboBox [] minuteCB = new JComboBox[amount];
      for(int m = 0; m < amount; m++){
      minuteCB[m] =  new JComboBox < String > (minutes);
      }
      amount = amount;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        window = new JFrame();
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
        text2[k] =  new JLabel("minutes, I am going to ");
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
        jb.setText("Start task!");
        jb.setHorizontalAlignment(JButton.CENTER);
        jb.addActionListener(this);
        window.getContentPane().add(this);
        //window.getContentPane().add(mainframe);
        window.pack();
        window.setVisible(true);
        checkSize();
        setBounds((int)(width / 2) - (int)(panelWidth / 2), (int)(height / 2) - (int)(panelHeight / 2), (int) panelWidth, 100);

    }
    public void actionPerformed(ActionEvent start) {
        new MinuteBudget();
        for(int i = 0; i < amount; i++){
        MinuteBudget.userTask[i] = link[i].getText().toString();
        }
        MinuteBudget.time = 60 * (Integer.parseInt(minutesComboBox.getSelectedItem().toString())); //amount of seconds
        MinuteBudget.timeMinutes = Integer.parseInt(minutesComboBox.getSelectedItem().toString()); //amount of minutes
        MinuteBudget.finalTime = MinuteBudget.time / 60;
        MinuteBudget.seconds = 60;
        setVisible(false);
        window.dispose();
    }
    public void checkSize() {
        size = window.getContentPane().getSize();
        panelHeight = size.getHeight();
        panelWidth = size.getWidth();
        System.out.print("Width" + panelWidth + "Height" + panelHeight);
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