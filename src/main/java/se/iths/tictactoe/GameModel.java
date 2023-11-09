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

    public void playTurn(String clickedButtonId) {
        int clickedButtonIndex = Integer.parseInt(clickedButtonId.substring(6));
        setSymbolOnBoard(clickedButtonIndex);
        checkForWinner();
        changePlayer();
    }

    private void setSymbolOnBoard(int clickedButtonIndex) {
        gameBoard[clickedButtonIndex -1].set(getCurrentsPlayerSymbol());
    }

    private String getCurrentsPlayerSymbol() {
        return currentPlayer == 0 ? "X" : "O";
    }

    private void changePlayer() {
        currentPlayer = (currentPlayer + 1) % 2;
    }

    public void checkForWinner() {
        //check for horizontal winners
        for (int i = 0; i < gameBoard.length; i += 3) {
            if (!gameBoard[i].get().isEmpty() && gameBoard[i].get().equals(gameBoard[i+1].get())
                    && gameBoard[i].get().equals(gameBoard[i+2].get())) {
                // TODO: update player score label
                System.out.println("winner horizontal"); // TODO: replace with winner label
            }

        }
        //check for vertical winners
        for (int i = 0; i < 3; i++) {
            if (!gameBoard[i].get().isEmpty() && gameBoard[i].get().equals(gameBoard[i+3].get())
                    && gameBoard[i].get().equals(gameBoard[i+6].get())) {
                System.out.println("winner vertical"); // TODO: replace with winner label
            }
        }

        //check for diagonal winners
        if (!gameBoard[0].get().isEmpty() && gameBoard[0].get().equals(gameBoard[4].get())
                && gameBoard[0].get().equals(gameBoard[8].get()) ||
                !gameBoard[2].get().isEmpty() && gameBoard[2].get().equals(gameBoard[4].get())
                && gameBoard[2].get().equals(gameBoard[6].get())) {
            System.out.println("winner diagonal"); // TODO: replace with winner label
        }

        //check for tie
        if(checkForTie()) {
            System.out.println("tie!"); // TODO: replace with tie label
        }

    }

    /*
     * NOTE TO MYSELF
     * Something wrong. If the board is full and also have a winner then it's both winner and tie.
     * Maybe I should have something for if the game is over/not over and check for tie?
     */
    private boolean checkForTie() {
        for (StringProperty index : gameBoard) {
            if (index != null && index.get().isEmpty()) {
                return false; // returns false if the board is not full aka not a tie
            }
        }
        return true; //returns true if all cells are filled aka it's a tie
    }
}





