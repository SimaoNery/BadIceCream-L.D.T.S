package badIceCream.controller.game.monsters;

import badIceCream.GUI.GUI;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.IceWall;
import badIceCream.model.game.elements.monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

public class JumperMovementTest {
    private JumperMovement jumperMovement;
    @Mock
    private Arena arena;
    @Mock
    private Monster monster;
    @Mock
    private IceCream iceCream;
    @Mock
    private Position position;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(arena.getIceCream()).thenReturn(iceCream);
        when(iceCream.isStrawberryActive()).thenReturn(false);
        when(iceCream.getPosition()).thenReturn(position);
        jumperMovement = new JumperMovement();
    }

    @Test
    void testMoveMonsterUpdatesPositionAndChecksIceCream() {
        Position newPosition = new Position(2, 2);
        when(iceCream.getPosition()).thenReturn(newPosition);

        jumperMovement.moveMonster(monster, newPosition, arena);

        verify(monster, times(1)).setPosition(newPosition);
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, times(1)).getPosition();
        verify(iceCream, times(1)).changeAlive();
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
        when(iceCream.isStrawberryActive()).thenReturn(false);
        when(arena.isEmptyNoStoneWall(any(Position.class))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(5,5));

        jumperMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(5)).getPosition();
        verify(monster, times(1)).setLastAction(any(GUI.ACTION.class));
        verify(arena, times(2)).getIceCream();
        verify(iceCream, never()).changeAlive();
    }


    @Test
    void testMoveMonsterUpdatesPositionAndChecksIceCreamStrawberryOn() {
        Position newPosition = new Position(2, 2);
        when(iceCream.getPosition()).thenReturn(new Position(2,2));
        when(iceCream.isStrawberryActive()).thenReturn(true);

        jumperMovement.moveMonster(monster, newPosition, arena);

        verify(monster, times(1)).setPosition(newPosition);
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testJumperWall() {
        when(iceCream.getPosition()).thenReturn(new Position(2,2));
        when(iceCream.isStrawberryActive()).thenReturn(true);

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
        when(iceCream.getPosition()).thenReturn(new Position(5,5));

        when(arena.isEmptyNoStoneWall(new Position(1,2))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        jumperMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setLastAction(GUI.ACTION.LEFT);
        verify(monster, times(1)).setPosition(new Position(1,2));
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testStepMovesMonsterRight() throws IOException {
        when(iceCream.getPosition()).thenReturn(new Position(5,5));

        when(arena.isEmptyNoStoneWall(new Position(3,2))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        jumperMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setLastAction(GUI.ACTION.RIGHT);
        verify(monster, times(1)).setPosition(new Position(3,2));
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testStepMovesMonsterUp() throws IOException {
        when(iceCream.getPosition()).thenReturn(new Position(5,5));
        when(iceCream.isStrawberryActive()).thenReturn(false);

        when(arena.isEmptyNoStoneWall(new Position(2,1))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        jumperMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setLastAction(GUI.ACTION.UP);
        verify(monster, times(1)).setPosition(new Position(2,1));
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testStepMovesMonsterDown() throws IOException {
        when(iceCream.getPosition()).thenReturn(new Position(5,5));

        when(arena.isEmptyNoStoneWall(new Position(2,3))).thenReturn(true);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        jumperMovement.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setLastAction(GUI.ACTION.DOWN);
        verify(monster, times(1)).setPosition(new Position(2,3));
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, never()).changeAlive();
    }


}
