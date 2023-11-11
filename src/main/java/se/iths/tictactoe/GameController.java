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
    private Button
            button1, button2, button3,
            button4, button5, button6,
            button7, button8, button9;
    @FXML
    private static List<Button> buttons;
    @FXML
    private Button resetScoreButton;
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

//        button1.textProperty().bindBidirectional(model.gameBoard[0]);
//        button2.textProperty().bindBidirectional(model.gameBoard[1]);
//        button3.textProperty().bindBidirectional(model.gameBoard[2]);
//        button4.textProperty().bindBidirectional(model.gameBoard[3]);
//        button5.textProperty().bindBidirectional(model.gameBoard[4]);
//        button6.textProperty().bindBidirectional(model.gameBoard[5]);
//        button7.textProperty().bindBidirectional(model.gameBoard[6]);
//        button8.textProperty().bindBidirectional(model.gameBoard[7]);
//        button9.textProperty().bindBidirectional(model.gameBoard[8]);
    }

    @FXML
    private void handleCellButtonClick(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        int buttonIndex = buttons.indexOf(clickedButton);
        model.playTurn(buttonIndex);
        clickedButton.setText(model.getCurrentsPlayerSymbol());
        clickedButton.setDisable(true);
    }

    public void handleResetScoreButtonClick() {
        model.setPlayerScore(0);
        model.setComputerScore(0);

        // TODO: Implement reset score functionality
    }

    public void updateScoreBoard() {

    }
}