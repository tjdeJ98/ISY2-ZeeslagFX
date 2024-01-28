package hanze.isy2zeeslagfx.network;

import static java.lang.System.out;

public class CommandChallengePlayer implements Command{

    Receiver receiver;
    private String playerName;
    private String gameName;

    public CommandChallengePlayer(Receiver receiver,String playerName, String gameName)
    {
        this.receiver = receiver;
        this.playerName = playerName;
        this.gameName = gameName;
    }

    @Override
    public void execute() {
        System.out.println("Challenging " + playerName + " for " + gameName + "...");
        out.println("challenge " + playerName + " " + gameName);
    }
}
