package com.bma.snakeladder;

public class Snake extends BoardCell {

    private final BoardCell connectsTo;

    public Snake(int row, int col, BoardCell connectsTo) {
        super(row, col, BoardCell.Type.SNAKE);
        this.connectsTo = connectsTo;
    }

    public Snake(int head, int tail) {
        super(head, Type.SNAKE);
        this.connectsTo = new SimpleCell(tail, Type.SIMPLE);

        if (this.getRow() == this.connectsTo.getRow()) {
            throw new RuntimeException("Snake must connect different rows");
        }
    }

    public BoardCell connectsTo() {
        return connectsTo;
    }
}
