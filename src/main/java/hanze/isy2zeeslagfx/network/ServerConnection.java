package hanze.isy2zeeslagfx.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerConnection {

    private String hostName = "127.0.0.1"; // localhost address TODO config
    private int portNumber = 7789; // port nummer van de server TODO config
    private Socket client; // aanmaken van de socket
    private BufferedReader in; // aanmaken van input reader
    private PrintWriter out; // aanmaken van output writer TODO observer pattern, apparte thread
    private boolean done = false; // boolean die aangeeft of we nog verbinding hebben (voor de UI)

    private volatile static ServerConnection instance;

    private ServerConnection()
    {
    }

    public static ServerConnection getInstance()
    {

        if (instance == null) {
            synchronized (ServerConnection.class) {
                if (instance == null) {
                    instance = new ServerConnection();
                }
            }
        }
        return instance;
    }

    /**
     * Deze methode verbreekt de verbinding met de server en logt onze user uit
     */
    public void shutdown()
    {
        done = true;
        try {
            quit(); // we loggen eerst netjes uit, zodat we daarna met dezelfde naam weer in kunnen loggen
            in.close();
            out.close();
            if(!client.isClosed()) {
                client.close();
            }
        } catch (IOException e) {
            //we negeren een exception omdat we toch de verbinding verbreken
        }
    }

    public void login(String name)
    {
        System.out.println("Logging in as " + name + "...");
        out.println("login " + name);
    }
    
    public void quit()
    {
        System.out.println("Logging out...");
        out.println("quit");
    }

    public void queueGame(String gameName)
    {
        System.out.println("Queueing for " + gameName + "...");
        out.println("subscribe " + gameName);
    }

    public void challengePlayer(String playerName, String gameName)
    {
        System.out.println("Challenging " + playerName + " for " + gameName + "...");
        out.println("challenge " + playerName + " " + gameName);
    }

    public void placeShip(int beginIndex, int endIndex)
    {
        System.out.println("Placing ship for on " + beginIndex + " / " + endIndex);
        out.println("place " + beginIndex + " " + endIndex);
    }

    public void makeMove(int index)
    {
        System.out.println("Hitting " + index + "...");
        out.println("move " + index);
    }

    public void forfeit()
    {
        System.out.println("Surrendering...");
        out.println("forfeit");
    }

    public void requestGameList()
    {
        System.out.println("Requesting gamelist...");
        out.println("get gamelist");
    }

    public void requestPlayerList()
    {
        System.out.println("Requesting playerlist...");
        out.println("get playerlist");
    }

}


