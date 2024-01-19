package hanze.isy2zeeslagfx.model.board;

public class BattleshipCell {
    private CellStatus status;
    private enum CellStatus {
        EMPTY("EM"),
        SHIP("SH"),
        HIT("HI"),
        MISS("MI"),
        SUNK("SU");

        String cellCharacter;

        CellStatus(String cellCharacter) {
            this.cellCharacter = cellCharacter;
        }
    }

    public BattleshipCell() {
        this.status = CellStatus.EMPTY;
    }

}
