package com.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {
    private JPanel panel1;
    private JButton voteButton;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;

    private String buttonString = "Vote for: ";
    private String candidate = "";

    public App() {

        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                candidate = e.getActionCommand();
                System.out.println(candidate);
                voteButton.setText(buttonString + candidate);
            }
        });
        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                candidate = e.getActionCommand();
                candidate = e.getActionCommand();
                System.out.println(candidate);
                voteButton.setText(buttonString + candidate);
            }
        });
        radioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                candidate = e.getActionCommand();
                candidate = e.getActionCommand();
                System.out.println(candidate);
                voteButton.setText(buttonString + candidate);
            }
        });
        radioButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                candidate = e.getActionCommand();
                System.out.println(candidate);
                voteButton.setText(buttonString + candidate);
            }
        });
        voteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String candidateWithoutSpaces = candidate.replaceAll("\\s+","");
                    URL url = new URL("http://127.0.0.1:5000/vote?candidate=" + candidateWithoutSpaces);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    con.setRequestProperty("Content-Type", "application/json");
                    con.setConnectTimeout(5000);
                    con.setReadTimeout(5000);

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer content = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    in.close();
                } catch (Exception error) {
                    throw new Error(error);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pretend this is a phone");
        frame.setContentPane(new App().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(360, 640));
        frame.setVisible(true);
    }
}
