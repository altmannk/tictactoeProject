package se.iths.tictactoe;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {
    public GameModel model = new GameModel();
    public Button button1, button2, button3, button4, button5, button6, button7, button8, button9, resetScoreButton;
    public List<Button> buttons = new ArrayList<>();
    private int currentPlayer;

    public void initialize() {
        currentPlayer = 0; // Index 0 corresponds to 'X', index 1 corresponds to '0'
        buttons = Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9);
    }

    public GameModel getModel() {
        return model;
    }

    public void handleButtonClick(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();

        clickedButton.setText((currentPlayer == 0 ? "X" : "O")); // update button text w current player
        clickedButton.setDisable(true);
        currentPlayer = (currentPlayer + 1) % 2; //switch player


    }

    public void handleResetScoreClick(ActionEvent actionEvent) {
    }
}