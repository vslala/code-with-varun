package com.bma.snakeladder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class BoardCell {
    private int row;
    private int col;
    private Type type;

    public BoardCell(int num, Type type) {
        if (num == 0) {
            throw new IllegalArgumentException("Board starts at 1");
        }
        num -= 1;
        this.type = type;
        this.row = num / 10;
        if (this.row % 2 == 0) {
            this.col = num % 10;
        } else {
            this.col = 9 - (num % 10);
        }

    }

    public BoardCell(int row, int col, Type type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }

    public static BoardCell zeroCell(Type type) {
        return new SimpleCell(0, -1, type);
    }

    public boolean isLast() {
        return this.row == 9 && this.col == 0;
    }

    public enum Type {
        SNAKE,
        LADDER,
        SIMPLE
    }
}
