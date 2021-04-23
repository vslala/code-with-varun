package com.codewithvarun.snakeandladder;


import com.codewithvarun.snakeandladder.chance.Ladder;
import com.codewithvarun.snakeandladder.chance.Snake;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Game {

    private final Dice dice;
    private final List<Snake> snakes;
    private final List<Ladder> ladders;
    private List<Player> players;
    private Player currentPlayer;
    private int playerCount = 0;

    public Game(List<Player> players, Dice dice, List<Snake> snakes, List<Ladder> ladders) {
        this.players = players;
        this.currentPlayer = players.get(0);
        this.dice = dice;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public Player currentPlayer() {
        return this.currentPlayer;
    }

    public void nextRoll() {
        currentPlayer.rollDice(dice);
        currentPlayer.move();
        int currPos = currentPlayer.getPosition().get();

        Optional<Snake> snakeMove = snakes.stream()
                .filter(snake -> snake.head() == currPos)
                .findFirst();
        snakeMove.ifPresent(snake -> currentPlayer.moveTo(snake.tail()));

        Optional<Ladder> ladderMove = ladders.stream()
                .filter(ladder -> ladder.tail() == currPos)
                .findFirst();
        ladderMove.ifPresent(ladder -> currentPlayer.moveTo(ladder.head()));

        System.out.println(currentPlayer.name() + " moved to " + currentPlayer.getPosition().get());

        currentPlayer = players.get(++playerCount % players.size());
    }

    public List<Player> determineOrder() {
        players.forEach(player -> player.rollDice(dice));
        players.sort(Comparator.comparingInt(Player::lastRoll));
        Collections.reverse(players);
        currentPlayer = players.get(playerCount);
        return players;
    }
}
