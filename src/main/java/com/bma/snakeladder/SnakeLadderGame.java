package com.bma.snakeladder;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SnakeLadderGame {

    private final List<User> users;
    private final GameBoard gameBoard;
    private final Dice dice;
    private final ScoreCard scoreCard;

    private User currentUser;
    private int tossOutcome = 0;

    public SnakeLadderGame(List<User> users, GameBoard gameBoard, Dice dice, ScoreCard scoreCard) {
        this.users = users;
        this.gameBoard = gameBoard;
        this.dice = dice;
        this.scoreCard = scoreCard;
    }

    public int toss() {
        int outcome = ThreadLocalRandom.current().nextInt(1, 3);
        this.currentUser = users.get(outcome - 1);
        this.tossOutcome = outcome;
        return outcome;
    }

    public List<User> users() {
        return Collections.unmodifiableList(users);
    }

    public User currentUser() {
        return this.currentUser;
    }

    public void rollDice() {
        int diceOutcome = this.currentUser.rollDice(dice);
        int currentPosition = convertCoordToNumber(currentUser.getPosition());
        BoardCell cell = gameBoard.getEventualCell(currentPosition + diceOutcome > 99 ? currentPosition : currentPosition + diceOutcome);

        this.currentUser.setPosition(cell);
        changeUserTurn();

        if (cell.isLast()) {
            throw new RuntimeException("Round Over! " + currentUser.getUsername() + " is the winner!");
        }
    }

    private void changeUserTurn() {
        int currentIndex = this.users.indexOf(currentUser);
        this.currentUser = this.users.get(currentIndex == 0 ? 1 : 0);
    }

    private int convertCoordToNumber(BoardCell position) {
        if (position.getRow() % 2 == 0) {
            return position.getRow() * 10 + position.getCol();
        } else {
            int col = 9 - position.getCol();
            return position.getRow() * 10 + col;
        }
    }
}
