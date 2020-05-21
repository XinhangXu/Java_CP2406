package com.org.transport;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;


public class SettingGui extends JFrame {
    static JTextField redText;
    static JTextField greenText;
    static JTextField delayText;
    static JTextField SNText;
    static JTextField EWText;


    public SettingGui() {
        getContentPane().setLayout(null);

        redText = new JTextField();
        redText.setBounds(500, 178, 86, 21);//x, y, length, width
        getContentPane().add(redText);
        redText.setColumns(10);

        JButton startButton = new JButton("OK");
        startButton.setBounds(330, 470, 91, 23);
        getContentPane().add(startButton);

        greenText = new JTextField();
        greenText.setBounds(500, 225, 86, 21);
        getContentPane().add(greenText);
        greenText.setColumns(10);

        JLabel redLabel = new JLabel("Red Light Duration (s)");
        redLabel.setBounds(250, 183, 190, 15);
        getContentPane().add(redLabel);

        JLabel greenLabel = new JLabel("Green Light Duration (s)");
        greenLabel.setBounds(250, 230, 200, 15);
        getContentPane().add(greenLabel);

        Component verticalGlue = Box.createVerticalGlue();
        verticalGlue.setBounds(62, 230, 1, 1);
        getContentPane().add(verticalGlue);

        delayText = new JTextField();
        delayText.setBounds(500, 270, 86, 21);
        getContentPane().add(delayText);
        delayText.setColumns(10);

        JLabel delayLabel = new JLabel("Green Light Delay Time (s)");
        delayLabel.setBounds(250, 270, 200, 15);
        getContentPane().add(delayLabel);

        JLabel lblNewLabel = new JLabel("North and South Intersection");
        lblNewLabel.setBounds(250, 310, 200, 15);
        getContentPane().add(lblNewLabel);

        SNText = new JTextField();
        SNText.setBounds(500, 310, 86, 21);
        getContentPane().add(SNText);
        SNText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Distace between cars");
        lblNewLabel_1.setBounds(250, 350, 200, 15);
        getContentPane().add(lblNewLabel_1);

        EWText = new JTextField();
        EWText.setBounds(500, 350, 86, 21);
        getContentPane().add(EWText);
        EWText.setColumns(10);

        JLabel label = new JLabel("Traffic Simulator ver2.0");
        label.setBounds(310, 60, 200, 15);
        getContentPane().add(label);


        
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        SimpleListener ourListener = new SimpleListener();
        startButton.addActionListener(ourListener);
    }

    private class SimpleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub

            FrameDemo demo = new FrameDemo();
        }

    }

    public static void main(String[] args) {
        SettingGui demo = new SettingGui();
    }
}