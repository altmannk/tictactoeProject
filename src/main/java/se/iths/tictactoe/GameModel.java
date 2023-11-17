package se.iths.tictactoe;

import java.util.Arrays;
import java.util.Random;

public class GameModel {
    // Game board and scores
    public int[] gameBoard;
    private int playerScore = 0;
    private int computerScore = 0;

    // Constants for symbols and players
    private int playerX = 1; // index 1 corresponds to 'X'
    private int playerO = -1; // index -1 corresponds to 'O'
    private int emptyCell = 0;
    private int currentPlayer = playerX;

    // Game status variables
    private boolean gameEnd;
    private String winner = "";
    private final String playerSymbolX = "X";
    private final String computerSymbolO = "O";
    private Random random = new Random();

    // Constructor initializes the game board
    public GameModel() {
        gameBoard = new int[9];
        makeGameBoard();
    }

    // Initializes the game board
    public void makeGameBoard() {
        Arrays.fill(gameBoard, emptyCell);
    }

    // Handles the player move
    public void playTurn(int clickedButtonIndex) {
        if (!gameEnd && gameBoard[clickedButtonIndex] == emptyCell) {
            setSymbolOnBoard(clickedButtonIndex);
            checkForWinner();
            changePlayer();
        }
    }

    // Simulates the computer move
    public int computerTurn() {
        int buttonNumber;

        do {
            buttonNumber = random.nextInt(0,8);
        } while (gameBoard[buttonNumber] != emptyCell);
        return buttonNumber;
    }

    // Places the "symbol" (1 or -1) on the board
    public void setSymbolOnBoard(int clickedButtonIndex) {
        gameBoard[clickedButtonIndex] = currentPlayer;
    }

    // Retrieves the current players symbol (X or O)
    public String getCurrentsPlayerSymbol() {
        return currentPlayer == playerO ? "X" : "O";
    }

    // Changes the player after each turn
    public void changePlayer() {
        currentPlayer = (currentPlayer == playerO) ? playerX : playerO;
    }

    // Check for a winner or a tie
    public void checkForWinner() {
        // Horizontal winner
        for (int i = 0; i < gameBoard.length; i += 3) {
            if (gameBoard[i] != emptyCell && gameBoard[i] == gameBoard[i + 1] && gameBoard[i] == gameBoard[i + 2]) {
                foundWinner(gameBoard[i]);
                return;
            }
        }

        // Vertical winner
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i] != emptyCell && gameBoard[i] == gameBoard[i + 3] && gameBoard[i] == gameBoard[i + 6]) {
                foundWinner(gameBoard[i]);
                return;
            }
        }

        // Diagonal winner
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

    // Checks if the game board is full
    public boolean isBoardFull() {
        if (winner.equals(playerSymbolX) || winner.equals(computerSymbolO))
            return false;

        for (int cell : gameBoard) {
            if (cell == emptyCell)
                return false;
        }
        return true;
    }

    // Updates the winner and game end status
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

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }

    public String getPlayerScore() {
        return String.valueOf(playerScore);
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public String getComputerScore() {
        return String.valueOf(computerScore);
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}