package org.example.model;

import org.example.model.game.arena.Arena;
import org.example.model.game.elements.IceCream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(0,0);
    }

    @Test
    public void testGetLeft() {
        Position newpos = position.getLeft();
        Position expected = new Position(-1, 0);
        assertEquals(expected.getX(), newpos.getX());
        assertEquals(expected.getY(), newpos.getY());
    }
    @Test
    public void testGetRight() {
        Position newpos = position.getRight();
        Position expected = new Position(1, 0);
        assertEquals(expected.getX(), newpos.getX());
        assertEquals(expected.getY(), newpos.getY());
    }
    @Test
    public void testGetUp() {
        Position newpos = position.getUp();
        Position expected = new Position(0, -1);
        assertEquals(expected.getX(), newpos.getX());
        assertEquals(expected.getY(), newpos.getY());
    }
    @Test
    public void testGetDown() {
        Position newpos = position.getDown();
        Position expected = new Position(0, 1);
        assertEquals(expected.getX(), newpos.getX());
        assertEquals(expected.getY(), newpos.getY());
    }
}
