package badIceCream.model.game;
import badIceCream.GUI.GUI;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.*;
import badIceCream.model.game.elements.monsters.DefaultMonster;
import badIceCream.model.game.elements.monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PowerIceCreamTest {
    private Arena arena;
    @Mock
    DefaultMonster monster;
    @Mock
    HotFloor hotFloor;
    @Mock
    StoneWall stoneWall;
    @Mock
    private IceCream iceCream;
    @Mock
    private IceWall iceWall1;
    @Mock
    private IceWall iceWall2;
    @Mock
    private IceWall iceWall3;
    @Mock
    private IceWall iceWall4;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        arena = new Arena(10,10);
    }
    @Test
    public void powerIceCreamUpIceWall() {
        when(iceWall1.getPosition()).thenReturn(new Position(0,0));
        when(iceWall2.getPosition()).thenReturn(new Position(0,1));
        when(iceWall3.getPosition()).thenReturn(new Position(0,2));
        when(iceWall4.getPosition()).thenReturn(new Position(0,3));
        when(iceCream.getPosition()).thenReturn(new Position(0,4));
        List<Wall> walls = new ArrayList<>(Arrays.asList(iceWall1, iceWall2, iceWall3, iceWall4));
        arena.setWalls(walls);
        arena.setIceCream(iceCream);
        arena.powerIceCream(GUI.ACTION.UP);
        assertFalse(arena.getWalls().contains(iceWall1));
        assertFalse(arena.getWalls().contains(iceWall2));
        assertFalse(arena.getWalls().contains(iceWall3));
        assertFalse(arena.getWalls().contains(iceWall4));

    }
    @Test
    public void powerIceCreamUpNoIceWallStoneWall() {
        when(stoneWall.getPosition()).thenReturn(new Position(2,2));
        List<Wall> walls = new ArrayList<>(Collections.singletonList(stoneWall));
        arena.setWalls(walls);
        when(iceCream.getPosition()).thenReturn(new Position(2,6));
        arena.setIceCream(iceCream);
        arena.setMonsters(new ArrayList<>());
        arena.setHotFloors(new ArrayList<>());
        arena.powerIceCream(GUI.ACTION.UP);
        assertEquals(4, arena.getWalls().size());
    }
    @Test
    public void powerIceCreamUpNoIceWallHotFloor() {
        when(hotFloor.getPosition()).thenReturn(new Position(2,2));
        List<HotFloor> hotFloors = new ArrayList<>(Collections.singletonList(hotFloor));
        arena.setHotFloors(hotFloors);
        when(iceCream.getPosition()).thenReturn(new Position(2,6));
        arena.setIceCream(iceCream);
        arena.setMonsters(new ArrayList<>());
        arena.setWalls(new ArrayList<>());
        arena.powerIceCream(GUI.ACTION.UP);
        assertEquals(3, arena.getWalls().size());
    }
    @Test
    public void powerIceCreamUpNoIceWallMonster() {
        when(monster.getPosition()).thenReturn(new Position(2,2));
        List<Monster> monsters = new ArrayList<>(Collections.singletonList(monster));
        arena.setMonsters(monsters);
        when(iceCream.getPosition()).thenReturn(new Position(2,6));
        arena.setIceCream(iceCream);
        arena.setWalls(new ArrayList<>());
        arena.setHotFloors(new ArrayList<>());
        arena.powerIceCream(GUI.ACTION.UP);
        assertEquals(3, arena.getWalls().size());
    }
    @Test
    public void powerIceCreamDownIceWall() {
        when(iceWall1.getPosition()).thenReturn(new Position(0,4));
        when(iceWall2.getPosition()).thenReturn(new Position(0,3));
        when(iceWall3.getPosition()).thenReturn(new Position(0,2));
        when(iceWall4.getPosition()).thenReturn(new Position(0,1));
        when(iceCream.getPosition()).thenReturn(new Position(0,0));
        List<Wall> walls = new ArrayList<>(Arrays.asList(iceWall1, iceWall2, iceWall3, iceWall4));
        arena.setWalls(walls);
        arena.setIceCream(iceCream);
        arena.powerIceCream(GUI.ACTION.DOWN);
        assertFalse(arena.getWalls().contains(iceWall1));
        assertFalse(arena.getWalls().contains(iceWall2));
        assertFalse(arena.getWalls().contains(iceWall3));
        assertFalse(arena.getWalls().contains(iceWall4));
    }
    @Test
    public void powerIceCreamDownNoIceWallStoneWall() {
        when(stoneWall.getPosition()).thenReturn(new Position(2,6));
        List<Wall> walls = new ArrayList<>(Collections.singletonList(stoneWall));
        arena.setWalls(walls);
        when(iceCream.getPosition()).thenReturn(new Position(2,2));
        arena.setIceCream(iceCream);
        arena.setMonsters(new ArrayList<>());
        arena.setHotFloors(new ArrayList<>());
        arena.powerIceCream(GUI.ACTION.DOWN);
        assertEquals(4, arena.getWalls().size());
    }
    @Test
    public void powerIceCreamDownNoIceWallHotFloor() {
        when(hotFloor.getPosition()).thenReturn(new Position(2,6));
        List<HotFloor> hotFloors = new ArrayList<>(Collections.singletonList(hotFloor));
        arena.setHotFloors(hotFloors);
        when(iceCream.getPosition()).thenReturn(new Position(2,2));
        arena.setIceCream(iceCream);
        arena.setMonsters(new ArrayList<>());
        arena.setWalls(new ArrayList<>());
        arena.powerIceCream(GUI.ACTION.DOWN);
        assertEquals(3, arena.getWalls().size());
    }
    @Test
    public void powerIceCreamDownNoIceWallMonster() {
        when(monster.getPosition()).thenReturn(new Position(2,6));
        List<Monster> monsters = new ArrayList<>(Collections.singletonList(monster));
        arena.setMonsters(monsters);
        when(iceCream.getPosition()).thenReturn(new Position(2,2));
        arena.setIceCream(iceCream);
        arena.setWalls(new ArrayList<>());
        arena.setHotFloors(new ArrayList<>());
        arena.powerIceCream(GUI.ACTION.DOWN);
        assertEquals(3, arena.getWalls().size());
    }
    @Test
    public void powerIceCreamLeftIceWall() {
        when(iceWall1.getPosition()).thenReturn(new Position(0,0));
        when(iceWall2.getPosition()).thenReturn(new Position(1,0));
        when(iceWall3.getPosition()).thenReturn(new Position(2,0));
        when(iceWall4.getPosition()).thenReturn(new Position(3,0));
        when(iceCream.getPosition()).thenReturn(new Position(4,0));
        List<Wall> walls = new ArrayList<>(Arrays.asList(iceWall1, iceWall2, iceWall3, iceWall4));
        arena.setWalls(walls);
        arena.setIceCream(iceCream);
        arena.powerIceCream(GUI.ACTION.LEFT);
        assertFalse(arena.getWalls().contains(iceWall1));
        assertFalse(arena.getWalls().contains(iceWall2));
        assertFalse(arena.getWalls().contains(iceWall3));
        assertFalse(arena.getWalls().contains(iceWall4));
    }
    @Test
    public void powerIceCreamLeftNoIceWallStoneWall() {
        when(stoneWall.getPosition()).thenReturn(new Position(2,2));
        List<Wall> walls = new ArrayList<>(Collections.singletonList(stoneWall));
        arena.setWalls(walls);
        when(iceCream.getPosition()).thenReturn(new Position(6,2));
        arena.setIceCream(iceCream);
        arena.setMonsters(new ArrayList<>());
        arena.setHotFloors(new ArrayList<>());
        arena.powerIceCream(GUI.ACTION.LEFT);
        assertEquals(4, arena.getWalls().size());
    }
    @Test
    public void powerIceCreamLeftNoIceWallHotFloor() {
        when(hotFloor.getPosition()).thenReturn(new Position(2,2));
        List<HotFloor> hotFloors = new ArrayList<>(Collections.singletonList(hotFloor));
        arena.setHotFloors(hotFloors);
        when(iceCream.getPosition()).thenReturn(new Position(6,2));
        arena.setIceCream(iceCream);
        arena.setMonsters(new ArrayList<>());
        arena.setWalls(new ArrayList<>());
        arena.powerIceCream(GUI.ACTION.LEFT);
        assertEquals(3, arena.getWalls().size());
    }
    @Test
    public void powerIceCreamLeftNoIceWallMonster() {
        when(monster.getPosition()).thenReturn(new Position(2,2));
        List<Monster> monsters = new ArrayList<>(Collections.singletonList(monster));
        arena.setMonsters(monsters);
        when(iceCream.getPosition()).thenReturn(new Position(6,2));
        arena.setIceCream(iceCream);
        arena.setWalls(new ArrayList<>());
        arena.setHotFloors(new ArrayList<>());
        arena.powerIceCream(GUI.ACTION.LEFT);
        assertEquals(3, arena.getWalls().size());
    }
    @Test
    public void powerIceCreamRightIceWall() {
        when(iceWall1.getPosition()).thenReturn(new Position(4,0));
        when(iceWall2.getPosition()).thenReturn(new Position(3,0));
        when(iceWall3.getPosition()).thenReturn(new Position(2,0));
        when(iceWall4.getPosition()).thenReturn(new Position(1,0));
        when(iceCream.getPosition()).thenReturn(new Position(0,0));
        List<Wall> walls = new ArrayList<>(Arrays.asList(iceWall1, iceWall2, iceWall3, iceWall4));
        arena.setWalls(walls);
        arena.setIceCream(iceCream);
        arena.powerIceCream(GUI.ACTION.RIGHT);
        assertFalse(arena.getWalls().contains(iceWall1));
        assertFalse(arena.getWalls().contains(iceWall2));
        assertFalse(arena.getWalls().contains(iceWall3));
        assertFalse(arena.getWalls().contains(iceWall4));
    }
    @Test
    public void powerIceCreamRightNoIceWallStoneWall() {
        when(stoneWall.getPosition()).thenReturn(new Position(6,2));
        List<Wall> walls = new ArrayList<>(Collections.singletonList(stoneWall));
        arena.setWalls(walls);
        when(iceCream.getPosition()).thenReturn(new Position(2,2));
        arena.setIceCream(iceCream);
        arena.setMonsters(new ArrayList<>());
        arena.setHotFloors(new ArrayList<>());
        arena.powerIceCream(GUI.ACTION.RIGHT);
        assertEquals(4, arena.getWalls().size());
    }
    @Test
    public void powerIceCreamRightNoIceWallHotFloor() {
        when(hotFloor.getPosition()).thenReturn(new Position(6,2));
        List<HotFloor> hotFloors = new ArrayList<>(Collections.singletonList(hotFloor));
        arena.setHotFloors(hotFloors);
        when(iceCream.getPosition()).thenReturn(new Position(2,2));
        arena.setIceCream(iceCream);
        arena.setMonsters(new ArrayList<>());
        arena.setWalls(new ArrayList<>());
        arena.powerIceCream(GUI.ACTION.RIGHT);
        assertEquals(3, arena.getWalls().size());
    }
    @Test
    public void powerIceCreamRightNoIceWallMonster() {
        when(monster.getPosition()).thenReturn(new Position(6,2));
        List<Monster> monsters = new ArrayList<>(Collections.singletonList(monster));
        arena.setMonsters(monsters);
        when(iceCream.getPosition()).thenReturn(new Position(2,2));
        arena.setIceCream(iceCream);
        arena.setWalls(new ArrayList<>());
        arena.setHotFloors(new ArrayList<>());
        arena.powerIceCream(GUI.ACTION.RIGHT);
        assertEquals(3, arena.getWalls().size());
    }
}
