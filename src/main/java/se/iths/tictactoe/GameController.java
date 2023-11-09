package se.iths.tictactoe;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class GameController {
    public GameModel model = new GameModel();
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    public Button resetScoreButton;


    public void initialize() {
        button1.textProperty().bindBidirectional(model.gameBoard[0]);
        button2.textProperty().bindBidirectional(model.gameBoard[1]);
        button3.textProperty().bindBidirectional(model.gameBoard[2]);
        button4.textProperty().bindBidirectional(model.gameBoard[3]);
        button5.textProperty().bindBidirectional(model.gameBoard[4]);
        button6.textProperty().bindBidirectional(model.gameBoard[5]);
        button7.textProperty().bindBidirectional(model.gameBoard[6]);
        button8.textProperty().bindBidirectional(model.gameBoard[7]);
        button9.textProperty().bindBidirectional(model.gameBoard[8]);
    }

    public GameModel getModel() {
        return model;
    }

    public void handleCellButtonClick(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        model.setPlayerSymbol(clickedButton.getId());
        clickedButton.setDisable(true);
    }

    public void handleResetScoreButtonClick(ActionEvent actionEvent) {
        // todo
    }
}