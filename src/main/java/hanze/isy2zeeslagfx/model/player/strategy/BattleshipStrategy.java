package hanze.isy2zeeslagfx.model.player.strategy;

import hanze.isy2zeeslagfx.model.board.BattleshipsBoard;
import hanze.isy2zeeslagfx.model.board.Board;
import hanze.isy2zeeslagfx.model.board.BoardFactory;
import hanze.isy2zeeslagfx.model.game.pieces.FleetManager;


// TODO moet wss veel methodes uit BattleshipGame overnemen als player acties.
public class BattleshipStrategy implements PlayerStrategy {
    private final Board board;
    private final Board trackingBoard;
    private final FleetManager fleetManager;

    public BattleshipStrategy()
    {
        this.board = BoardFactory.createBoard("Battleships");
        this.trackingBoard = BoardFactory.createBoard("Battleships");
        this.fleetManager = new FleetManager();
    }

    @Override
    public void performAction(String... args) {

    }

    public void placeShip(String startCoordinate, String endCoordinate, int shipId) {
        if (((BattleshipsBoard) this.board).shipPlacement(startCoordinate, endCoordinate, shipId)) {
            this.fleetManager.getShipById(shipId).setPlaced();
            this.fleetManager.getShipById(shipId).setState();
        } else {
            System.out.println("Invalid ship placement, try again");
        }
    }

    public Board getTrackingBoard()
    {
        return trackingBoard;
    }

    public FleetManager getFleetManager()
    {
        return this.fleetManager;
    }
    
    public Board getBoard()
    {
        return this.board;
    }

}