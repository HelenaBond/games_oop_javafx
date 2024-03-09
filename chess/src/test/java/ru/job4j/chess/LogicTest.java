package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException() throws FigureNotFoundException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class,
                () -> logic.move(Cell.C1, Cell.H6));
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenOccupiedCellException() throws OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.G5));
        logic.add(new KingBlack(Cell.E3));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class,
                () -> logic.move(Cell.G5, Cell.C1));
        assertThat(exception.getMessage()).isEqualTo("Figure cannot move due to other figures.");
    }
}
