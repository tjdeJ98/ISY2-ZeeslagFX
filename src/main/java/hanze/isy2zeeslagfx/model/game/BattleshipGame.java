package hanze.isy2zeeslagfx.model.game;

import hanze.isy2zeeslagfx.model.player.Player;

import java.util.Map;

public class BattleshipGame extends Game{
    private final int[] startShipsLengths = {2, 4, 5, 6};

    public BattleshipGame(String gameType, PlayersSetupType playersType)
    {
        super(gameType, playersType);
        givePlayersShips();
        for (int i=0; i<2; i++) {
            Player curPlayer = super.players.get(i);
            System.out.println(curPlayer.getName());
            placeAShip("A2", "D2", 1, curPlayer);
            curPlayer.getFleetManager().printFleet();
            curPlayer.getBoard().printBoard();
        }
    }

    // TODO needs to be in a game session and not here
    private void placeAShip(String start, String end, int id, Player player)
    {
        player.placeShip(start, end, id);
    }

    private void givePlayersShips()
    {
        for (Map.Entry<Integer, Player> player : players.entrySet()) {
            player.getValue().getFleetManager().createShipsForPlayer(startShipsLengths);
        }
    }
}
