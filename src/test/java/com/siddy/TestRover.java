package com.siddy;

import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.IllformedLocaleException;

import static org.junit.Assert.*;

public class TestRover {

    Vehicle rover;

    @Before
    public void setup() {
        rover = new Rover(3, 5, Direction.EAST);
    }

    @Test
    public void checkPositionY() {
        assertEquals(3, rover.getPosY());
    }

    @Test
    public void checkPositionX() {
        assertEquals(5, rover.getPosX());
    }

    @Test
    public void checkDirection() {
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    public void checkGoLeft() {
        Status status = rover.processMovement("L");
        if (status != Status.NO_ERROR) {
            System.out.println("Error: " + status);
        }
        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    public void checkGoRight() {
        Status error = rover.processMovement("R");
        if (error != Status.NO_ERROR) {
            System.out.println("Error: " + error);
        }
        assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    public void checkMove() {
        Status status = rover.processMovement("M");
        if (status != Status.NO_ERROR) {
            System.out.println("Error: " + status);
        }
        assertEquals(6, rover.getPosX());
    }

    @Test
    public void checkTurnLeftMove() {
        Status status = rover.processMovement("LM");
        if (status != Status.NO_ERROR) {
            System.out.println("Error: " + status);
        }
        assertEquals(4, rover.getPosY());
    }

    @Test
    public void checkTurnRightMove() {
        Status status = rover.processMovement("RM");
        if (status != Status.NO_ERROR) {
            System.out.println("Error: " + status);
        }
        assertEquals(2, rover.getPosY());
    }

    @Test
    public void checkTurnRightRightMove() {
        Status status = rover.processMovement("RRM");
        if (status != Status.NO_ERROR) {
            System.out.println("Error: " + status);
        }
        assertEquals(4, rover.getPosX());
    }

    @Test
    public void checkLongInstruction() {
        Status status = rover.processMovement("LMLMMMLMRM");
        if (status != Status.NO_ERROR) {
            System.out.println("Error: " + status);
        }
        assertEquals(1, rover.getPosX());
        assertEquals(3, rover.getPosY());
        assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    public void checkInvalidInstructionString() {
        assertEquals(Status.ERROR_BAD_MOVEMENT_STRING, rover.processMovement("LMRFHLMMRMRLLMRL"));
    }

    @Test
    public void checkVehicleOnPlateau() {
        // Test correct Exception thrown
        Exception exception = assertThrows(IllformedLocaleException.class, () -> new Rover(12, 12, Direction.NORTH));
        // Test correct exception message returned
        assertEquals("Vehicle is not on plateau. Good luck!" , exception.getMessage());
    }
}