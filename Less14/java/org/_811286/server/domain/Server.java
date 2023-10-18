package org._811286.server.domain;

import org._811286.client.domain.Client;
import org._811286.server.repository.Repository;
import org._811286.server.gui.ServerView;

public class Server {
    public static final String SRV_START = "Сервер запущен!";
    public static final String SRV_STOP = "Сервер остановлен!";
    public static final String SRV_WORK = "Сервер уже запущен, сервер работает!";
    public static final String SRV_NO_WORK = "Сервер уже остановлен, сервер не работает!";

    private boolean bStartstop = false;
    private ServerView serverView;
    private Repository<String> repository;

    private int iMaxArray;
    Client[] clientArray;

    public Server(ServerView serverView, Repository<String> repository) {
        this.serverView = serverView;
        this.repository = repository;
        clientArray = new Client[2]; // _здесь на 2 клиента!
    }

    public void start() {
        if (!bStartstop) {
            appendLog(SRV_START);
            bStartstop = true;
        } else {
            appendLog(SRV_WORK);
        }
    }

    public void stop() {
        if (bStartstop) {
            bStartstop = false;
            for (int i = 0; i < iMaxArray; i++) {
                if (clientArray[i] != null) {
                    disconnectUser(clientArray[i]);
                }
            }
            iMaxArray = 0;
            appendLog(SRV_STOP);
        } else {
            appendLog(SRV_NO_WORK);
        }
    }

    public boolean connectUser(Client client) {
        if (!bStartstop) {
            return false;
        }
        clientArray[iMaxArray] = client;
        iMaxArray += 1;
        appendLog(client.getName() + " подключился к беседе");
        return true;
    }

    public String getLog() {
        return (String) repository.load();
    }

    public void disconnectUser(Client client) {
        for (int i = 0; i < iMaxArray; i++) {
            if (clientArray[i] == client) {
                clientArray[i] = null;
                appendLog(client.getName() + " отключился от беседы");
            }
        }
        if (client != null) {
            client.disconnectFromServer();
        }
    }

    public void message(String text) {
        if (!bStartstop) {
            return;
        }
        appendLog(text);
        answerAll(text);
        setLog(text);
    }

    private void answerAll(String text) {
        for (int i = 0; i < iMaxArray; i++) {
            if (clientArray[i] != null) {
                clientArray[i].answer(text);
            }
        }
    }

    private void appendLog(String text) {
        serverView.appendLog(text + "\n");
    }

    private void setLog(String text) {
        repository.save(text);
    }
}
