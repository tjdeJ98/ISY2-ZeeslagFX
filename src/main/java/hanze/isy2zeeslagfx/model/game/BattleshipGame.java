package hanze.isy2zeeslagfx.model.game;

import hanze.isy2zeeslagfx.model.board.BattleshipsBoard;
import hanze.isy2zeeslagfx.model.game.pieces.Ship;
import hanze.isy2zeeslagfx.model.player.Player;
import hanze.isy2zeeslagfx.model.player.strategy.BattleshipStrategy;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
//TODO Veel methodes die vanuit update() worden gecallt moet wss naar BattleshipStrategy worden verplaatst.
public class BattleshipGame extends Game {
    private Player curPlayer;
    private boolean gameEnd;
    private final int[] startShipsLengths = {2, 4, 5, 6};
    BattleshipStrategy playerStrategy;

    private boolean setupFaseDone;

    public BattleshipGame(String gameType, PlayersSetupType playersType)
    {
        super(gameType, playersType);
        this.gameEnd = false;
        this.setupFaseDone = false;
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

    private void switchPlayer()
    {
        if (super.players.get(0) == curPlayer) {
            this.curPlayer = super.players.get(1);
        } else {
            this.curPlayer = super.players.get(0);
        }
    }

    private boolean checkIfPlayerIsSet()
    {
        return curPlayer != null;
    }

    private void playerSetupActions()
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
        // TODO note that all ships have been place and setup can now be skipped (on server possibly send board and only one player)
        playerSetupActions();
        System.out.println(this.curPlayer.getName());

        ConsoleHandler console = new ConsoleHandler(this);
        // Set up shits for each player
        if (!setupFaseDone) {
            while (!this.playerStrategy.getFleetManager().haveAllPlayerShipsBeenPlaced()) {
                console.placeAShip();
            }
        } else {
            console.makeShot();
        }

        // TODO Keep track when all ship set ups done, then skip this step.
        // TODO shoot a ship
        // TODO track ships
        // TODO track shots taken (Hit and mis)
        // TODO track winner and loser

        playerStrategy.getFleetManager().printFleet();
    }

    @Override
    public void checkForEnd()
    {
        if (gameEnd)
            gameLoop.stop();
    }

    public void flipGameEnd()
    {
        gameEnd = !gameEnd;
    }
}
