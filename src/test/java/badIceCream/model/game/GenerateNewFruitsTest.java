package badIceCream.model.game;

import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.StoneWall;
import badIceCream.model.game.elements.Wall;
import badIceCream.model.game.elements.fruits.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class GenerateNewFruitsTest {
    private Arena arena;
    @Mock
    private StoneWall stoneWall1, stoneWall2, stoneWall3, stoneWall4,
            stoneWall5, stoneWall6, stoneWall7, stoneWall8, stoneWall9,
            stoneWall10, stoneWall11, stoneWall12, stoneWall13, stoneWall14,
            stoneWall15,  stoneWall16, stoneWall17, stoneWall18, stoneWall19, stoneWall20;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        arena = new Arena(6,6);
        when(stoneWall1.getPosition()).thenReturn(new Position(0,0));
        when(stoneWall2.getPosition()).thenReturn(new Position(1,0));
        when(stoneWall3.getPosition()).thenReturn(new Position(2,0));
        when(stoneWall4.getPosition()).thenReturn(new Position(3,0));
        when(stoneWall5.getPosition()).thenReturn(new Position(4,0));
        when(stoneWall6.getPosition()).thenReturn(new Position(5,0));
        when(stoneWall7.getPosition()).thenReturn(new Position(0,1));
        when(stoneWall8.getPosition()).thenReturn(new Position(5,1));
        when(stoneWall9.getPosition()).thenReturn(new Position(0,2));
        when(stoneWall10.getPosition()).thenReturn(new Position(5,2));
        when(stoneWall11.getPosition()).thenReturn(new Position(0,3));
        when(stoneWall12.getPosition()).thenReturn(new Position(5,3));
        when(stoneWall13.getPosition()).thenReturn(new Position(0,4));
        when(stoneWall14.getPosition()).thenReturn(new Position(5,4));
        when(stoneWall15.getPosition()).thenReturn(new Position(0,5));
        when(stoneWall16.getPosition()).thenReturn(new Position(1,5));
        when(stoneWall17.getPosition()).thenReturn(new Position(2,5));
        when(stoneWall18.getPosition()).thenReturn(new Position(3,5));
        when(stoneWall19.getPosition()).thenReturn(new Position(4,5));
        when(stoneWall20.getPosition()).thenReturn(new Position(5,5));
        List<Wall> walls = new ArrayList<>(Arrays.asList(stoneWall1, stoneWall2, stoneWall3, stoneWall4, stoneWall5,
                stoneWall6, stoneWall7, stoneWall8, stoneWall9, stoneWall10, stoneWall11, stoneWall12,
                stoneWall13, stoneWall14, stoneWall15, stoneWall16, stoneWall17, stoneWall18, stoneWall19, stoneWall20));
        arena.setWalls(walls);
        List<Fruit> fruits = new ArrayList<>();
        arena.setFruits(fruits);
    }
    @Test
    public void generateNewFruitsLevel1() {
        arena.generateNewFruits(1);
        assertEquals(6, arena.getFruits().size());
        for (Fruit fruit : arena.getFruits()) {
            assertTrue(fruit instanceof AppleFruit);
            assertTrue(fruit.getPosition().getX() > 0 && fruit.getPosition().getX() < 6);
            assertTrue(fruit.getPosition().getY() > 0 && fruit.getPosition().getY() < 6);
        }
    }
    @Test
    public void generateNewFruitsLevel2() {
        arena.generateNewFruits(2);
        assertEquals(8, arena.getFruits().size());
        for (Fruit fruit : arena.getFruits()) {
            assertTrue(fruit instanceof CherryFruit);
            assertTrue(fruit.getPosition().getX() > 0 && fruit.getPosition().getX() < 6);
            assertTrue(fruit.getPosition().getY() > 0 && fruit.getPosition().getY() < 6);
        }
    }
    @Test
    public void generateNewFruitsLevel3() {
        arena.generateNewFruits(3);
        assertEquals(10, arena.getFruits().size());
        for (Fruit fruit : arena.getFruits()) {
            assertTrue(fruit instanceof PineappleFruit);
            assertTrue(fruit.getPosition().getX() > 0 && fruit.getPosition().getX() < 6);
            assertTrue(fruit.getPosition().getY() > 0 && fruit.getPosition().getY() < 6);
        }
    }
    @Test
    public void generateNewFruitsLevel4() {
        arena.generateNewFruits(4);
        assertEquals(12, arena.getFruits().size());
        for (Fruit fruit : arena.getFruits()) {
            assertTrue(fruit instanceof BananaFruit);
            assertTrue(fruit.getPosition().getX() > 0 && fruit.getPosition().getX() < 6);
            assertTrue(fruit.getPosition().getY() > 0 && fruit.getPosition().getY() < 6);
        }
    }
    @Test
    public void generateNewFruitsLevel5() {
        arena.generateNewFruits(5);
        assertEquals(14, arena.getFruits().size());
        for (Fruit fruit : arena.getFruits()) {
            assertTrue(fruit instanceof AppleFruit);
            assertTrue(fruit.getPosition().getX() > 0 && fruit.getPosition().getX() < 6);
            assertTrue(fruit.getPosition().getY() > 0 && fruit.getPosition().getY() < 6);
        }
    }
}

