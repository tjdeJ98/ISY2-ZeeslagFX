package hanze.isy2zeeslagfx.model.game;

import hanze.isy2zeeslagfx.model.board.BattleshipsBoard;
import hanze.isy2zeeslagfx.model.game.pieces.Ship;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleHandler {
    private BattleshipGame game;

    public ConsoleHandler(BattleshipGame game)
    {
        this.game = game;
    }

    private String getConsoleInput()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void manageConsoleInput()
    {
        String text = getConsoleInput();

        if (Objects.equals(text, "stop")) {
            game.flipGameEnd();
        } else {
            System.out.println("Game will continue");
        }
    }

    private int selectShipId()
    {
        while (true) {
            System.out.println("Give id of ship to place (like 1): ");
            int id = Integer.parseInt(getConsoleInput());
            if (!game.playerStrategy.getFleetManager().getShipById(id).getPlaced())
                return id;
            System.out.println("Ship was already placed!");
        }
    }

    private String selectCoordinate(String message)
    {
        while (true) {
            System.out.println(message);
            String coordinate = getConsoleInput();
            if (((BattleshipsBoard) game.playerStrategy.getBoard()).checkIfSpotNotTaken(coordinate))
                return coordinate;
            System.out.println("Coordinate is already take!");
        }
    }

    public void placeAShip()
    {
        System.out.println("Board status: ");
        game.playerStrategy.getBoard().printBoard();

        System.out.println("Ships placing status");
        for (Ship ship : game.playerStrategy.getFleetManager().getFleet())
            System.out.println("Ship ID: " + ship.getShipId() + " Ship size: " + ship.getLength() + " -> Placed: " + ship.getPlaced());

        int shipId = selectShipId();
        Ship ship = game.playerStrategy.getFleetManager().getShipById(shipId);
        String start, end;
        boolean check;
        do {
            start = selectCoordinate("Give first coordinate (like A1): ");
            end = selectCoordinate("Give second coordinate (like A2): ");
            check = !((BattleshipsBoard) game.playerStrategy.getBoard()).isValidShipPlacement(start, end, ship.getLength());
            if (check) {
                System.out.println("Invalid placement. Please try again.");
            }
        } while (check);

        game.playerStrategy.placeShip(start, end, shipId);
    }
}
