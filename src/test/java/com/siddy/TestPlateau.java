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
    public void checkYEdge(){
        p.Plateau(15,7);
        assertEquals(7, p.getYMax());
    }

    @Test
    public void checkXEdge(){
        p.Plateau(5,27);
        assertEquals(5, p.getXMax());
    }

    @Test
    public void checkXMinus(){
        p.Plateau(-5,27);
        // Throw an exception/fail
        assertEquals(5, p.getXMax());
    }
}
