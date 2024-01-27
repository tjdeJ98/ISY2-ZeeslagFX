package hanze.isy2zeeslagfx.network;

import static java.lang.System.out;

public class CommandQueueGame implements Command{

    Receiver receiver;

    public CommandQueueGame(Receiver receiver)
    {
        this.receiver = receiver;
    }



    @Override
    public void execute() {
//        System.out.println("Queueing for " + gameName + "...");
//        out.println("subscribe " + gameName);
    }
}
