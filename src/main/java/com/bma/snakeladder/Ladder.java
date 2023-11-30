package com.bma.snakeladder;

public class Ladder extends BoardCell {
    private final BoardCell connectsTo;

    public Ladder(int bottom, int top) {
        super(bottom, BoardCell.Type.LADDER);
        this.connectsTo = new SimpleCell(top, Type.SIMPLE);

        if (this.getRow() == this.connectsTo.getRow()) {
            throw new RuntimeException("Snake must connect different rows");
        }
    }

    public BoardCell connectsTo() {
        return this.connectsTo;
    }
}
