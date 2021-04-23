package com.codewithvarun.snakeandladder;

import com.codewithvarun.snakeandladder.chance.Ladder;
import com.codewithvarun.snakeandladder.chance.Snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.in;
import static java.lang.System.out;

public class SnakeAndLadderGame {
    public static void main(String[] args) {
        var scan = new Scanner(in);

        // add players
        List<Player> players = new ArrayList<>();
        out.println("How many players?");
        int playerCount = Integer.parseInt(scan.nextLine());
        IntStream.range(0, playerCount).forEach(player -> {
            out.println("Enter Player " + (player + 1) + " name?");
            players.add(new Player(scan.nextLine()));
        });

        out.println("Setting up game board!!!");
        final List<Snake> snakes = List.of(new Snake(12, 2));
        final List<Ladder> ladders = List.of(new Ladder(13, 3));
        Game game = new Game(players, new PlasticDice(), snakes, ladders);

        out.println("Determining Player Move Order!!!");
        game.determineOrder();
        out.println(game.currentPlayer().name() + " Turn!!!");

        try {
            while (true) {
                out.println(game.currentPlayer().name() + " rolled the dice.");
                game.nextRoll();
            }
        } catch (GameOverException e) {
            out.println(game.currentPlayer().name() + ": Won the game!!!");
        }




    }
}
