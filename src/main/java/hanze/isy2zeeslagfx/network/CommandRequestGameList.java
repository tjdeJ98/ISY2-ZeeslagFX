package hanze.isy2zeeslagfx.network;

import static java.lang.System.out;

public class CommandRequestGameList implements Command{
    Receiver receiver;

    public CommandRequestGameList(Receiver receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("Requesting gamelist...");
        out.println("get gamelist");
    }
}
