package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

public class OccupiedCellException extends RuntimeException {
    public OccupiedCellException(String message) {
        super(message);
    }
}
