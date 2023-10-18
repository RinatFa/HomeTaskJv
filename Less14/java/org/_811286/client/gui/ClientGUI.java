package org._811286.client.gui;

import org._811286.client.domain.Client;
import org._811286.server.gui.ServerWindow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;

public class ClientGUI extends JFrame implements ClientView {
    public static final String FRM_TITLE = "Chat client";
    public static final String TXT_TOOLTIP = "Текстовое поле";
    public static final String BTN_TOOLTIP = "Послать сообщение";
    public static final String FD = "Dialog";

    private int LEFT = 0;
    public static final int TOP = 200;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    private Client client;

    JButton btnLogin, btnSend;
    JTextField txtSend, txtIP, txtPort, txtLogin;
    JPasswordField txtPassw;
    JTextArea tarNote;
    JLabel lblBlank;
    JPanel panSend, panLogin, panNote;

    public ClientGUI(ServerWindow server, int LEFT) {
        super(FRM_TITLE);
        this.setLEFT(LEFT);
        client = new Client(this, server.getConnection());

        add(createMainPanel());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(this.LEFT, TOP);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        addWindowFocusListener(new WindowAdapter() {
            public void windowGainedFocus(WindowEvent e) {
                txtSend.requestFocusInWindow();
            }
        });
        setVisible(true);
    }

    private Component createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        panel.add(createLoginPanel(), BorderLayout.NORTH);
        panel.add(createNotePanel(), BorderLayout.CENTER);
        panel.add(createSendPanel(), BorderLayout.SOUTH);
        return panel;
    }

    private Component createLoginPanel() {
        panLogin = new JPanel(new GridLayout(2, 3));

        txtIP = new JTextField("127.0.0.1", 20);
        txtIP.setEditable(false);
        txtIP.setFocusable(false);
        txtIP.setFont(new Font(FD, Font.BOLD, 14));
        txtPort = new JTextField("8189", 20);
        txtPort.setEditable(false);
        txtPort.setFocusable(false);
        txtPort.setFont(new Font(FD, Font.BOLD, 14));
        txtLogin = new JTextField("Ivan Ivanovich", 20);
        txtLogin.setFont(new Font(FD, Font.BOLD, 14));
        txtPassw = new JPasswordField("12345678", 20);
        txtPassw.setFont(new Font(FD, Font.BOLD, 14));
        lblBlank = new JLabel();
        btnLogin = new JButton("login");
        btnLogin.setFont(new Font(FD, Font.BOLD, 16));

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        panLogin.add(txtIP);
        panLogin.add(txtPort);
        panLogin.add(lblBlank);
        panLogin.add(txtLogin);
        panLogin.add(txtPassw);
        panLogin.add(btnLogin);
        return panLogin;
    }

    private Component createNotePanel() {
        panNote = new JPanel(new GridLayout(1, 1));

        tarNote = new JTextArea();
        tarNote.setEditable(false);
        tarNote.setText("");
        tarNote.setFont(new Font(FD, Font.BOLD, 14));
        tarNote.setLineWrap(true);
        tarNote.setWrapStyleWord(true);
        tarNote.setFocusable(false);

        panNote.add(new JScrollPane(tarNote));
        return panNote;
    }

    private Component createSendPanel() {
        panSend = new JPanel(new BorderLayout());

        txtSend = new JTextField(50);
        txtSend.setToolTipText(TXT_TOOLTIP);
        txtSend.setFont(new Font(FD, Font.BOLD, 14));
        txtSend.setHorizontalAlignment(JTextField.LEFT);
        txtSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });

        btnSend = new JButton("send");
        btnSend.setToolTipText(BTN_TOOLTIP);
        btnSend.setFont(new Font(FD, Font.BOLD, 16));
        btnSend.setHorizontalAlignment(JButton.CENTER);
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });

        panSend.add(txtSend);
        panSend.add(btnSend, BorderLayout.EAST);
        return panSend;
    }

    public void disconnectFromServer() {
        hideLoginPanel(true);
        client.disconnectFromServer();
    }

    public void hideLoginPanel(boolean visible) {
        panLogin.setVisible(visible);
    }

    public void login() {
        if (client.connectToServer(txtLogin.getText())) {
            hideLoginPanel(false);
        }
    }

    public void message() {
        client.message(txtSend.getText());
        txtSend.setText("");
        txtSend.requestFocusInWindow();
    }

    public void appendLog(String text) {
        tarNote.append(text);
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            disconnectFromServer();
        }
    }

    public int getLEFT() {
        return LEFT;
    }

    public void setLEFT(int Left) {
        if ((Left < 0) || (Left > 1500)) {
            return;
        }
        LEFT = Left;
    }
}
