package se.iths.tictactoe;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public GameModel model = new GameModel();
    public Button button1, button2, button3, button4, button5, button6, button7, button8, button9, resetScoreButton;
    public List<Button> buttons = new ArrayList<>();

    public GameModel getModel() {
        return model;
    }

    public void handleButtonClick(ActionEvent actionEvent) {
        var tempButton = ((Button) actionEvent.getSource());
        tempButton.setText("X");
        tempButton.setDisable(true);
    }

    public void handleResetScoreClick(ActionEvent actionEvent) {
    }
}