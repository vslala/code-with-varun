package com.bma.snakeladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnakeLadderGameTest {

    static class MockDice extends Dice {

        private int roll = 1;

        @Override
        public int roll() {
            return this.roll;
        }

        public void setRoll(int roll) {
            this.roll = roll;
        }
    }

    private MockDice dice;
    private GameBoard gameBoard;
    private SnakeLadderGame game;

    @BeforeEach
    void shouldStartAFreshGameOnInitialization() {
        var users = List.of(new User( "user1"), new User("user2"));
        gameBoard = new GameBoard();
        dice = new MockDice();
        var scoreCard = new ScoreCard();
        game = new SnakeLadderGame(users, gameBoard, dice, scoreCard);

        assertNotNull(game);
    }

    @RepeatedTest(20)
    void shouldPerformATossToInitializeFirstPlay() {
        int result = game.toss();

        assertTrue(result == 1 || result == 2);
    }

    @Test
    void shouldRollDice() {
        game.toss();
        dice.setRoll(6);

        User currentUser = game.currentUser();
        game.rollDice(); // change player turn
        User nextUser = game.currentUser();

        assertEquals(BoardCell.Type.SIMPLE,  currentUser.getPosition().getType());
        assertEquals(new SimpleCell(6, BoardCell.Type.SIMPLE), currentUser.getPosition());

        game.rollDice(); // change player turn

        assertNotEquals(currentUser, nextUser);
        assertEquals(currentUser, game.currentUser());
        assertEquals(new SimpleCell(6, BoardCell.Type.SIMPLE), currentUser.getPosition());
        assertEquals(new SimpleCell(6, BoardCell.Type.SIMPLE), nextUser.getPosition());
    }

    @Test
    void userFindsTheLadder() {
        gameBoard.addLadder(new Ladder(6, 22));
        game.toss();
        dice.setRoll(6);

        User currentUser = game.currentUser();
        game.rollDice();

        assertEquals(new SimpleCell(22, BoardCell.Type.SIMPLE), currentUser.getPosition());
    }

    @Test
    void userBitByTheSnake() {
        gameBoard.addLadder(new Ladder(6, 22));
        gameBoard.addSnake(new Snake(26, 5));

        game.toss();
        dice.setRoll(6);
        User currentUser = game.currentUser();
        game.rollDice(); // player 1 rolls
        game.rollDice(); // player 2 rolls

        dice.setRoll(4);
        game.rollDice(); // player 1 rolls again

        assertEquals(new SimpleCell(5, BoardCell.Type.SIMPLE), currentUser.getPosition());
    }

    @Test
    void userWinsTheGame() {
        gameBoard.addLadder(new Ladder(6, 99));

        game.toss();
        dice.setRoll(6);
        User currentUser = game.currentUser();
        game.rollDice(); // player 1 rolls
        game.rollDice(); // player 2 rolls

        dice.setRoll(1);
        assertThrows(RuntimeException.class, () -> {
            game.rollDice();
        });
    }

    @Test
    void userRollsBeyondTheFinalMark() {
        gameBoard.addLadder(new Ladder(6, 99));

        game.toss();
        dice.setRoll(6);
        User currentUser = game.currentUser();
        game.rollDice(); // player 1 rolls
        game.rollDice(); // player 2 rolls
        game.rollDice(); // player 1 rolls again

        assertEquals(new SimpleCell(99, BoardCell.Type.SIMPLE), currentUser.getPosition());
    }
}
