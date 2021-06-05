package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Interface extends JFrame{ //implements Runnable
    private JLabel Label;
    public JTextField serverChatInput;
    public JTextArea serverChatOutput;
    public JButton SendButton;
    private JPanel mainPanel;
    private JScrollPane areaScrollPane;



    public Interface(String name){
        areaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setViewportView(serverChatOutput);
        Label.setText(name);
        setResizable(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

}
