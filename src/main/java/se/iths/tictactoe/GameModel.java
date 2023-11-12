package se.iths.tictactoe;

import java.util.Arrays;
import java.util.Random;

public class GameModel {
    public int[] gameBoard;
    private int playerScore = 0;
    private int computerScore = 0;
    private int playerX = 1;
    private int playerO = -1;
    private int emptyCell = 0;
    private int currentPlayer = playerX; // Index 1 corresponds to 'X', index -1 corresponds to 'O'
    private boolean gameEnd;
    private String winner = "";
    private final String playerSymbolX = "X";
    private final String computerSymbolO = "O";
    private Random random = new Random();

    public GameModel() {
        gameBoard = new int[9];
        makeGameBoard();
    }

    public void makeGameBoard() {
        Arrays.fill(gameBoard, emptyCell);
    }

    public void playTurn(int clickedButtonIndex) {
        if (!gameEnd && gameBoard[clickedButtonIndex] == emptyCell) {
            setSymbolOnBoard(clickedButtonIndex);
            checkForWinner();
            changePlayer();
        }
    }

    public int computerTurn() {
        int buttonNumber;

        do {
            buttonNumber = random.nextInt(0,8);
            System.out.println("loop");
        } while (gameBoard[buttonNumber] != emptyCell);
        return buttonNumber;
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
            if (gameBoard[i] != emptyCell && gameBoard[i] == gameBoard[i + 1] && gameBoard[i] == gameBoard[i + 2]) {
                foundWinner(gameBoard[i]);
                return;
            }
        }

        // vertical winner
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i] != emptyCell && gameBoard[i] == gameBoard[i + 3] && gameBoard[i] == gameBoard[i + 6]) {
                foundWinner(gameBoard[i]);
                return;
            }
        }

        // diagonal winner
        if (gameBoard[0] != emptyCell && gameBoard[0] == gameBoard[4] && gameBoard[0] == gameBoard[8]) {
            foundWinner(gameBoard[0]);
            return;
        }
        if (gameBoard[2] != emptyCell && gameBoard[2] == gameBoard[4] && gameBoard[2] == gameBoard[6]) {
            foundWinner(gameBoard[2]);
            return;
        }


        if (isBoardFull()) {
            foundWinner(emptyCell);
        }
    }

    private boolean isBoardFull() {
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
            setWinner("Winner is " + playerSymbolX);
        } else if (winner == playerO) {
            computerScore++;
            setWinner("Winner is " + computerSymbolO);
        } else if (winner == emptyCell) {
            setWinner("It's a tie!");
        }
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