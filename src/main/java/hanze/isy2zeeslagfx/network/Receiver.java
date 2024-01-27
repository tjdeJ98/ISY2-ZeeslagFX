package hanze.isy2zeeslagfx.network;

import java.io.IOException;

import static java.lang.System.out;


public class Receiver {

    public void login(String name)
    {
        out.println("Logging in as " + name);
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
