package com.siddy;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPlateau {

    @Test
    public void checkYEdgeCorrect() {
        Plateau p = new Plateau(15, 7);
        assertEquals(7, p.getYMax());
    }

    @Test
    public void checkXEdgeCorrect() {
        Plateau p = new Plateau(5, 27);
        assertEquals(5, p.getXMax());
    }

    @Test
    public void assertMinusPlateauValueExceptionX() {
        String exceptionMessage = "";
        String message = "Plateau size must be greater than zero";
        try {
            Plateau plateau = new Plateau(-5, 12);
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }
        assertEquals(message, exceptionMessage);
    }

    @Test
    public void assertMinusPlateauValueExceptionY() {
        String exceptionMessage = "";
        String message = "Plateau size must be greater than zero";
        try {
            Plateau plateau = new Plateau(15, -12);
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }
        assertEquals(message, exceptionMessage);
    }

    @Test
    public void assertZeroPlateauValueExceptionX() {
        String exceptionMessage = "";
        String message = "Plateau size must be greater than zero";
        try {
            Plateau plateau = new Plateau(0, 12);
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }
        assertEquals(message, exceptionMessage);
    }

    @Test
    public void assertZeroPlateauValueExceptionY() {
        String exceptionMessage = "";
        String message = "Plateau size must be greater than zero";
        try {
            Plateau plateau = new Plateau(15, 0);
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }
        assertEquals(message, exceptionMessage);
    }

    @Test
    public void checkCantMoveNorth() {
        // Given a value can the vehicle move 1 space in the given direction?
        Plateau p = new Plateau(5, 6);
        assertEquals(Error.ERROR_OVER_EDGE, p.move(4, 6, Direction.NORTH));
    }

    @Test
    public void checkCantMoveEast() {
        // Given a value can the vehicle move 1 space in the given direction?
        Plateau p = new Plateau(5, 6);
        assertEquals(Error.ERROR_OVER_EDGE, p.move(5, 3, Direction.EAST));
    }

    @Test
    public void checkCantMoveSouth() {
        // Given a value can the vehicle move 1 space in the given direction?
        Plateau p = new Plateau(5, 6);
        assertEquals(Error.ERROR_OVER_EDGE, p.move(5, 0, Direction.SOUTH));
    }

    @Test
    public void checkCantMoveWest() {
        // Given a value can the vehicle move 1 space in the given direction?
        Plateau p = new Plateau(5, 6);
        assertEquals(Error.ERROR_OVER_EDGE, p.move(0, 3, Direction.WEST));
    }

    @Test
    public void checkCanMoveNorth() {
        // Given a value can the vehicle move 1 space in the given direction?
        Plateau p = new Plateau(5, 6);
        assertEquals(Error.NO_ERROR, p.move(1, 5, Direction.NORTH));
    }

    @Test
    public void checkCanMoveEast() {
        // Given a value can the vehicle move 1 space in the given direction?
        Plateau p = new Plateau(5, 6);
        assertEquals(Error.NO_ERROR, p.move(4, 3, Direction.EAST));
    }

    @Test
    public void checkCanMoveSouth() {
        // Given a value can the vehicle move 1 space in the given direction?
        Plateau p = new Plateau(5, 6);
        assertEquals(Error.NO_ERROR, p.move(1, 1, Direction.SOUTH));
    }

    @Test
    public void checkCanMoveWest() {
        // Given a value can the vehicle move 1 space in the given direction?
        Plateau p = new Plateau(5, 6);
        assertEquals(Error.NO_ERROR, p.move(1, 3, Direction.WEST));
    }
}
