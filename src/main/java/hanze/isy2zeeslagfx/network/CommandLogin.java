package hanze.isy2zeeslagfx.network;

public class CommandLogin implements Command {

    ServerConnection2 server = ServerConnection2.getInstance();

    @Override
    public void execute() {
        server.login("poep"); //TODO argumenten verwerken van de login
    }
}
