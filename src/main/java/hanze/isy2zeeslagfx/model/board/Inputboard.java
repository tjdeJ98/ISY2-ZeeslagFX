package hanze.isy2zeeslagfx.model.board;

import hanze.isy2zeeslagfx.model.other.Ship;

import java.util.ArrayList;
import java.util.Random;
public class Inputboard extends Battleshipboard {
    ArrayList<Ship> shipList = new ArrayList<>();
    public Inputboard() {
    }

    // This methode is still in progress
    // The idea: To add the object Ship to the Board object, but fill the rest with just a random char.
    // This is so we know we can place a Ship. The game logic will be placed later.
    public char[][] fillBoard(Board board, Ship ship) {
        char[][] gameboard = this.board;
        //gameboard[ship.startCoordinate][ship.endCoordinate] = ship;           // error line
        return super.fillBoard(board);
    }

    public void printBoard() {
        super.printBoard();
    }

    // method that keeps a list of ships that are placed
    // Arraylist is beneficial because of the flexibility.

    public ArrayList<Ship> placeShip(Ship ship) {
        this.shipList.add(ship);
        return shipList;
    }
}