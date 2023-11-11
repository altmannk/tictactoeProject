package se.iths.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.List;

public class GameController {
    private static final GameModel model = new GameModel();
    @FXML
    private Label headerLabel;
    @FXML
    private Button
            button1, button2, button3,
            button4, button5, button6,
            button7, button8, button9;
    @FXML
    private static List<Button> buttons;
    @FXML
    private Button resetScoreButton;
    @FXML
    private Button playAgain;
    @FXML
    private Label playerWinsLabel;
    @FXML
    private Label computerWinsLabel;


    public void initialize() {
        buttons = Arrays.asList(
                button1, button2, button3,
                button4, button5, button6,
                button7, button8, button9
        );
    }

    @FXML
    private void onCellButtonClick(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        int buttonIndex = buttons.indexOf(clickedButton);
        model.playTurn(buttonIndex);
        clickedButton.setText(model.getCurrentsPlayerSymbol());
        clickedButton.setDisable(true);

        updateGame();
    }

    @FXML
    private void onResetScoreButtonClick() {
        model.setPlayerScore(0);
        model.setComputerScore(0);
        onPlayAgain();
    }

    @FXML
    private void onPlayAgain() {
        model.makeGameBoard();
        model.setWinner("");
        model.setGameEnd(false);
        model.setCurrentPlayer(model.getPlayerX());
        enableButtons();
        headerLabel.setText("Tic Tac Toe");
        updateScoreBoard();
    }

    private void updateScoreBoard() {
        playerWinsLabel.setText("Player: " + model.getPlayerScore());
        computerWinsLabel.setText("Computer: " + model.getComputerScore());
    }

    private void updateGame() {
        if (model.isGameEnd()){
            disableButtons();
            updateScoreBoard();
            headerLabel.setText("Winner is " + model.getWinner());
        }
    }

    private void disableButtons() {
        for (Button button : buttons) {
            button.setDisable(true);
        }
    }

    private void enableButtons() {
        for (Button button : buttons) {
            button.setText("");
            button.setDisable(false);
        }
    }
}