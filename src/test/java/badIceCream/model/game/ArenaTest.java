package badIceCream.model.game;

import badIceCream.GUI.GUI;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.*;

import badIceCream.model.game.elements.fruits.*;
import badIceCream.model.game.elements.monsters.*;
import net.jqwik.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ArenaTest {
    @Nested
    public class GeneralArenaTesting {
        private Arena arena;
        @Mock
        private StoneWall stoneWall;
        @Mock
        private IceWall iceWall;
        @Mock
        private BananaFruit bananaFruit;
        @Mock
        private AppleFruit appleFruit;
        @Mock
        private CherryFruit cherryFruit;
        @Mock
        private PineappleFruit pineappleFruit;
        @Mock
        private StrawberryFruit strawberryFruit;
        @Mock
        private DefaultMonster defaultMonster;
        @Mock
        private WallBreakerMonster wallBreakerMonster;
        @Mock
        private JumperMonster jumperMonster;
        @Mock
        private RunnerMonster runnerMonster;
        @Mock
        private HotFloor hotFloor;
        @Mock
        private IceCream iceCream;

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.openMocks(this);
            when(stoneWall.getPosition()).thenReturn(new Position(0,0));
            when(iceWall.getPosition()).thenReturn(new Position(0,1));
            when(bananaFruit.getPosition()).thenReturn(new Position(0,2));
            when(appleFruit.getPosition()).thenReturn(new Position(0,3));
            when(cherryFruit.getPosition()).thenReturn(new Position(0,4));
            when(pineappleFruit.getPosition()).thenReturn(new Position(0,5));
            when(strawberryFruit.getPosition()).thenReturn(new Position(0,6));
            when(defaultMonster.getPosition()).thenReturn(new Position(0,7));
            when(wallBreakerMonster.getPosition()).thenReturn(new Position(0,8));
            when(jumperMonster.getPosition()).thenReturn(new Position(0,9));
            when(runnerMonster.getPosition()).thenReturn(new Position(1,0));
            when(hotFloor.getPosition()).thenReturn(new Position(1,1));
            when(iceCream.getPosition()).thenReturn(new Position(1,2));
            List<Wall> walls = new ArrayList<>(Arrays.asList(stoneWall, iceWall));
            List<Monster> monsters = new ArrayList<>(Arrays.asList(defaultMonster, wallBreakerMonster, jumperMonster, runnerMonster));
            List<Fruit> fruits = new ArrayList<>(Arrays.asList(bananaFruit, appleFruit, cherryFruit, pineappleFruit, strawberryFruit));
            List<HotFloor> hotFloors = new ArrayList<>(List.of(hotFloor));
            arena = new Arena(10,10);
            arena.setWalls(walls);
            arena.setMonsters(monsters);
            arena.setFruits(fruits);
            arena.setHotFloors(hotFloors);
        }
        @Test
        public void isEmpty() {
            //tests if isEmpty() returns true for any position that doens't have a wall
            assertTrue(arena.isEmpty(new Position(0,2)));
            assertTrue(arena.isEmpty(new Position(0,3)));
            assertTrue(arena.isEmpty(new Position(0,4)));
            assertTrue(arena.isEmpty(new Position(0,5)));
            assertTrue(arena.isEmpty(new Position(0,6)));
            assertTrue(arena.isEmpty(new Position(0,7)));
            assertTrue(arena.isEmpty(new Position(0,8)));
            assertTrue(arena.isEmpty(new Position(0,9)));
            assertTrue(arena.isEmpty(new Position(1,0)));
            assertTrue(arena.isEmpty(new Position(1,1)));
            assertTrue(arena.isEmpty(new Position(1,2)));
            assertTrue(arena.isEmpty(new Position(1,3)));
        }
        @Test
        public void isNotEmpty() {
            //tests if isEmpty() returns false for every position that has a wall
            assertFalse(arena.isEmpty(new Position(0,0)));
            assertFalse(arena.isEmpty(new Position(0,1)));
        }
        @Test
        public void isEmptyMonsters() {
            //tests if isEmptyMonsters() returns true for every position that doesn't have a wall or a monster
            assertTrue(arena.isEmptyMonsters(new Position(0,2)));
            assertTrue(arena.isEmptyMonsters(new Position(0,3)));
            assertTrue(arena.isEmptyMonsters(new Position(0,4)));
            assertTrue(arena.isEmptyMonsters(new Position(0,5)));
            assertTrue(arena.isEmptyMonsters(new Position(0,6)));
            assertTrue(arena.isEmptyMonsters(new Position(1,1)));
            assertTrue(arena.isEmptyMonsters(new Position(1,2)));
            assertTrue(arena.isEmptyMonsters(new Position(1,3)));
        }
        @Test
        public void isNotEmptyMonsters() {
            //tests if isEmptyMonsters() returns false for every position that has a wall or a monster
            assertFalse(arena.isEmptyMonsters(new Position(0,0)));
            assertFalse(arena.isEmptyMonsters(new Position(0,1)));
            assertFalse(arena.isEmptyMonsters(new Position(0,7)));
            assertFalse(arena.isEmptyMonsters(new Position(0,8)));
            assertFalse(arena.isEmptyMonsters(new Position(0,9)));
            assertFalse(arena.isEmptyMonsters(new Position(1,0)));
        }
        @Test
        public void isEmptyNoStoneWall() {
            //tests if isEmptyNoStoneWall() returns true for every position that doesn't have a stoneWall or a monster
            assertTrue(arena.isEmptyNoStoneWall(new Position(0,1)));
            assertTrue(arena.isEmptyNoStoneWall(new Position(0,2)));
            assertTrue(arena.isEmptyNoStoneWall(new Position(0,3)));
            assertTrue(arena.isEmptyNoStoneWall(new Position(0,4)));
            assertTrue(arena.isEmptyNoStoneWall(new Position(0,5)));
            assertTrue(arena.isEmptyNoStoneWall(new Position(0,6)));
            assertTrue(arena.isEmptyNoStoneWall(new Position(1,1)));
            assertTrue(arena.isEmptyNoStoneWall(new Position(1,2)));
            assertTrue(arena.isEmptyNoStoneWall(new Position(1,3)));
        }
        @Test
        public void isNotEmptyNoStoneWall() {
            //tests if isEmptyNoStoneWall() returns false for every position that has a stoneWall or a monster
            assertFalse(arena.isEmptyNoStoneWall(new Position(0,0)));
            assertFalse(arena.isEmptyNoStoneWall(new Position(0,7)));
            assertFalse(arena.isEmptyNoStoneWall(new Position(0,8)));
            assertFalse(arena.isEmptyNoStoneWall(new Position(0,9)));
            assertFalse(arena.isEmptyNoStoneWall(new Position(1,0)));
        }
        @Test
        public void isEmptySpawnFruit() {
            //tests if isEmptySpawnFruit() returns true for every position that doesn't have a stoneWall or a fruit
            assertTrue(arena.isEmptySpawnFruit(new Position(0,1)));
            assertTrue(arena.isEmptySpawnFruit(new Position(0,7)));
            assertTrue(arena.isEmptySpawnFruit(new Position(0,8)));
            assertTrue(arena.isEmptySpawnFruit(new Position(0,9)));
            assertTrue(arena.isEmptySpawnFruit(new Position(1,0)));
            assertTrue(arena.isEmptySpawnFruit(new Position(1,1)));
            assertTrue(arena.isEmptySpawnFruit(new Position(1,2)));
            assertTrue(arena.isEmptySpawnFruit(new Position(1,3)));
        }
        @Test
        public void isNotEmptySpawnFruit() {
            //tests if isEmptySpawnFruit() returns false for every position that has a stoneWall or a fruit
            assertFalse(arena.isEmptySpawnFruit(new Position(0,0)));
            assertFalse(arena.isEmptySpawnFruit(new Position(0,2)));
            assertFalse(arena.isEmptySpawnFruit(new Position(0,3)));
            assertFalse(arena.isEmptySpawnFruit(new Position(0,4)));
            assertFalse(arena.isEmptySpawnFruit(new Position(0,5)));
            assertFalse(arena.isEmptySpawnFruit(new Position(0,6)));

        }
        @Test
        public void isHotFloor() {
            //tests if isHotFloor() returns true for every position that has a hotFloor;
            assertTrue(arena.isHotFloor(new Position(1,1)));
        }
        @Test
        public void isNotHotFloor() {
            //tests if isHotFloor() returns false for every position that doens't have a hotFloor;
            assertFalse(arena.isHotFloor(new Position(0,0)));
            assertFalse(arena.isHotFloor(new Position(0,1)));
            assertFalse(arena.isHotFloor(new Position(0,2)));
            assertFalse(arena.isHotFloor(new Position(0,3)));
            assertFalse(arena.isHotFloor(new Position(0,4)));
            assertFalse(arena.isHotFloor(new Position(0,5)));
            assertFalse(arena.isHotFloor(new Position(0,6)));
            assertFalse(arena.isHotFloor(new Position(0,7)));
            assertFalse(arena.isHotFloor(new Position(0,8)));
            assertFalse(arena.isHotFloor(new Position(0,9)));
            assertFalse(arena.isHotFloor(new Position(1,0)));
            assertFalse(arena.isHotFloor(new Position(1,2)));
            assertFalse(arena.isHotFloor(new Position(1,3)));
        }
        @Test
        public void isIceWallDestroyed() {
            //tests if is iceIceWallDestroyed() eliminates an iceWall from walls, if there is one in the given position
            int expected = arena.getWalls().size();
            arena.iceWallDestroyed(new Position(0, 1));
            assertEquals(expected - 1,arena.getWalls().size());
        }
        @Test
        public void isIceWallNotDestroyed() {
            //tests if is iceIceWallDestroyed() doesn't eliminate an iceWall from walls, if there isn't one in the given position
            int expected = arena.getWalls().size();
            arena.iceWallDestroyed(new Position(0, 2));
            arena.iceWallDestroyed(new Position(0, 3));
            arena.iceWallDestroyed(new Position(0, 4));
            arena.iceWallDestroyed(new Position(0, 5));
            arena.iceWallDestroyed(new Position(0, 6));
            arena.iceWallDestroyed(new Position(0, 7));
            arena.iceWallDestroyed(new Position(0, 8));
            arena.iceWallDestroyed(new Position(0, 9));
            arena.iceWallDestroyed(new Position(1, 0));
            arena.iceWallDestroyed(new Position(1, 1));
            arena.iceWallDestroyed(new Position(1, 2));
            arena.iceWallDestroyed(new Position(1,3));
            assertEquals(expected,arena.getWalls().size());
        }
        @Test
        public void isIceWall() {
            //tests if isIceWall() returns true if there is an iceWall in the given position
            assertTrue(arena.isIceWall(new Position(0,1)));
        }
        @Test
        public void isNotIceWall() {
            //tests if isIceWall() returns false if there isn't an iceWall in the given position
            assertFalse(arena.isIceWall(new Position(0,0)));
            assertFalse(arena.isIceWall(new Position(0,2)));
            assertFalse(arena.isIceWall(new Position(0,3)));
            assertFalse(arena.isIceWall(new Position(0,4)));
            assertFalse(arena.isIceWall(new Position(0,5)));
            assertFalse(arena.isIceWall(new Position(0,6)));
            assertFalse(arena.isIceWall(new Position(0,7)));
            assertFalse(arena.isIceWall(new Position(0,8)));
            assertFalse(arena.isIceWall(new Position(0,9)));
            assertFalse(arena.isIceWall(new Position(1,0)));
            assertFalse(arena.isIceWall(new Position(1,1)));
            assertFalse(arena.isIceWall(new Position(1,2)));
            assertFalse(arena.isIceWall(new Position(1,3)));
        }
        @Test
        public void hasMonster() {
            //tests if hasMonster() returns the monster in the given position if there is a monster there
            assertEquals(defaultMonster, arena.hasMonster(new Position(0,7)));
            assertEquals(wallBreakerMonster, arena.hasMonster(new Position(0,8)));
            assertEquals(jumperMonster, arena.hasMonster(new Position(0,9)));
            assertEquals(runnerMonster, arena.hasMonster(new Position(1,0)));
        }
        @Test
        public void hasNotMonster() {
            //tests if hasMonster() returns null if there isn't a monster in the given position
            assertNull(arena.hasMonster(new Position(0, 0)));
            assertNull(arena.hasMonster(new Position(0, 1)));
            assertNull(arena.hasMonster(new Position(0, 2)));
            assertNull(arena.hasMonster(new Position(0, 3)));
            assertNull(arena.hasMonster(new Position(0, 4)));
            assertNull(arena.hasMonster(new Position(0, 5)));
            assertNull(arena.hasMonster(new Position(0, 6)));
            assertNull(arena.hasMonster(new Position(1, 1)));
            assertNull(arena.hasMonster(new Position(1, 2)));
            assertNull(arena.hasMonster(new Position(1, 3)));
        }
        @Test
        public void isFruit() {
            //tests if isFruit() invokes the method getType() for each fruit that is in the given position
            arena.isFruit(new Position(0,2));
            verify(bananaFruit, times(1)).getType();
            arena.isFruit(new Position(0,3));
            verify(appleFruit, times(1)).getType();
            arena.isFruit(new Position(0,4));
            verify(cherryFruit, times(1)).getType();
            arena.isFruit(new Position(0,5));
            verify(pineappleFruit, times(1)).getType();
            arena.isFruit(new Position(0,6));
            verify(strawberryFruit, times(1)).getType();
        }
        @Test
        public void isNotFruit() {
            //tests if isFruit() returns -1 for each position that doesn't have a fruit
            assertEquals(-1,arena.isFruit(new Position(0,0)));
            assertEquals(-1,arena.isFruit(new Position(0,1)));
            assertEquals(-1,arena.isFruit(new Position(0,7)));
            assertEquals(-1,arena.isFruit(new Position(0,8)));
            assertEquals(-1,arena.isFruit(new Position(0,9)));
            assertEquals(-1,arena.isFruit(new Position(1,0)));
            assertEquals(-1,arena.isFruit(new Position(1,1)));
            assertEquals(-1,arena.isFruit(new Position(1,2)));
            assertEquals(-1,arena.isFruit(new Position(1,3)));
        }
        @Test
        public void eatFruit() {
            //tests if eatFruit() invokes the method getType() for each fruit that is in the given position and removes that fruit from fruits
            int expected = arena.getFruits().size();
            arena.eatFruit(new Position(0,2));
            System.out.println(arena.isFruit(new Position(0,2)));
            expected--;
            assertFalse(arena.getFruits().contains(bananaFruit));
            assertEquals(expected, arena.getFruits().size());
            verify(bananaFruit, times(1)).getType();
            arena.eatFruit(new Position(0,3));
            expected--;
            assertFalse(arena.getFruits().contains(appleFruit));
            assertEquals(expected, arena.getFruits().size());
            verify(appleFruit, times(1)).getType();
            arena.eatFruit(new Position(0,4));
            expected--;
            assertFalse(arena.getFruits().contains(cherryFruit));
            assertEquals(expected, arena.getFruits().size());
            verify(cherryFruit, times(1)).getType();
            arena.eatFruit(new Position(0,5));
            expected--;
            assertFalse(arena.getFruits().contains(pineappleFruit));
            assertEquals(expected, arena.getFruits().size());
            verify(pineappleFruit, times(1)).getType();
            arena.eatFruit(new Position(0,6));
            expected--;
            assertFalse(arena.getFruits().contains(strawberryFruit));
            assertEquals(expected, arena.getFruits().size());
            verify(strawberryFruit, times(1)).getType();
        }
        @Test
        public void eatNotFruit() {
            //tests if eatFruit() returns -1 for each position that doesn't have a fruit and if not a single fruit is eliminated from fruits
            int expected = arena.getFruits().size();
            assertEquals(-1,arena.isFruit(new Position(0,0)));
            assertEquals(-1,arena.isFruit(new Position(0,1)));
            assertEquals(-1,arena.isFruit(new Position(0,7)));
            assertEquals(-1,arena.isFruit(new Position(0,8)));
            assertEquals(-1,arena.isFruit(new Position(0,9)));
            assertEquals(-1,arena.isFruit(new Position(1,0)));
            assertEquals(-1,arena.isFruit(new Position(1,1)));
            assertEquals(-1,arena.isFruit(new Position(1,2)));
            assertEquals(-1,arena.isFruit(new Position(1,3)));
            assertEquals(expected, arena.getFruits().size());
        }
        @Test
        public void powerIceCreamUpIceWall() {
            when(iceCream.getPosition()).thenReturn(new Position(0,2));
            arena.setIceCream(iceCream);
            arena.powerIceCream(GUI.ACTION.UP);
            assertFalse(arena.getWalls().contains(iceWall));
        }
        @Test
        public void powerIceCreamUpNoIceWall() {
            StoneWall stoneWall1 = mock(StoneWall.class);
            when(stoneWall1.getPosition()).thenReturn(new Position(2,2));
            List<Wall> walls = new ArrayList<>(Arrays.asList(stoneWall1));
            arena.setWalls(walls);
            when(iceCream.getPosition()).thenReturn(new Position(2,6));
            arena.setIceCream(iceCream);
            arena.powerIceCream(GUI.ACTION.UP);
            assertEquals(4, arena.getWalls().size());
        }
        @Test
        public void powerIceCreamDownIceWall() {
            when(iceCream.getPosition()).thenReturn(new Position(0,0));
            arena.setIceCream(iceCream);
            arena.powerIceCream(GUI.ACTION.DOWN);
            assertFalse(arena.getWalls().contains(iceWall));
        }
        @Test
        public void powerIceCreaDownNoIceWall() {
            StoneWall stoneWall1 = mock(StoneWall.class);
            when(stoneWall1.getPosition()).thenReturn(new Position(2,6));
            List<Wall> walls = new ArrayList<>(Arrays.asList(stoneWall1));
            arena.setWalls(walls);
            when(iceCream.getPosition()).thenReturn(new Position(2,2));
            arena.setIceCream(iceCream);
            arena.powerIceCream(GUI.ACTION.DOWN);
            assertEquals(4, arena.getWalls().size());
        }
        @Test
        public void powerIceCreamLeftIceWall() {
            when(iceCream.getPosition()).thenReturn(new Position(1,1));
            arena.setIceCream(iceCream);
            arena.powerIceCream(GUI.ACTION.LEFT);
            assertFalse(arena.getWalls().contains(iceWall));
        }
        @Test
        public void powerIceCreaLeftNoIceWall() {
            StoneWall stoneWall1 = mock(StoneWall.class);
            when(stoneWall1.getPosition()).thenReturn(new Position(2,2));
            List<Wall> walls = new ArrayList<>(Arrays.asList(stoneWall1));
            arena.setWalls(walls);
            when(iceCream.getPosition()).thenReturn(new Position(6,2));
            arena.setIceCream(iceCream);
            arena.powerIceCream(GUI.ACTION.LEFT);
            assertEquals(4, arena.getWalls().size());
        }
        @Test
        public void powerIceCreamRightIceWall() {
            when(iceCream.getPosition()).thenReturn(new Position(-1,1));
            arena.setIceCream(iceCream);
            arena.powerIceCream(GUI.ACTION.RIGHT);
            assertFalse(arena.getWalls().contains(iceWall));
        }
        @Test
        public void powerIceCreaRightNoIceWall() {
            StoneWall stoneWall1 = mock(StoneWall.class);
            when(stoneWall1.getPosition()).thenReturn(new Position(6,2));
            List<Wall> walls = new ArrayList<>(Arrays.asList(stoneWall1));
            arena.setWalls(walls);
            when(iceCream.getPosition()).thenReturn(new Position(2,2));
            arena.setIceCream(iceCream);
            arena.powerIceCream(GUI.ACTION.RIGHT);
            assertEquals(4, arena.getWalls().size());
        }
    }

    @Nested
    public class GenerateNewFruits {
        private Arena arena;
        private List<Wall> walls;
        private List<Fruit> fruits;
        @Mock
        private StoneWall stoneWall1, stoneWall2, stoneWall3, stoneWall4,
                stoneWall5, stoneWall6, stoneWall7, stoneWall8, stoneWall9,
                stoneWall10, stoneWall11, stoneWall12, stoneWall13, stoneWall14,
                stoneWall15,  stoneWall16, stoneWall17, stoneWall18, stoneWall19;
        @BeforeEach
        public void setUp() {
            MockitoAnnotations.openMocks(this);
            arena = new Arena(6,6);
            when(stoneWall1.getPosition()).thenReturn(new Position(0,0));
            when(stoneWall2.getPosition()).thenReturn(new Position(1,0));
            when(stoneWall3.getPosition()).thenReturn(new Position(2,0));
            when(stoneWall4.getPosition()).thenReturn(new Position(3,0));
            when(stoneWall5.getPosition()).thenReturn(new Position(4,0));
            when(stoneWall5.getPosition()).thenReturn(new Position(5,0));
            when(stoneWall6.getPosition()).thenReturn(new Position(0,1));
            when(stoneWall7.getPosition()).thenReturn(new Position(5,1));
            when(stoneWall8.getPosition()).thenReturn(new Position(0,2));
            when(stoneWall9.getPosition()).thenReturn(new Position(5,2));
            when(stoneWall10.getPosition()).thenReturn(new Position(0,3));
            when(stoneWall11.getPosition()).thenReturn(new Position(5,3));
            when(stoneWall12.getPosition()).thenReturn(new Position(0,4));
            when(stoneWall13.getPosition()).thenReturn(new Position(5,4));
            when(stoneWall14.getPosition()).thenReturn(new Position(0,5));
            when(stoneWall15.getPosition()).thenReturn(new Position(1,5));
            when(stoneWall16.getPosition()).thenReturn(new Position(2,5));
            when(stoneWall17.getPosition()).thenReturn(new Position(3,5));
            when(stoneWall18.getPosition()).thenReturn(new Position(4,5));
            when(stoneWall19.getPosition()).thenReturn(new Position(5,5));
            walls = new ArrayList<>(Arrays.asList(stoneWall1,stoneWall2,stoneWall3,stoneWall4,stoneWall5,
            stoneWall6,stoneWall7, stoneWall8, stoneWall9, stoneWall10, stoneWall11, stoneWall12,
                    stoneWall13, stoneWall14, stoneWall15, stoneWall16, stoneWall17, stoneWall18, stoneWall19));
            arena.setWalls(walls);
            fruits = new ArrayList<>();
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
}
