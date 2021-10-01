package com.siddy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPlateau {

    @Test
    public void checkYEdge() {
        Plateau p = new Plateau(15, 7);
        assertEquals(7, p.getYMax());
    }

    @Test
    public void checkXEdge() {
        Plateau p = new Plateau(5, 27);
        assertEquals(5, p.getXMax());
    }

    @Test
    public void assertMinusPlateauValueException() {
        String exceptionMessage = "";
        String message = "Plateau size must be greater than zero";
        try {
            Plateau plateau = new Plateau(-5,12);
        } catch (Exception exception){
            exceptionMessage = exception.getMessage();
        }
        assertEquals(message, exceptionMessage);
    }

//
//    @Test
//    public void checkYMinus() {
//        // Return Error
//        assertEquals(Error.ERROR_INVALID_PLATEAU_SIZE, p.Plateau(15, -27));
//    }
//
//    @Test
//    public void checkCantMoveNorth() {
//        // Given a value can the vehicle move 1 space in the given direction?
//        Error result = Error.NO_ERROR;
//        if (p.Plateau(5, 6) == Error.NO_ERROR) {
//            result = p.move(4, 6, Direction.NORTH);
//        }
//        assertEquals(Error.ERROR_OVER_EDGE, result);
//    }
//
//    @Test
//    public void checkCantMoveEast() {
//        // Given a value can the vehicle move 1 space in the given direction?
//        Error result = Error.NO_ERROR;
//        if (p.Plateau(5, 6) == Error.NO_ERROR) {
//            result = p.move(5, 3, Direction.EAST);
//        }
//        assertEquals(Error.ERROR_OVER_EDGE, result);
//    }
//
//    @Test
//    public void checkCantMoveSouth() {
//        // Given a value can the vehicle move 1 space in the given direction?
//        Error result = Error.NO_ERROR;
//        if (p.Plateau(5, 6) == Error.NO_ERROR) {
//            result = p.move(5, 0, Direction.SOUTH);
//        }
//        assertEquals(Error.ERROR_OVER_EDGE, result);
//    }
//
//    @Test
//    public void checkCantMoveWest() {
//        // Given a value can the vehicle move 1 space in the given direction?
//        Error result = Error.NO_ERROR;
//        if (p.Plateau(5, 6) == Error.NO_ERROR) {
//            result = p.move(0, 3, Direction.WEST);
//        }
//        assertEquals(Error.ERROR_OVER_EDGE, result);
//    }
//
//    @Test
//    public void checkCanMoveNorth() {
//        // Given a value can the vehicle move 1 space in the given direction?
//        Error result = Error.NO_ERROR;
//        if (p.Plateau(5, 6) == Error.NO_ERROR) {
//            result = p.move(1, 5, Direction.NORTH);
//        }
//        assertEquals(Error.NO_ERROR, result);
//    }
//
//    @Test
//    public void checkCanMoveEast() {
//        // Given a value can the vehicle move 1 space in the given direction?
//        Error result = Error.NO_ERROR;
//        if (p.Plateau(5, 6) == Error.NO_ERROR) {
//            result = p.move(4, 3, Direction.EAST);
//        }
//        assertEquals(Error.NO_ERROR, result);
//    }
//
//    @Test
//    public void checkCanMoveSouth() {
//        // Given a value can the vehicle move 1 space in the given direction?
//        Error result = Error.NO_ERROR;
//        if (p.Plateau(5, 6) == Error.NO_ERROR) {
//            result = p.move(1, 1, Direction.SOUTH);
//        }
//        assertEquals(Error.NO_ERROR, result);
//    }
//
//    @Test
//    public void checkCanMoveWest() {
//        // Given a value can the vehicle move 1 space in the given direction?
//        Error result = Error.NO_ERROR;
//        if (p.Plateau(5, 6) == Error.NO_ERROR) {
//            result = p.move(1, 3, Direction.WEST);
//        }
//        assertEquals(Error.NO_ERROR, result);
//    }

}
