package se.iths.tictactoe;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public GameModel model = new GameModel();
    public Button button1, button2, button3, button4, button5, button6, button7, button8, button9, resetScoreButton;
    public List<Button> buttons = new ArrayList<>();
    private String currentPlayer;

    public void initialize() {
        currentPlayer = "X";
    }

    public GameModel getModel() {
        return model;
    }

    public void handleButtonClick(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();

        if(clickedButton.getText().isEmpty()) {
            clickedButton.setText(currentPlayer);
            clickedButton.setDisable(true);
            currentPlayer = (currentPlayer.equals("X") ? "O" : "X");
        }
    }

    public void handleResetScoreClick(ActionEvent actionEvent) {
    }
}