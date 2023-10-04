package org._811286;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;

public class ClientGUI extends JFrame {
    JButton button1, button2;
    JTextField textField1, textField2, textField3;
    JTextField textField4, textField5;
    JTextArea textArea;
    JLabel label;
    JPanel panel, panel2, panel3;
    private static final int LEFT = 700;
    private static final int TOP = 200;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    public ClientGUI() {
        super("Chat client");

        panel = new JPanel(new BorderLayout());

        textField1 = new JTextField(50);
        textField1.setToolTipText("Текстовое поле");
        textField1.setFont(new Font("Dialog", Font.BOLD, 14));
        textField1.setHorizontalAlignment(JTextField.LEFT);
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sStr = textField1.getText();
                if (!sStr.equals("")) {
                    textArea.append(sStr + "\n");
                    textField1.setText("");
                    textField1.requestFocusInWindow();
                    try (FileWriter fw = new FileWriter("file.txt", true)) {
                        fw.write(sStr + "\n");
                        fw.flush();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(ClientGUI.this,
                                "Нет файла!");
                    }
                } else {
                    JOptionPane.showMessageDialog(ClientGUI.this,
                            "Пустая строка. Введите текст!");
                }
            }
        });
        panel.add(textField1, BorderLayout.CENTER);

        button2 = new JButton("send");
        button2.setToolTipText("Послать сообщение");
        button2.setFont(new Font("Dialog", Font.BOLD, 16));
        button2.setHorizontalAlignment(JButton.CENTER);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sStr = textField1.getText();
                if (!sStr.equals("")) {
                    textArea.append(sStr + "\n");
                    textField1.setText("");
                    textField1.requestFocusInWindow();
                    try (FileWriter fw = new FileWriter("file.txt", true)) {
                        fw.write(sStr + "\n");
                        fw.flush();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(ClientGUI.this,
                                "Нет файла!");
                    }
                } else {
                    JOptionPane.showMessageDialog(ClientGUI.this,
                            "Пустая строка. Введите текст!");
                }
            }
        });
        panel.add(button2, BorderLayout.EAST);

        add(panel, BorderLayout.SOUTH);

        panel2 = new JPanel(new GridLayout(2, 3));
        textField2 = new JTextField("127.0.0.1", 20);
        textField2.setEditable(false);
        textField2.setFocusable(false);
        textField3 = new JTextField("8189", 20);
        textField3.setEditable(false);
        textField3.setFocusable(false);
        textField4 = new JTextField("Ivan Ivanovich", 20);
        textField4.setEditable(false);
        textField4.setFocusable(false);
        textField5 = new JTextField("********", 20);
        textField5.setEditable(false);
        textField5.setFocusable(false);
        textField2.setFont(new Font("Dialog", Font.BOLD, 14));
        textField3.setFont(new Font("Dialog", Font.BOLD, 14));
        textField4.setFont(new Font("Dialog", Font.BOLD, 14));
        textField5.setFont(new Font("Dialog", Font.BOLD, 14));
        label = new JLabel();
        button1 = new JButton("login");
        button1.setFont(new Font("Dialog", Font.BOLD, 16));
        panel2.add(textField2);
        panel2.add(textField3);
        panel2.add(label);
        panel2.add(textField4);
        panel2.add(textField5);
        panel2.add(button1);
        add(panel2, BorderLayout.NORTH);

        panel3 = new JPanel(new GridLayout(1, 1));
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("");
        textArea.setFont(new Font("Dialog", Font.BOLD, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFocusable(false);
        textArea.addMouseListener(new MouseAdapter() {
        });
        panel3.add(new JScrollPane(textArea));
        add(panel3, BorderLayout.CENTER);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.setVisible(false);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(LEFT, TOP);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        addWindowFocusListener(new WindowAdapter() {
            public void windowGainedFocus(WindowEvent e) {
                textField1.requestFocusInWindow();
            }
        });
        setVisible(true);
    }
}
