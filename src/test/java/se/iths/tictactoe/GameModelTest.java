package se.iths.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Test for GameModel class")
class GameModelTest {

    private GameModel gameModel;

    //	This method runs before each test
    @BeforeEach
    void setUp() {
        gameModel = new GameModel();
    }

    @Test
    @DisplayName("Check if player move is valid")
    void checkIfPlayerMoveIsValid(){
        gameModel.playTurn(0); //när spelarsymbol sätts på cell 0

        assertThat(gameModel.gameBoard[0]).isEqualTo(gameModel.getPlayerX()); //då ska symbolen sättas på spelbrädan
    }

    @Test
    @DisplayName("Check if player move is invalid")
    void checkIfPlayerMoveIsInvalid() {
        gameModel.playTurn(0); // spelarsymbol sätts på cell 0
        gameModel.playTurn(0); // nästa drag placerar symbol på redan upptagen cell

        assertThat(gameModel.gameBoard[0]).isEqualTo(gameModel.getPlayerX()); //brädan bör bli oförändrad
    }

    @Test
    @DisplayName("Check for horizontal winner")
    void checkForHorizontalWinner() {
        //Arrange/Given a combination for horizontal winning
        gameModel.setSymbolOnBoard(0);
        gameModel.setSymbolOnBoard(1);
        gameModel.setSymbolOnBoard(2);

        //Act/When checking for winner
        gameModel.checkForWinner();

        //Assert/Then game should end and the winner should be X
        assertThat(gameModel.isGameEnd()).isTrue();
        assertThat(gameModel.getWinner()).isEqualTo("Winner is X");
    }

    @Test
    @DisplayName("Check for vertical winner")
    void checkForVerticalWinner() {
        //Arrange/Given a combination for vertical winning
        gameModel.setSymbolOnBoard(0);
        gameModel.setSymbolOnBoard(3);
        gameModel.setSymbolOnBoard(6);

        //Act/When checking for winner
        gameModel.checkForWinner();

        //Assert/Then game should end and the winner should be X
        assertThat(gameModel.isGameEnd()).isTrue();
        assertThat(gameModel.getWinner()).isEqualTo("Winner is X");
    }

    @Test
    @DisplayName("Check for diagonal winner")
    void checkForDiagonalWinner() {
        //Arrange/Given a combination for diagonal winning
        gameModel.setSymbolOnBoard(0);
        gameModel.setSymbolOnBoard(4);
        gameModel.setSymbolOnBoard(8);

        //Act/When checking for winner
        gameModel.checkForWinner();

        //Assert/Then game should end and the winner should be X
        assertThat(gameModel.isGameEnd()).isTrue();
        assertThat(gameModel.getWinner()).isEqualTo("Winner is X");
    }





}