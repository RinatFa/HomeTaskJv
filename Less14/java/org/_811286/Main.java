package org._811286;

import org._811286.server.gui.ServerWindow;
import org._811286.client.gui.ClientGUI;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow, 700);
        new ClientGUI(serverWindow, 1100);
    }
}
