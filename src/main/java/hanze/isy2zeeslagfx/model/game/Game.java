package hanze.isy2zeeslagfx.model.game;

import hanze.isy2zeeslagfx.model.board.Board;
import hanze.isy2zeeslagfx.model.board.BoardFactory;
import hanze.isy2zeeslagfx.model.player.Player;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private final Board gameBoard;
    private Map<String, Player> players;

    /*
     * Have to take out
     */
    public Game(String gameType) {
        this.players = new HashMap<>();
        this.gameBoard = createBoardForGame(gameType);
    }

    private void addPlayer(String playerId, Player player) {
        players.put(playerId, player);
    }

    private void removePlayer(String playerId) {
        players.remove(playerId);
    }

    public Player getPlayer(String playerId)
    {
        return players.get(playerId);
    }

    private Board createBoardForGame(String gameType)
    {
        return BoardFactory.createBoard(gameType);
    }

    public Board getGameBoard()
    {
        return gameBoard;
    }
}
