package hanze.isy2zeeslagfx.model.board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

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

    public boolean shipPlacement(String startCoordinate, String endCoordinate, int shipId)
    {
        List<String> coordinates = getAllCoordinatesShipWillCover(startCoordinate, endCoordinate);
        if (coordinates == null)
            return false;

        if (checkIfSpotsNotTaken(coordinates) && checkIfCoordinateExists(startCoordinate, endCoordinate)) {
            placeShip(coordinates, shipId);
        } else {
            return false;
        }
        return true;
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

    private boolean checkIfSpotsNotTaken(List<String> coordinates)
    {
        for (BattleshipCell[] row : board) {
            for (BattleshipCell cell : row) {
               if (coordinates.contains(cell.getCoordinate()) && cell.getShipId() != -1)
                   return false;
            }
        }
        return true;
    }
    public boolean checkIfSpotNotTaken(String coordinate)
    {
        for (BattleshipCell[] row : board) {
            for (BattleshipCell cell : row) {
                if (Objects.equals(coordinate, cell.getCoordinate()) && cell.getShipId() != -1)
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
            for (int col = Math.min(startCol, endCol); col <= Math.max(startCol, endCol); col++) {
                coordinates.add("" + startRow + col);
            }
        } else if (startCol == endCol) {
            for (char row = (char) Math.min(startRow, endRow); row <= (char) Math.max(startRow, endRow); row++) {
                coordinates.add("" + row + startCol);
            }
        } else {
            return null;
        }

        return coordinates;
    }

    public boolean isDuplicateStartAndEnd(String start, String end) {
        if (start.equals(end)) {
            System.out.println("Start and end coordinates cannot be the same.");
            return true;
        }
        return false;
    }

    public boolean isValidShipPlacementLength(String start, String end, int shipLength) {
        char startRow = start.charAt(0);
        char endRow = end.charAt(0);
        int startCol = Character.getNumericValue(start.charAt(1));
        int endCol = Character.getNumericValue(end.charAt(1));

        if (startRow == endRow) {
            return Math.abs(Math.max(startCol, endCol) - Math.min(startCol, endCol)) == shipLength - 1;
        } else if (startCol == endCol) {
            return Math.abs(Math.max(startRow, endRow) - Math.min(startRow, endRow)) == shipLength - 1;
        } else {
            System.out.println("Ship must be placed horizontally or vertically.");
            return false;
        }
    }

    private boolean checkIfCoordinateExists(String startCoordinate, String endCoordinate) {
        return listOfAllCoordinatesOnBoard.contains(startCoordinate) && listOfAllCoordinatesOnBoard.contains(endCoordinate);
    }

    public void printBoard()
    {
        for (int row=0; row<boardSize; row++) {
            for (int col=0; col<boardSize; col++) {
                if (board[row][col].getShipId() != -1) {
                    System.out.printf("[" + board[row][col].getShipId() + "]");
                } else {
                    System.out.printf("[" + board[row][col].getCoordinate() + "]");
                }
            }
            System.out.println();
        }
    }

    public BattleshipCell[][] getBoard() {
        return this.board;
    }
}
