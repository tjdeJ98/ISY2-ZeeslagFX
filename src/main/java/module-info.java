module hanze.isy2zeeslagfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens hanze.isy2zeeslagfx to javafx.fxml;
    exports hanze.isy2zeeslagfx;
    exports hanze.isy2zeeslagfx.controller;
    opens hanze.isy2zeeslagfx.controller to javafx.fxml;
    exports hanze.isy2zeeslagfx.model;
    opens hanze.isy2zeeslagfx.model to javafx.fxml;
}