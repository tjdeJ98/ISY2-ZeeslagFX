package hanze.isy2zeeslagfx.model.board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BattleshipsBoard implements Board {
    private final int boardSize = 8;
    private final BattleshipCell[][] board;
    private final HashSet<String> listOfAllCoordinatesOnBoard;

    public BattleshipsBoard()
    {
        this.listOfAllCoordinatesOnBoard = new HashSet<>();
        this.board = new BattleshipCell[boardSize][boardSize];
        this.initializeBoard();
    }

    public void initializeBoard()
    {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};

        for (int row=0; row<boardSize; row++) {
            for (int col=0; col<boardSize; col++) {
                board[row][col] = new BattleshipCell(letters[row] + col);
                listOfAllCoordinatesOnBoard.add(letters[row] + col);
            }
        }
    }

    public void shipPlacement(String startCoordinate, String endCoordinate, int shipId)
    {
        List<String> coordinates = getAllCoordinatesShipWillCover(startCoordinate, endCoordinate);

        if (checkIfSpotNotTaken(coordinates) && checkIfCoordinateExists(startCoordinate, endCoordinate)) {
            placeShip(coordinates, shipId);
        } else {
            System.out.println("Ship placement is invalid");
        }
    }

    private void placeShip(List<String> coordinates, int shipId)
    {
        for (BattleshipCell[] row : board) {
            for (BattleshipCell cell : row) {
                if (coordinates.contains(cell.getCoordinate())) {
                    cell.setShipId(shipId);
                }
            }
        }
    }

    private boolean checkIfSpotNotTaken(List<String> coordinates)
    {
        for (BattleshipCell[] row : board) {
            for (BattleshipCell cell : row) {
               if (coordinates.contains(cell.getCoordinate()) && cell.getShipId() != -1)
                   return false;
            }
        }
        return true;
    }

    private List<String> getAllCoordinatesShipWillCover(String startCoordinate, String endCoordinate)
    {
        List<String> coordinates = new ArrayList<>();

        char startRow = startCoordinate.charAt(0);
        char endRow = endCoordinate.charAt(0);
        int startCol = Character.getNumericValue(startCoordinate.charAt(1));
        int endCol = Character.getNumericValue(endCoordinate.charAt(1));

        if (startRow == endRow) {
            for (int col = startCol; col <= endCol; col++) {
                coordinates.add("" + startRow + col);
            }
        } else if (startCol == endCol) {
            for (char row = startRow; row <= endRow; row++) {
                coordinates.add("" + row + startCol);
            }
        } else {
            System.out.println("Ship was placed diagonally");
        }

        return coordinates;
    }

    private boolean checkIfCoordinateExists(String startCoordinate, String endCoordinate) {
        return listOfAllCoordinatesOnBoard.contains(startCoordinate) && listOfAllCoordinatesOnBoard.contains(endCoordinate);
    }

    public void printBoard()
    {
        for (int row=0; row<boardSize; row++) {
            for (int col=0; col<boardSize; col++) {
                System.out.printf("[" + board[row][col].getShipId() + "]");
            }
            System.out.println();
        }
    }

    public BattleshipCell[][] getBoard() {
        return this.board;
    }
}
