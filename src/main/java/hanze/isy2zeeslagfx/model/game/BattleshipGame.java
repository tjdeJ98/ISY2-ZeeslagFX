package hanze.isy2zeeslagfx.model.game;

import hanze.isy2zeeslagfx.model.ai.AIStrategy;
import hanze.isy2zeeslagfx.model.player.AIPlayer;
import hanze.isy2zeeslagfx.model.player.Player;
import hanze.isy2zeeslagfx.model.player.strategy.BattleshipStrategy;

import java.util.Map;

//TODO Veel methodes die vanuit update() worden gecallt moet wss naar BattleshipStrategy worden verplaatst.
public class BattleshipGame extends Game {
    Player curPlayer;
    private final int[] startShipsLengths = {2};
    //, 4, 5, 6
    BattleshipStrategy playerStrategy;
    private boolean isOnline;
    private ConsoleHandler console;

    public BattleshipGame(String gameType, PlayersSetupType playersType, boolean isOnline)
    {
        super(gameType, playersType);
        this.isOnline = isOnline;
        givePlayersShips();
    }

    private void givePlayersShips()
    {
        for (Map.Entry<Integer, Player> player : players.entrySet()) {
            ((BattleshipStrategy) player.getValue().getStrategy()).getFleetManager().createShipsForPlayer(startShipsLengths);
        }
    }

    private void setStartPlayer()
    {
        if (curPlayer == null) {
            this.curPlayer = super.players.get(0);
        }
    }

    private void setPlayerStrategy()
    {
        this.playerStrategy = (BattleshipStrategy) curPlayer.getStrategy();
    }

    @Override
    public void switchPlayer()
    {
        this.curPlayer = getOtherPlayer();
    }

    Player getOtherPlayer()
    {
        if (super.players.get(0) == curPlayer) {
            return super.players.get(1);
        } else {
            return super.players.get(0);
        }
    }

    private boolean checkIfPlayerIsSet()
    {
        return curPlayer != null;
    }

    void playerSetupActions()
    {
        if (checkIfPlayerIsSet()) {
            switchPlayer();
        } else {
            setStartPlayer();
        }
        setPlayerStrategy();
    }

    @Override
    public void update() {
        if (isOnline) {
            // TODO play a game online
        } else {
            if (curPlayer.getName().equals("AI")) {
                ((AIPlayer) curPlayer).getAiStrategy().update();
            } else {
                console = new ConsoleHandler(this);
                console.update();
            }
        }
    }

    @Override
    public void checkForEnd()
    {
        if (isOnline) {
            // TODO play a game online
        } else {
            console.checkForEnd();
        }
    }
}
