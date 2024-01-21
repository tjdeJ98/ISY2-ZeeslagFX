package hanze.isy2zeeslagfx.network;

import java.net.Socket;

public class ServerConnection {

    private volatile static ServerConnection instance;

    private ServerConnection() {}

    public static ServerConnection getInstance() {

        if (instance == null) {
            synchronized (ServerConnection.class) {
                if (instance == null) {
                    instance = new ServerConnection();
                }
            }
        }
        return instance;
    }
}

