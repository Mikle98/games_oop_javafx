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
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = position.getX() > dest.getX() ? -1 : 1;
        int deltaY = position.getY() > dest.getY() ? -1 : 1;
        for (int i = 0; i < size; i++) {
            steps[i] = Cell.findBy(position.getX() + (deltaX * (i + 1)),
                                    position.getY() + (deltaY * (i + 1)));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        /*boolean rsl = false;
        int xs = source.getX();
        int ys = source.getY();
        int xd = dest.getX();
        int yd = dest.getY();
        if ((xs > xd ? xs - xd : xd - xs) == (ys > yd ? ys - yd : yd - ys)) {
            rsl = true;
        }*/
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
