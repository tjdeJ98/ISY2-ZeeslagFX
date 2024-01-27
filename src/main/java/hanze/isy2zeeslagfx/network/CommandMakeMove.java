package hanze.isy2zeeslagfx.network;

import static java.lang.System.out;

public class CommandMakeMove implements Command {
    Receiver receiver;

    public CommandMakeMove(Receiver receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
//        System.out.println("Hitting " + index + "...");
//        out.println("move " + index);
    }
}
