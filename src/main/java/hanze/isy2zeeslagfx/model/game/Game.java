package hanze.isy2zeeslagfx.model.game;

import hanze.isy2zeeslagfx.config.Config;
import hanze.isy2zeeslagfx.config.Setting;
import hanze.isy2zeeslagfx.model.game.pieces.Ship;
import hanze.isy2zeeslagfx.model.player.Player;
import hanze.isy2zeeslagfx.model.player.PlayerFactory;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<Integer, Player> players;
    private final String gameType;

    private final int[] startShipsLengths = {2, 4, 5, 6};

    public enum PlayersSetupType {
        PLAYER_VS_PLAYER,
        PLAYER_VS_AI,
        AI_VS_AI
    }
    private final PlayersSetupType playersType;

    public Game(String gameType, PlayersSetupType playersType)
    {
        this.players = new HashMap<>();
        this.gameType = gameType;
        this.playersType = playersType;
        initializePlayers();
        givePlayersShips();
        placeAShip("A2", "D2", 1, players.get(0));
        printPlayerShips();
        for (int i=0; i<3; i++) {
            System.out.println("breaker: " + i);
        }
    }

    private void placeAShip(String start, String end, int id, Player player)
    {
        player.placeShip(start, end, id);
    }

    private void printPlayerShips()
    {
        System.out.println();

        for (Map.Entry<Integer, Player> player : players.entrySet()) {
            for (Ship ship : player.getValue().getFleetManager().getFleet()) {
                System.out.println(ship.getShipId() + " - " + ship.getLength());
            }
            player.getValue().getBoard().printBoard();
        }
    }

    private void givePlayersShips()
    {
        for (Map.Entry<Integer, Player> player : players.entrySet()) {
            player.getValue().createShipsForPlayer(startShipsLengths);
        }
    }

    private void initializePlayers()
    {
        switch (this.playersType) {
            case PLAYER_VS_PLAYER: // Player vs Player
                addPlayer(0, createPlayer("HumanPlayer", Config.getInstance().getSetting(Setting.NAME)));
                addPlayer(1, createPlayer("HumanPlayer", "Guest Player"));
                break;
            case PLAYER_VS_AI: // Player vs AI
                addPlayer(0, createPlayer("HumanPlayer", Config.getInstance().getSetting(Setting.NAME)));
                addPlayer(1, createPlayer("AIPlayer", "AIPlayer"));
                break;
            case AI_VS_AI: // AI vs AI
                addPlayer(0, createPlayer("AIPlayer", "AI Player 1"));
                addPlayer(1, createPlayer("AIPlayer", "AI Player 2"));
                break;
            default:
                throw new IllegalArgumentException("This player setup is not available");
        }
    }

    private Player createPlayer(String playerType, String playerName)
    {
        return PlayerFactory.createPlayer(playerType, gameType, playerName);
    }

    private void addPlayer(Integer playerId, Player player)
    {
        players.put(playerId, player);
    }

    public Player getPlayer(int playerId)
    {
        return players.get(playerId);
    }
}
