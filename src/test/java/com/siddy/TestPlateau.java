package com.siddy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPlateau {

    private Plateau p;

    @Before
    public void setup() {
        p = new Plateau();
    }

    @Test
    public void checkYEdge() {
        p.Plateau(15, 7);
        assertEquals(7, p.getYMax());
    }

    @Test
    public void checkXEdge() {
        p.Plateau(5, 27);
        assertEquals(5, p.getXMax());
    }

    @Test
    public void checkXMinus() {
        // Return Error
        assertEquals(Error.ERROR_INVALID_PLATEAU_SIZE, p.Plateau(-5, 27));
    }

    @Test
    public void checkYMinus() {
        // Return Error
        assertEquals(Error.ERROR_INVALID_PLATEAU_SIZE, p.Plateau(15, -27));
    }

    @Test
    public void checkcantMoveNorth() {
        // Given a value can the vehicle move 1 space in the given direction?
        Error result = Error.NO_ERROR;
        if (p.Plateau(5, 6) == Error.NO_ERROR) {
            result = p.move(4, 6, Direction.NORTH);
        }
        assertEquals(Error.ERROR_OVER_EDGE, result);
    }

    @Test
    public void checkcantMoveEast() {
        // Given a value can the vehicle move 1 space in the given direction?
        Error result = Error.NO_ERROR;
        if (p.Plateau(5, 6) == Error.NO_ERROR) {
            result = p.move(5, 3, Direction.EAST);
        }
        assertEquals(Error.ERROR_OVER_EDGE, result);
    }

    @Test
    public void checkcantMoveSouth() {
        // Given a value can the vehicle move 1 space in the given direction?
        Error result = Error.NO_ERROR;
        if (p.Plateau(5, 6) == Error.NO_ERROR) {
            result = p.move(5, 0, Direction.SOUTH);
        }
        assertEquals(Error.ERROR_OVER_EDGE, result);
    }

    @Test
    public void checkcantMoveWest() {
        // Given a value can the vehicle move 1 space in the given direction?
        Error result = Error.NO_ERROR;
        if (p.Plateau(5, 6) == Error.NO_ERROR) {
            result = p.move(0, 3, Direction.WEST);
        }
        assertEquals(Error.ERROR_OVER_EDGE, result);
    }

    @Test
    public void checkCanMoveNorth() {
        // Given a value can the vehicle move 1 space in the given direction?
        Error result = Error.NO_ERROR;
        if (p.Plateau(5, 6) == Error.NO_ERROR) {
            result = p.move(1, 3, Direction.NORTH);
        }
        assertEquals(Error.NO_ERROR, result);
    }

    @Test
    public void checkCanMoveEast() {
        // Given a value can the vehicle move 1 space in the given direction?
        Error result = Error.NO_ERROR;
        if (p.Plateau(5, 6) == Error.NO_ERROR) {
            result = p.move(4, 3, Direction.EAST);
        }
        assertEquals(Error.NO_ERROR, result);
    }

    @Test
    public void checkCanMoveSouth() {
        // Given a value can the vehicle move 1 space in the given direction?
        Error result = Error.NO_ERROR;
        if (p.Plateau(5, 6) == Error.NO_ERROR) {
            result = p.move(1, 1, Direction.SOUTH);
        }
        assertEquals(Error.NO_ERROR, result);
    }

    @Test
    public void checkCanMoveWest() {
        // Given a value can the vehicle move 1 space in the given direction?
        Error result = Error.NO_ERROR;
        if (p.Plateau(5, 6) == Error.NO_ERROR) {
            result = p.move(1, 3, Direction.WEST);
        }
        assertEquals(Error.NO_ERROR, result);
    }
}
