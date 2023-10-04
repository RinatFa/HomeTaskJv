package org._811286;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;

public class ServerWindow extends JFrame {
    JButton button, button2, button3, button4, button5;
    JTextArea textArea;
    JPanel panel, panel2;
    ClientGUI сhatсlient;

    private static final int LEFT = 300;
    private static final int TOP = 200;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;
    public static boolean bStartstop = false;

    public ServerWindow() {
        super("Chat server");

        panel = new JPanel(new GridLayout(1, 2));

        button = new JButton("Start");
        button.setToolTipText("Запустить сервер");
        button.setFont(new Font("Dialog", Font.BOLD, 16));
        button.setHorizontalAlignment(JButton.CENTER);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!bStartstop) {
                    JOptionPane.showMessageDialog(ServerWindow.this,
                            "Сервер запущен!");
                    bStartstop = true;
                } else {
                    JOptionPane.showMessageDialog(ServerWindow.this,
                            "Сервер уже запущен, сервер работает!");
                }
            }
        });
        panel.add(button);

        button2 = new JButton("Stop");
        button2.setToolTipText("Остановить сервер");
        button2.setFont(new Font("Dialog", Font.BOLD, 16));
        button2.setHorizontalAlignment(JButton.CENTER);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bStartstop) {
                    JOptionPane.showMessageDialog(ServerWindow.this,
                            "Сервер остановлен!");
                    bStartstop = false;
                } else {
                    JOptionPane.showMessageDialog(ServerWindow.this,
                            "Сервер уже остановлен, сервер не работает!");
                }
            }
        });
        panel.add(button2);

        add(panel, BorderLayout.SOUTH);

        panel2 = new JPanel(new GridLayout(1, 1));
        textArea = new JTextArea();
        textArea.setEditable(false);

        String sStr = "";
        try (BufferedReader br = new BufferedReader(
                new FileReader("file.txt"));) {
            String str;
            while ((str = br.readLine()) != null) {
                sStr += (str + "\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(ServerWindow.this,
                    "Нет файла!");
        }

        textArea.setText(sStr);
        textArea.setFont(new Font("Dialog", Font.BOLD, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFocusable(false);
        textArea.addMouseListener(new MouseAdapter() {
        });
        panel2.add(new JScrollPane(textArea));
        add(panel2, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(LEFT, TOP);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setVisible(true);
    }
}
