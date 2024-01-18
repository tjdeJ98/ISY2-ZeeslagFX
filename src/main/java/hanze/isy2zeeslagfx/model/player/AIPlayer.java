package hanze.isy2zeeslagfx.model.player;

public class AIPlayer implements Player {
    private final String name;

    public AIPlayer(String name)
    {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
