package org._811286.server.gui;

import org._811286.server.domain.Server;
import org._811286.server.repository.FileStorage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;

public class ServerWindow extends JFrame implements ServerView {
    public static final String FRM_TITLE = "Chat server";
    public static final String SRV_UP = "Запустить сервер";
    public static final String SRV_DOWN = "Остановить сервер";
    public static final String FD = "Dialog";

    public static final int LEFT = 300;
    public static final int TOP = 200;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;

    private Server server;

    JButton btnStart, btnStop;
    JTextArea tarNote;
    JPanel panBtn, panNote;

    public ServerWindow() {
        super(FRM_TITLE);
        server = new Server(this, new FileStorage());

        add(createMainPanel());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(LEFT, TOP);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setVisible(true);
    }

    public Server getConnection() {
        return server;
    }

    private Component createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        panel.add(createNotePanel(), BorderLayout.CENTER);
        panel.add(createBtnPanel(), BorderLayout.SOUTH);
        return panel;
    }

    private Component createNotePanel() {
        panNote = new JPanel(new GridLayout(1, 1));

        tarNote = new JTextArea();
        tarNote.setEditable(false);
        tarNote.setFont(new Font(FD, Font.BOLD, 14));
        tarNote.setLineWrap(true);
        tarNote.setWrapStyleWord(true);
        tarNote.setFocusable(false);

        panNote.add(new JScrollPane(tarNote));
        return panNote;
    }

    private Component createBtnPanel() {
        panBtn = new JPanel(new GridLayout(1, 2));

        btnStart = new JButton("Start");
        btnStart.setToolTipText(SRV_UP);
        btnStart.setFont(new Font(FD, Font.BOLD, 16));
        btnStart.setHorizontalAlignment(JButton.CENTER);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
            }
        });

        btnStop = new JButton("Stop");
        btnStop.setToolTipText(SRV_DOWN);
        btnStop.setFont(new Font(FD, Font.BOLD, 16));
        btnStop.setHorizontalAlignment(JButton.CENTER);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
            }
        });

        panBtn.add(btnStart);
        panBtn.add(btnStop);
        return panBtn;
    }

    @Override
    public void appendLog(String text) {
        tarNote.append(text);
    }
}
