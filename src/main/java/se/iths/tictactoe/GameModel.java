package se.iths.tictactoe;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GameModel {
    public StringProperty[] gameBoard;
    private int currentPlayer = 0; // Index 0 corresponds to 'X', index 1 corresponds to 'O'
    public int playerScore = 0;
    public int computerScore = 0;


    public GameModel() {
        gameBoard = new StringProperty[9];
        makeGameBoard();
    }

    private void makeGameBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i] = new SimpleStringProperty("");
        }
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setPlayerSymbol(String clickedButtonId) {
        int clickedButtonIndex = Integer.parseInt(clickedButtonId.substring(6));
        gameBoard[clickedButtonIndex-1].set((currentPlayer == 0 ? "X" : "O"));// update button text w current player
        checkForWinner();
        currentPlayer = (currentPlayer + 1) % 2; //switch player
    }

    public void checkForWinner() {
        for (int i = 0; i < gameBoard.length; i += 3) {
            if (!gameBoard[i].get().isEmpty() && gameBoard[i].get().equals(gameBoard[i+1].get())
                    && gameBoard[i].get().equals(gameBoard[i+2].get())) {
                // todo: update player score label
                System.out.println("winner horizontal"); // todo replace with winner label
            }

        }
        for (int i = 0; i < 3; i++) {
            if (!gameBoard[i].get().isEmpty() && gameBoard[i].get().equals(gameBoard[i+3].get())
                    && gameBoard[i].get().equals(gameBoard[i+6].get())) {
                System.out.println("winner vertical"); // todo replace with winner label
            }
        }

        if (!gameBoard[0].get().isEmpty() && gameBoard[0].get().equals(gameBoard[4].get())
                && gameBoard[0].get().equals(gameBoard[8].get()) ||
                !gameBoard[2].get().isEmpty() && gameBoard[2].get().equals(gameBoard[4].get())
                && gameBoard[2].get().equals(gameBoard[6].get())) {
            System.out.println("winner diagonal"); // todo replace with winner label
        }

        if(checkForTie()) {
            System.out.println("tie!"); // todo replace with tie label
        }

    }

    private boolean checkForTie() {
        for (StringProperty index : gameBoard) {
            if (index != null && index.get().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}





