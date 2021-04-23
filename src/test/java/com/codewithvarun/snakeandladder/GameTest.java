package com.codewithvarun.snakeandladder;

import com.codewithvarun.snakeandladder.chance.Ladder;
import com.codewithvarun.snakeandladder.chance.Snake;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private final List<Snake> snakes = List.of(new Snake(12, 2));
    private final List<Ladder> ladders = List.of(new Ladder(13, 3));
    private FakeDice fakeDice = new FakeDice();
    private Game game;

    @BeforeEach
    void beforeEach() {
        game = new Game(
                new ArrayList<>() {
                    {add(new Player("A"));}
                },
                fakeDice,
                snakes,
                ladders
                );
    }

    @AfterEach
    void afterEach() {
        game = null;
    }

    @Test
    void itShouldSetupGameBoardWith100Squares() {

        Player pos = game.currentPlayer();
        assertEquals(1, pos.getPosition().get());
    }

    @Test
    void itShouldMoveCurrentPlayer3Spaces() {
        var player = game.currentPlayer();
        fakeDice.setNextRoll(3);
        game.nextRoll();
        assertEquals(4, player.getPosition().get());

        fakeDice.setNextRoll(4);
        game.nextRoll();
        assertEquals(8, player.getPosition().get());
    }

    @Test
    void playerWinsTheGameWhenPlayerTokenHasReached100() {
        var player = game.currentPlayer();
        fakeDice.setNextRoll(96);
        game.nextRoll();
        assertEquals(97, player.getPosition().get());

        fakeDice.setNextRoll(3);
        assertThrows(GameOverException.class, () -> game.nextRoll());
    }

    @Test
    void playerDidNotWinTheGameIfPlayerTokenMovesBeyond100() {
        var player = game.currentPlayer();
        fakeDice.setNextRoll(96);
        game.nextRoll();
        assertEquals(97, player.getPosition().get());

        fakeDice.setNextRoll(4);
        game.nextRoll();
        assertEquals(97, player.getPosition().get());
    }

    @Test
    void playerTokenLandsOnSnakeHeadAt12AndMoveBackToSquare2() {
        var player = game.currentPlayer();
        fakeDice.setNextRoll(11);
        game.nextRoll();

        assertEquals(2, player.getPosition().get());
    }

    @Test
    void playerTokenLandsOnLadderTailAt3AndClimbUpTo13() {
        var player = game.currentPlayer();
        fakeDice.setNextRoll(2);
        game.nextRoll();

        assertEquals(13, player.getPosition().get());
    }

    @Test
    void determinePlayerOrder() {
        List<Player> players = new ArrayList<>() {
            {add(new Player("A"));}
            {add(new Player("B"));}
            {add(new Player("C"));}
        };
        var game = new Game(players, new PlasticDice(), snakes, ladders);
        game.determineOrder();

        players.forEach(player -> System.out.println(player.lastRoll()));
        assertTrue(players.get(0).lastRoll() >= players.get(1).lastRoll() && players.get(1).lastRoll() >= players.get(2).lastRoll());
    }

    @Test
    void everyPlayerShouldRollDiceOnTheirTurn() {
        List<Player> players = new ArrayList<>() {
            {add(new Player("A"));}
            {add(new Player("B"));}
            {add(new Player("C"));}
        };
        var game = new Game(players, new PlasticDice(), snakes, ladders);
        game.determineOrder();
        game.nextRoll();
        game.nextRoll();

        assertNotEquals(1, players.get(0).getPosition().get());
        assertNotEquals(1, players.get(1).getPosition().get());
    }

}