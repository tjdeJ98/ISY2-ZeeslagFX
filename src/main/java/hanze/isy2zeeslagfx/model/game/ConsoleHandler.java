package hanze.isy2zeeslagfx.model.game;

import hanze.isy2zeeslagfx.model.board.BattleshipsBoard;
import hanze.isy2zeeslagfx.model.game.pieces.Ship;
import hanze.isy2zeeslagfx.model.player.Player;
import hanze.isy2zeeslagfx.model.player.strategy.BattleshipStrategy;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleHandler {
    private BattleshipGame game;

    public ConsoleHandler(BattleshipGame game)
    {
        this.game = game;
    }

    private BattleshipStrategy curPlayerStrategy;

    private BattleshipStrategy otherPlayerStrategy;

    private String getConsoleInput()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int selectShipId()
    {
        while (true) {
            System.out.println("Give id of ship to place (like 1): ");
            int id = Integer.parseInt(getConsoleInput());
            if (!curPlayerStrategy.getFleetManager().getShipById(id).getPlaced())
                return id;
            System.out.println("Ship was already placed!");
        }
    }

    private String selectCoordinateForShipPlacement(String message)
    {
        while (true) {
            System.out.println(message);
            String coordinate = getConsoleInput();
            if (((BattleshipsBoard) curPlayerStrategy.getBoard()).checkIfSpotNotTaken(coordinate))
                return coordinate;
            System.out.println("Coordinate is already take!");
        }
    }

    private String selectCoordinateForShot(String message)
    {
        while (true) {
            System.out.println(message);
            String input = getConsoleInput();
            if (((BattleshipsBoard) curPlayerStrategy.getBoard()).checkIfCoordinateExists(input)) {
                if (!otherPlayerStrategy.getBoard().checkIfCellAlreadyPicked(input))
                    return input;
            }

            System.out.println("Coordinate does not exist!");
        }
    }

    private void boardStatusShow()
    {
        System.out.println("Board status: ");
        otherPlayerStrategy.getBoard().printOnlyHitsBoard();
        curPlayerStrategy.getBoard().printBoard();
    }

    public void placeAShip()
    {
        boardStatusShow();

        System.out.println("Ships placing status");
        curPlayerStrategy.getFleetManager().printFleetWithPlacement();

        int shipId = selectShipId();
        Ship ship = curPlayerStrategy.getFleetManager().getShipById(shipId);
        String start, end;
        boolean check;
        do {
            start = selectCoordinateForShipPlacement("Give first coordinate (like A1): ");
            end = selectCoordinateForShipPlacement("Give second coordinate (like A2): ");
            check = !((BattleshipsBoard) curPlayerStrategy.getBoard()).isValidShipPlacement(start, end, ship.getLength());
            if (check) {
                System.out.println("Invalid placement. Please try again.");
            }
        } while (check);

        curPlayerStrategy.placeShip(start, end, shipId);
    }

    public void ezSetupShips()
    {
        curPlayerStrategy.placeShip("A0", "A1", 0);
//        curPlayerStrategy.placeShip("B0", "B3", 1);
//        curPlayerStrategy.placeShip("C0", "C4", 2);
//        curPlayerStrategy.placeShip("D0", "D5", 3);
    }

    public void update()
    {
        // TODO note that all ships have been place and setup can now be skipped (on server possibly send board and only one player)

        if (game.curPlayer == null) {
            game.playerSetupActions();
        }
        System.out.println(game.curPlayer.getName());

        curPlayerStrategy = ((BattleshipStrategy) game.curPlayer.getStrategy());
        otherPlayerStrategy = ((BattleshipStrategy) game.getOtherPlayer().getStrategy());

        if (curPlayerStrategy.getSetupFaseDone()) {
            Player otherPlayer = game.getOtherPlayer();
            // TODO shoot a ship
            makeShot(otherPlayer);
        } else {
            System.out.println(game.curPlayer.getName());

            while (!curPlayerStrategy.getFleetManager().haveAllPlayerShipsBeenPlaced()) {
                //placeAShip();
                ezSetupShips();
            }
            curPlayerStrategy.changeSetupFase();
        }


        // TODO track ships
        // TODO track shots taken (Hit and mis)
        // TODO track winner and loser


        curPlayerStrategy.getFleetManager().printFleet();

    }

    public void makeShot(Player otherPlayer)
    {
        boardStatusShow();
        String input = selectCoordinateForShot("Give coordinate to shoot: ");
        int shipId = otherPlayerStrategy.getBoard().select(input);

        if (shipId!=-1) {
            otherPlayerStrategy.getFleetManager().getShipById(shipId).shipHit();
            System.out.println("You hit a ship!");
        }
    }

    public void checkForEnd()
    {
        if (otherPlayerStrategy.getFleetManager().isFleetSunk()) {
            System.out.println(game.curPlayer.getName() + " wins!!!!!");
            game.flipGameEnd();
        }
    }
}
