package hanze.isy2zeeslagfx.model.game;

import hanze.isy2zeeslagfx.config.Config;
import hanze.isy2zeeslagfx.config.Setting;
import hanze.isy2zeeslagfx.model.game.loops.GameLoop;
import hanze.isy2zeeslagfx.model.game.pieces.Ship;
import hanze.isy2zeeslagfx.model.player.Player;
import hanze.isy2zeeslagfx.model.player.PlayerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class Game {
    protected GameLoop gameLoop;
    protected Map<Integer, Player> players;
    private final String gameType;
    private boolean gameEnd;
    private boolean isOnline;

    public enum PlayersSetupType
    {
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
        this.gameEnd = false;
        initializePlayers();
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

    public void flipGameEnd()
    {
        gameEnd = !gameEnd;
    }

    public boolean getGameEnd()
    {
        return gameEnd;
    }

    public void setGameLoop(GameLoop gameLoop)
    {
        this.gameLoop = gameLoop;
    }

    public abstract void switchPlayer();

    public abstract void update();
    public abstract void checkForEnd();
}

