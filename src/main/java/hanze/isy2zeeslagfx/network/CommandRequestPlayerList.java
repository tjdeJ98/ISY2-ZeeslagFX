package hanze.isy2zeeslagfx.network;

import static java.lang.System.out;

public class CommandRequestPlayerList implements Command{
    Receiver receiver;

    public CommandRequestPlayerList(Receiver receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("Requesting playerlist...");
        out.println("get playerlist");
    }
}
