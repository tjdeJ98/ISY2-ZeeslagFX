package hanze.isy2zeeslagfx.network;

public class CommandQuit implements Command{

    Receiver receiver;

    public CommandQuit(Receiver receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.quit();
    }
}
