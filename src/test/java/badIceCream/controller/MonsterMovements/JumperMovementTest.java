package badIceCream.controller.MonsterMovements;

import badIceCream.GUI.GUI;
import badIceCream.controller.game.monsters.JumperMovement;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.IceWall;
import badIceCream.model.game.elements.monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

public class JumperMovementTest {
    private JumperMovement jumperMovement;
    private Arena arena;
    private Monster monster;

    @BeforeEach
    void setUp() {
        jumperMovement = new JumperMovement();
        arena = mock(Arena.class);
        monster = mock(Monster.class);
    }

    @Test
    void testMoveMonsterUpdatesPositionAndChecksIceCream() {
        Position newPosition = new Position(2, 2);
        when(arena.getIceCream()).thenReturn(mock(IceCream.class));
        when(arena.getIceCream().isStrawberryActive()).thenReturn(false);
        when(arena.getIceCream().getPosition()).thenReturn(newPosition);

        jumperMovement.moveMonster(monster, newPosition, arena);

        verify(monster, times(1)).setPosition(newPosition);
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), times(1)).getPosition();
        verify(arena.getIceCream(), times(1)).changeAlive();
    }

    @Test
    void testStepDoesNotMoveMonsterBeforeInterval() throws IOException {
        long currentTime = 200L;
        long lastMovement = 100L;

        jumperMovement.step(monster, arena, currentTime, lastMovement);

        verify(monster, never()).setLastAction(any());
        verify(monster, never()).setPosition(any());
    }

    @Test
    void testStepMovesMonsterAfterInterval() throws IOException {
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(2,2));
        when(mockedIceCream.isStrawberryActive()).thenReturn(true);
        when(arena.getIceCream()).thenReturn(mockedIceCream);
        when(arena.isEmptyNoStoneWall(any(Position.class))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(5,5));

        jumperMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(5)).getPosition();
        verify(monster, times(1)).setLastAction(any(GUI.ACTION.class));
        verify(arena, times(1)).getIceCream();
        verify(arena.getIceCream(), never()).changeAlive();
    }


    @Test
    void testMoveMonsterUpdatesPositionAndChecksIceCreamStrawberryOn() {
        Position newPosition = new Position(2, 2);
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(2,2));
        when(mockedIceCream.isStrawberryActive()).thenReturn(true);
        when(arena.getIceCream()).thenReturn(mockedIceCream);

        jumperMovement.moveMonster(monster, newPosition, arena);

        verify(monster, times(1)).setPosition(newPosition);
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), never()).changeAlive();
    }

    @Test
    void testJumperWall() {
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(2,2));
        when(mockedIceCream.isStrawberryActive()).thenReturn(true);
        when(arena.getIceCream()).thenReturn(mockedIceCream);
        when(arena.getWalls()).thenReturn(List.of(
                new IceWall(4,5),
                new IceWall(6,5),
                new IceWall(5,4),
                new IceWall(5, 6)
                ));

        jumperMovement.moveMonster(monster, new Position(4,5), arena);

        verify(monster, times(1)).setPosition(new Position(4,5));
    }

    @Test
    void testJumperWallStoneWall() throws IOException {
        when(arena.isEmptyNoStoneWall(any(Position.class))).thenReturn(false);
        when(monster.getPosition()).thenReturn(new Position(5,5));

        jumperMovement.step(monster, arena, 500L, 200L);

        verify(monster, never()).setPosition(any());
    }


    @Test
    void testStepMovesMonsterLeft() throws IOException {
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(5,5));

        when(arena.getIceCream()).thenReturn(mockedIceCream);
        when(arena.isEmptyNoStoneWall(new Position(1,2))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        jumperMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setLastAction(GUI.ACTION.LEFT);
        verify(monster, times(1)).setPosition(new Position(1,2));
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), never()).changeAlive();
    }

    @Test
    void testStepMovesMonsterRight() throws IOException {
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(5,5));

        when(arena.getIceCream()).thenReturn(mockedIceCream);
        when(arena.isEmptyNoStoneWall(new Position(3,2))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        jumperMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setLastAction(GUI.ACTION.RIGHT);
        verify(monster, times(1)).setPosition(new Position(3,2));
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), never()).changeAlive();
    }

    @Test
    void testStepMovesMonsterUp() throws IOException {
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(5,5));
        when(mockedIceCream.isStrawberryActive()).thenReturn(false);

        when(arena.getIceCream()).thenReturn(mockedIceCream);
        when(arena.isEmptyNoStoneWall(new Position(2,1))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        jumperMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setLastAction(GUI.ACTION.UP);
        verify(monster, times(1)).setPosition(new Position(2,1));
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), never()).changeAlive();
    }

    @Test
    void testStepMovesMonsterDown() throws IOException {
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(5,5));

        when(arena.getIceCream()).thenReturn(mockedIceCream);
        when(arena.isEmptyNoStoneWall(new Position(2,3))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        jumperMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setLastAction(GUI.ACTION.DOWN);
        verify(monster, times(1)).setPosition(new Position(2,3));
        verify(arena.getIceCream(), times(1)).isStrawberryActive();
        verify(arena.getIceCream(), never()).changeAlive();
    }


}
