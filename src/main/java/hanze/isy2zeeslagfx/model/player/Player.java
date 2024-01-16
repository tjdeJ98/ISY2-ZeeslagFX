package hanze.isy2zeeslagfx.model.player;

import hanze.isy2zeeslagfx.config.Config;
import hanze.isy2zeeslagfx.config.Setting;

public class Player {
    String userName;

    Player() {
        this.userName = Config.getInstance().getSetting(Setting.NAME);
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
