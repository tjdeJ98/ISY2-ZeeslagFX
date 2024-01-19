package hanze.isy2zeeslagfx.model.game;

import hanze.isy2zeeslagfx.config.Config;
import hanze.isy2zeeslagfx.config.Setting;
import hanze.isy2zeeslagfx.model.board.Board;
import hanze.isy2zeeslagfx.model.board.BoardFactory;
import hanze.isy2zeeslagfx.model.player.Player;
import hanze.isy2zeeslagfx.model.player.PlayerFactory;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Player> players;

    /*
     * Have to take out
     */
    public Game(String gameType) {
        this.players = new HashMap<>();
        addPlayer("1", PlayerFactory.createPlayer(Config.getInstance().getSetting(Setting.NAME), gameType));
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
}
