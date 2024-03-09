package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void whenPositionF8() {
        Cell expected = Cell.F8;
        BishopBlack bishopBlack = new BishopBlack(expected);
        Cell actual = bishopBlack.position();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenPositionC8() {
        Cell expected = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(expected);
        Cell actual = bishopBlack.position();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenCopyF8() {
        Cell expected = Cell.F8;
        BishopBlack bishopBlack = new BishopBlack(expected);
        BishopBlack copy = (BishopBlack) bishopBlack.copy(expected);
        Cell actual = copy.position();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenCopyC8() {
        Cell expected = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(expected);
        BishopBlack copy = (BishopBlack) bishopBlack.copy(expected);
        Cell actual = copy.position();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenWayG5FromC1ThenD2E3F4G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] actual = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenWayH3FromC8ThenD7E6F5G4H3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell[] actual = bishopBlack.way(Cell.H3);
        Cell[] expected = {Cell.D7, Cell.E6, Cell.F5, Cell.G4, Cell.H3};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenWayA3FromF8ThenE7D6C5B4A3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell[] actual = bishopBlack.way(Cell.A3);
        Cell[] expected = {Cell.E7, Cell.D6, Cell.C5, Cell.B4, Cell.A3};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenWayA3FromC1ThenB2A3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] actual = bishopBlack.way(Cell.A3);
        Cell[] expected = {Cell.B2, Cell.A3};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenWayA4FromC1ThenImpossibleMoveException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bishopBlack.way(Cell.A4));
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to A4");
    }

    @Test
    public void whenWayA2FromC1ThenImpossibleMoveException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bishopBlack.way(Cell.A2));
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to A2");
    }
}
