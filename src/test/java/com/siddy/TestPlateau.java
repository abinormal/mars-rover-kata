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
}
