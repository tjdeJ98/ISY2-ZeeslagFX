package hanze.isy2zeeslagfx.network;

import static java.lang.System.out;

public class CommandQueueGame implements Command{

    Receiver receiver;
    private String gameName;

    public CommandQueueGame(Receiver receiver, String gameName)
    {
        this.receiver = receiver;
        this.gameName = gameName;
    }



    @Override
    public void execute() {
        System.out.println("Queueing for " + gameName + "...");
        out.println("subscribe " + gameName);
    }
}
