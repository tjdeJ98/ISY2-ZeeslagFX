package hanze.isy2zeeslagfx.network;

import static java.lang.System.out;

public class CommandForfeit implements Command {
    Receiver receiver;

    public CommandForfeit(Receiver receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("Surrendering...");
        out.println("forfeit");
    }
}
