package se.iths.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.List;

public class GameController {
    // GameModel instance
    private static final GameModel model = new GameModel();

    // FXML elements for the game interface
    @FXML
    private Button
                button1, button2, button3,
                button4, button5, button6,
                button7, button8, button9;
    @FXML
    private static List<Button> gameButtons;
    @FXML
    private Label headerLabel;
    @FXML
    private Label playerWinsLabel;
    @FXML
    private Label computerWinsLabel;

    // Initializes the buttons for the game
    public void initialize() {
        gameButtons = Arrays.asList(
                button1, button2, button3,
                button4, button5, button6,
                button7, button8, button9
        );
    }

    // Handles player move
    @FXML
    private void onHandleButtonClick(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        int buttonIndex = gameButtons.indexOf(clickedButton);
        // Update the game model with the players move
        model.playTurn(buttonIndex);
        clickedButton.setText(model.getCurrentsPlayerSymbol());
        clickedButton.setDisable(true);
        updateGameStateUI();
        // If the game is still on, initiate the computer's move
        if (!model.isGameEnd()) {
            initiateComputerTurn();
            updateGameStateUI();
        }
    }

    // Resets the score and initiates a new game
    @FXML
    private void onResetScoreButtonClick() {
        model.setPlayerScore(0);
        model.setComputerScore(0);
        onPlayAgain();
    }

    //Resets the game state for a new game
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

    // Initiates the computers move
    private void initiateComputerTurn() {
        int buttonIndex = model.computerTurn();
        model.playTurn(buttonIndex);
        gameButtons.get(buttonIndex).setText(model.getCurrentsPlayerSymbol());
        gameButtons.get(buttonIndex).setDisable(true);
    }

    // Updates the display score
    private void updateScoreBoard() {
        playerWinsLabel.setText("Player: " + model.getPlayerScore());
        computerWinsLabel.setText("Computer: " + model.getComputerScore());
    }

    // Updates the game state and UI
    private void updateGameStateUI() {
        if (model.isGameEnd()) {
            disableButtons();
            updateScoreBoard();
            headerLabel.setText(model.getWinner());
        }
    }

    // Disables all buttons
    private void disableButtons() {
        for (Button button : gameButtons) {
            button.setDisable(true);
        }
    }

    // Enables all buttons and resets their text
    private void enableButtons() {
        for (Button button : gameButtons) {
            button.setText("");
            button.setDisable(false);
        }
    }
}