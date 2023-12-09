package badIceCream.model;

import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceWall;
import badIceCream.model.game.elements.Wall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArenaTest {
    private Arena arena;
    private Position position;
    private Position otherPosition;

    @BeforeEach
    public void setUp() {
        arena = new Arena(10,10);
        position = mock(Position.class);
        otherPosition = mock(Position.class);
    }

    @Test
    public void isEmpty() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        when(otherPosition.getX()).thenReturn(0);
        when(otherPosition.getY()).thenReturn(0);

        Wall wall = mock(IceWall.class);
        when(wall.getPosition()).thenReturn(position);
        List<Wall> walls = new ArrayList<>();
        walls.add(wall);
        arena.setWalls(walls);
        assertTrue(arena.isEmpty(otherPosition));
        assertFalse(arena.isEmpty(position));
    }
    @Test
    public void isEmptyMonsters() {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);

        IceWall iceWall = mock(IceWall.class);
        when(iceWall.getPosition()).thenReturn(position);

        List<Wall> walls = new ArrayList<>();
        walls.add(iceWall);
        arena.setWalls(walls);
        assertFalse(arena.isEmpty(position));
    }
}
