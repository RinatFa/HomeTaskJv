package org._811286.client.domain;

import org._811286.client.gui.ClientView;
import org._811286.server.domain.Server;

public class Client {
    public static final String CONN_UP = "Вы успешно подключились!";
    public static final String CONN_DOWN = "Подключение не удалось";
    public static final String CONN_BRAIKE = "Вы были отключены от сервера!";
    public static final String CONN_NO = "Нет подключения к серверу";

    private boolean bConnect = false;
    private String sName;
    private ClientView clientView;
    private Server server;

    public Client(ClientView clientView, Server server) {
        this.clientView = clientView;
        this.server = server;
    }

    public void answer(String text) {
        appendLog(text);
    }

    public boolean connectToServer(String sName) {
        this.sName = sName;
        if (server.connectUser(this)) {
            appendLog(CONN_UP + "\n");
            bConnect = true;
            String log = server.getLog();
            if (log != null) {
                appendLog(log);
            }
            return true;
        } else {
            appendLog(CONN_DOWN);
            return false;
        }
    }

    public void disconnectFromServer() {
        if (bConnect) {
            bConnect = false;
            clientView.disconnectFromServer();
            server.disconnectUser(this);
            appendLog(CONN_BRAIKE);
        }
    }

    public void message(String text) {
        if (bConnect) {
            if (!text.equals("")) {
                server.message(sName + ": " + text);
            }
        } else {
            appendLog(CONN_NO);
        }
    }

    public String getName() {
        return sName;
    }

    private void appendLog(String text) {
        clientView.appendLog(text + "\n");
    }
}
