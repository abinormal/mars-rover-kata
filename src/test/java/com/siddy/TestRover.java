package com.siddy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRover {

    @Test
    public void checkPositionY() {
        // Arrange
        Vehicle rover = new Rover(3, 5, Direction.EAST);
        // Act
        int y = rover.getPosY();
        // Assert
        assertEquals(3, y);
    }

    @Test
    public void checkPositionX() {
        // Arrange
        Vehicle rover = new Rover(3, 5, Direction.EAST);
        // Act
        int x = rover.getPosX();
        // Assert
        assertEquals(5, x);
    }

    @Test
    public void checkDirection() {
        // Arrange
        Vehicle rover = new Rover(3, 5, Direction.EAST);
        // Act
        Direction d = rover.getDirection();
        // Assert
        assertEquals(Direction.EAST, d);
    }
}
