package hanze.isy2zeeslagfx.network;

import static java.lang.System.out;

public class CommandMakeMove implements Command {

    Receiver receiver;
    private int index;

    public CommandMakeMove(Receiver receiver)
    {
        this.receiver = receiver;
        this.index = index;
    }

    @Override
    public void execute() {
        System.out.println("Hitting " + index + "...");
        out.println("move " + index);
    }
}
