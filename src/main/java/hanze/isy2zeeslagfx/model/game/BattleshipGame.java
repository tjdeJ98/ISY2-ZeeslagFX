package hanze.isy2zeeslagfx.model.game;

import hanze.isy2zeeslagfx.model.board.BattleshipsBoard;
import hanze.isy2zeeslagfx.model.game.pieces.Ship;
import hanze.isy2zeeslagfx.model.player.Player;
import hanze.isy2zeeslagfx.model.player.strategy.BattleshipStrategy;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class BattleshipGame extends Game {
    private Player curPlayer;
    private boolean gameEnd;
    private final int[] startShipsLengths = {2, 4, 5, 6};
    private BattleshipStrategy playerStrategy;

    public BattleshipGame(String gameType, PlayersSetupType playersType)
    {
        super(gameType, playersType);
        this.gameEnd = false;
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

    private String getConsoleInput()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void manageConsoleInput()
    {
        String text = getConsoleInput();

        if (Objects.equals(text, "stop")) {
            flipGameEnd();
        } else {
            System.out.println("Game will continue");
        }
    }

    private int selectShipId()
    {
        while (true) {
            System.out.println("Give id of ship to place (like 1): ");
            int id = Integer.parseInt(getConsoleInput());
            if (!playerStrategy.getFleetManager().getShipById(id).getPlaced())
                return id;
            System.out.println("Ship was already placed!");
        }
    }

    private String selectCoordinate(String message)
    {
        while (true) {
            System.out.println(message);
            String coordinate = getConsoleInput();
            if (((BattleshipsBoard) playerStrategy.getBoard()).checkIfSpotNotTaken(coordinate))
                return coordinate;
            System.out.println("Coordinate is already take!");
        }
    }

    private void placeAShip()
    {
        System.out.println("Board status: ");
        playerStrategy.getBoard().printBoard();

        System.out.println("Ships placing status");
        for (Ship ship : this.playerStrategy.getFleetManager().getFleet())
            System.out.println("Ship ID: " + ship.getShipId() + " Ship size: " + ship.getLength() + " -> Placed: " + ship.getPlaced());


        int shipId = selectShipId();
        Ship ship = playerStrategy.getFleetManager().getShipById(shipId);
        String start, end;
        boolean check;
        do {
            start = selectCoordinate("Give first coordinate (like A1): ");
            end = selectCoordinate("Give second coordinate (like A2): ");
            check = !isValidShipPlacement(start, end, ship.getLength());
            if (check) {
                System.out.println("Invalid placement. Please try again.");
            }
        } while (check);

        playerStrategy.placeShip(start, end, shipId);
    }

    private boolean isValidShipPlacement(String start, String end, int shipLength) {
        boolean foo = !((BattleshipsBoard) playerStrategy.getBoard()).isDuplicateStartAndEnd(start, end);
        boolean bar = ((BattleshipsBoard) playerStrategy.getBoard()).isValidShipPlacementLength(start, end, shipLength);
        return foo && bar;

    }

    @Override
    public void update() {
        // TODO note that all ships have been place and setup can now be skipped (on server possibly send board and only one player)
        playerSetupActions();
        System.out.println(this.curPlayer.getName());

        while(!this.playerStrategy.getFleetManager().haveAllPlayerShipsBeenPlaced()) {
            placeAShip();
        }

        playerStrategy.getFleetManager().printFleet();
//        playerStrategy.placeShip(start, end, id);
        // runTest();
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
