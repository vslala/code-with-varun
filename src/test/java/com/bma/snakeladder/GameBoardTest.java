package com.bma.snakeladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static com.bma.snakeladder.BoardCell.Type.SIMPLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameBoardTest {

    @Test
    void shouldInitializeGameBoard() {
        var board = new GameBoard();

        List<BoardCell> cells = board.cells();

        assertEquals(100, cells.size());
        assertEquals(new SimpleCell(0, 0, SIMPLE), cells.get(0));
        assertEquals(new SimpleCell(0, 9, SIMPLE), cells.get(9));
        assertEquals(new SimpleCell(1, 9, SIMPLE), cells.get(10));
        assertEquals(new SimpleCell(8, 9, SIMPLE), cells.get(89));
        assertEquals(new SimpleCell(9, 1, SIMPLE), cells.get(98));
        assertEquals(new SimpleCell(9, 0, SIMPLE), cells.get(99));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "90-6, 89",
            "11-1, 10",
            "23-6, 22",
            "27-6, 26",
            "98-76, 97",
            "50-3, 49",
    }, delimiter = ',')
    void itShouldAddSnakesToTheBoard(String headTail, int index) {
        var board = new GameBoard();
        board.addSnake(new Snake(Integer.parseInt(headTail.split("-")[0]), Integer.parseInt(headTail.split("-")[1])));
        List<BoardCell> cells = board.cells();
        Snake snakeCell = (Snake) cells.get(index);

        assertNotNull(snakeCell);
        assertNotNull(snakeCell.connectsTo());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6, 90",
            "1, 11",
            "8, 22",
            "27, 45",
            "76, 97",
            "50, 94",
    }, delimiter = ',')
    void itShouldAddLaddersToTheBoard(int bottom, int top) {
        var board = new GameBoard();
        board.addLadder(new Ladder(bottom, top));
        List<BoardCell> cells = board.cells();
        Ladder ladder = (Ladder) cells.get(bottom - 1);

        assertNotNull(ladder);
        assertNotNull(ladder.connectsTo());
    }
}
