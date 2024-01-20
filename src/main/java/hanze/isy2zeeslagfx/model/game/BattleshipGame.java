package hanze.isy2zeeslagfx.model.game;

import hanze.isy2zeeslagfx.model.player.Player;
import hanze.isy2zeeslagfx.model.player.strategy.BattleshipStrategy;
import hanze.isy2zeeslagfx.model.player.strategy.PlayerStrategy;

import java.util.Map;

public class BattleshipGame extends Game {
    private final int[] startShipsLengths = {2, 4, 5, 6};
    private BattleshipStrategy playerStrategy;

    public BattleshipGame(String gameType, PlayersSetupType playersType)
    {
        super(gameType, playersType);
        givePlayersShips();
        runTest();
    }

    private void runTest()
    {
        for (int i=0; i<2; i++) {
            Player curPlayer = super.players.get(i);
            this.playerStrategy = (BattleshipStrategy) curPlayer.getStrategy();
            System.out.println(curPlayer.getName());
            placeAShip("A2", "D2", 1);
            playerStrategy.getFleetManager().printFleet();
            playerStrategy.getBoard().printBoard();
        }
    }

    // TODO needs to be in a game session and not here
    private void placeAShip(String start, String end, int id)
    {
        playerStrategy.placeShip(start, end, id);
    }

    private void givePlayersShips()
    {
        for (Map.Entry<Integer, Player> player : players.entrySet()) {
            ((BattleshipStrategy) player.getValue().getStrategy()).getFleetManager().createShipsForPlayer(startShipsLengths);
        }
    }
}
