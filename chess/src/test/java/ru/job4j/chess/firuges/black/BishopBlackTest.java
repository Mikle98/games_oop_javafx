package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopBlackTest {

    @Test
    public void position() {
        Cell rsl = Cell.A1;
        Figure figure = new BishopBlack(Cell.A1);
        Cell answer = figure.position();
        assertThat(rsl).isEqualTo(answer);
    }

    @Test
    public void copy() {
        Figure figure = new BishopBlack(Cell.A1);
        Figure newFigure = figure.copy(Cell.A2);
        Cell rsl = Cell.A2;
        assertThat(rsl).isEqualTo(newFigure.position());
    }

    @Test
    public void way() {
        Figure figure = new BishopBlack(Cell.C1);
        Cell[] answer = figure.way(Cell.G5);
        Cell[] rsl = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(rsl).isEqualTo(answer);
    }

    @Test
    public void falseWay() {
        Figure figure = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
          ImpossibleMoveException.class,
                () -> {
                    Cell[] answer = figure.way(Cell.C8);
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to C8");
    }
}