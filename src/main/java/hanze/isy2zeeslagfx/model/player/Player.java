package hanze.isy2zeeslagfx.model.player;

public class Player {
    String userName;

    Player(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
