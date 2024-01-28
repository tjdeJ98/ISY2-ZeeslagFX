package hanze.isy2zeeslagfx.network;

import static java.lang.System.out;

public class CommandPlaceShip implements Command {

    Receiver receiver;
    private int beginIndex;
    private int endIndex;

    public CommandPlaceShip(Receiver receiver, int beginIndex, int endIndex)
    {
        this.receiver = receiver;
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void execute() {
        System.out.println("Placing ship for on " + beginIndex + " / " + endIndex);
        out.println("place " + beginIndex + " " + endIndex);
    }
}
