package hanze.isy2zeeslagfx.network;

import static java.lang.System.out;

public class CommandChallengePlayer implements Command{

    Receiver receiver;

    public CommandChallengePlayer(Receiver receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
//        System.out.println("Challenging " + playerName + " for " + gameName + "...");
//        out.println("challenge " + playerName + " " + gameName);
    }
}
