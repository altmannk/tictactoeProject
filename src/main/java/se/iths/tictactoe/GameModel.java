package se.iths.tictactoe;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

public class GameModel {
    public int[] gameBoard;
    private int playerScore = 0;
    private int computerScore = 0;
    private int playerX = 1;
    private int playerO = -1;
    private int emptyCell = 0;
    private int currentPlayer = playerX; // Index 0 corresponds to 'X', index 1 corresponds to 'O'
    private boolean gameEnd;
    private String winner = "";
    private String playerSymbolX = "X";
    private String computerSymbolO = "O";


    public GameModel() {
        gameBoard = new int[9];
        makeGameBoard();
    }

    public void makeGameBoard() {
        Arrays.fill(gameBoard, emptyCell);
    }

    public void playTurn(int clickedButtonIndex) {
        setSymbolOnBoard(clickedButtonIndex);
        checkForWinner();
        changePlayer();

    }

    private void setSymbolOnBoard(int clickedButtonIndex) {
        gameBoard[clickedButtonIndex] = currentPlayer;

    }

    public String getCurrentsPlayerSymbol() {
        return currentPlayer == playerO ? "X" : "O";
    }

    private void changePlayer() {
        currentPlayer = (currentPlayer == playerO) ? playerX : playerO;
    }

    public void checkForWinner() {
        // horizontal winner
        for (int i = 0; i < gameBoard.length; i += 3) {
            if (gameBoard[i] != emptyCell && gameBoard[i] == gameBoard[i + 1] && gameBoard[i] == gameBoard[i + 2])
                foundWinner(gameBoard[i]);
        }

        // vertical winner
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i] != emptyCell && gameBoard[i] == gameBoard[i + 3] && gameBoard[i] == gameBoard[i + 6])
                foundWinner(gameBoard[i]);
        }

        // diagonal winner
        if (gameBoard[0] != emptyCell && gameBoard[0] == gameBoard[4] && gameBoard[0] == gameBoard[8])
            foundWinner(gameBoard[0]);
        if (gameBoard[2] != emptyCell && gameBoard[2] == gameBoard[4] && gameBoard[2] == gameBoard[6])
            foundWinner(gameBoard[2]);


        if (checkForTie()) {
            foundWinner(emptyCell);
            System.out.println("Tie!");
        }
    }

    private boolean checkForTie() {
        if (winner.equals(playerSymbolX) || winner.equals(computerSymbolO))
            return false;

        for (int cell : gameBoard) {
            if (cell == emptyCell)
                return false;
        }
        return true;
    }

    public void foundWinner(int winner) {
        if (winner == playerX) {
            playerScore++;
            setWinner(playerSymbolX);
        } else if (winner == playerO) {
            computerScore++;
            setWinner(computerSymbolO);
        } else
            setWinner("tie");
        gameEnd = true;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public String getPlayerScore() {
        return String.valueOf(playerScore);
    }

    public String getComputerScore() {
        return String.valueOf(computerScore);
    }

    public String getWinner() {
        return winner;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}





