package se.iths.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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




}