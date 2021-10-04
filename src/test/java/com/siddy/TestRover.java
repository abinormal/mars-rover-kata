package com.siddy;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestRover {

    @Test
    public void checkPosition(){
        // Arrange
        Vehicle rover = new Rover(3,3, Direction.EAST);
        // Act
        int y = rover.getPosY();
        // Assert
        assertEquals(3, y);
    }
}
