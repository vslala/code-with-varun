package com.bma.snakeladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameBoard {

    private final List<BoardCell> cells;

    public GameBoard() {
        cells = IntStream.range(1, 101)
                .mapToObj(num -> new SimpleCell(num, BoardCell.Type.SIMPLE))
                .collect(Collectors.toList());
    }

    public List<BoardCell> cells() {
        return Collections.unmodifiableList(cells);
    }

    public void addSnake(Snake snake) {
        if (snake.getRow() % 2 == 0) {
            int index = snake.getRow() * 10 + snake.getCol();
            cells.set(index, snake);
        } else {
            int col = 9 - snake.getCol();
            int index = snake.getRow() * 10 + col;
            cells.set(index, snake);
        }


//        if (snake.getRow() % 2 == 0) {
//            int index = snake.getRow() * 10 + snake.getCol();
//            cells.set(index, snake);
//        } else {
//            int index = snake.getRow() * 10 + (snake.getRow() > 5 ? Math.abs(snake.getCol() - snake.getRow() -1) - 1 : snake.getCol() + snake.getRow() - 1);
//            cells.set(index, snake);
//        }

    }

    public void addLadder(Ladder ladder) {
        if (ladder.getRow() % 2 == 0) {
            int index = ladder.getRow() * 10 + ladder.getCol();
            cells.set(index, ladder);
        } else {
            int col = 9 - ladder.getCol();
            int index = ladder.getRow() * 10 + col;
            cells.set(index, ladder);
        }
    }

    public BoardCell getEventualCell(int number) {
        BoardCell currentCell = cells.get(number);

        return switch (currentCell.getType()) {
            case LADDER -> {
                Ladder ladder = (Ladder) currentCell;
                yield ladder.connectsTo();
            }
            case SNAKE -> {
                Snake snake = (Snake) currentCell;
                yield snake.connectsTo();
            }
            case SIMPLE -> currentCell;
        };
    }
}
