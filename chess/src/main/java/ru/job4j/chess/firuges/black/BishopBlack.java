package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(this.position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", this.position, dest)
            );
        }
        int startX = this.position.getX();
        int startY = this.position.getY();
        int size = Math.abs(startX - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = startX < dest.getX() ? 1 : -1;
        int deltaY = startY < dest.getY() ? 1 : -1;
        for (int index = 0; index < size; index++) {
            startX += deltaX;
            startY += deltaY;
            steps[index] = Cell.findBy(startX, startY);
        }
        return steps;
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
