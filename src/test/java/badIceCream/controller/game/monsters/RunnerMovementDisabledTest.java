package badIceCream.controller.game.monsters;

import badIceCream.GUI.GUI;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class RunnerMovementDisabledTest {
    private RunnerMovementDisabled runnerMovementDisabled;
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
        runnerMovementDisabled = new RunnerMovementDisabled();
    }

    @Test
    void testMoveMonsterUpdatesPositionAndChecksIceCream() {
        Position newPosition = new Position(2, 2);
        when(iceCream.getPosition()).thenReturn(newPosition);

        runnerMovementDisabled.moveMonster(monster, newPosition, arena);

        verify(monster, times(1)).setPosition(newPosition);
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, times(1)).getPosition();
        verify(iceCream, times(1)).changeAlive();
    }

    @Test
    void testStepDoesNotMoveMonsterBeforeInterval() throws IOException {
        long currentTime = 200L;
        long lastMovement = 100L;

        runnerMovementDisabled.step(monster, arena, currentTime, lastMovement);

        verify(monster, never()).setLastAction(any());
        verify(monster, never()).setPosition(any());
    }

    @Test
    void testStepMovesMonsterAfterInterval() throws IOException {
        when(iceCream.getPosition()).thenReturn(new Position(1,1));
        when(iceCream.isStrawberryActive()).thenReturn(true);

        long currentTime = 500L;
        long lastMovement = 200L;
        when(monster.getPosition()).thenReturn(new Position(1, 1));
        when(arena.isEmptyMonsters(any())).thenReturn(true);

        runnerMovementDisabled.step(monster, arena, currentTime, lastMovement);

        verify(monster, times(1)).setLastAction(any());
        verify(monster, times(1)).setPosition(any());
        verify(arena, times(1)).getIceCream();
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testMoveMonsterUpdatesPositionAndChecksIceCreamStrawberryOn() {
        Position newPosition = new Position(2, 2);

        when(iceCream.getPosition()).thenReturn(new Position(2,2));
        when(iceCream.isStrawberryActive()).thenReturn(true);

        runnerMovementDisabled.moveMonster(monster, newPosition, arena);

        verify(monster, times(1)).setPosition(newPosition);
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testMoveMonsterLocked() throws IOException {
        Position newPosition = new Position(3, 2);

        when(iceCream.isStrawberryActive()).thenReturn(false);
        when(iceCream.getPosition()).thenReturn(new Position(1,2));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(any(Position.class))).thenReturn(false);

        runnerMovementDisabled.step(monster, arena, 500L, 200L);

        verify(monster, never()).setPosition(newPosition);
        verify(monster, never()).setLastAction(any(GUI.ACTION.class));
    }

    @Test
    void testMoveMonsterUpdatesLeft() throws IOException {
        Position newPosition = new Position(1, 2);

        when(iceCream.getPosition()).thenReturn(new Position(5,5));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(newPosition)).thenReturn(true);

        runnerMovementDisabled.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setPosition(newPosition);
        verify(monster, times(1)).setLastAction(GUI.ACTION.LEFT);
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, times(1)).getPosition();
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testMoveMonsterUpdatesDown() throws IOException {
        Position newPosition = new Position(2, 3);

        when(iceCream.getPosition()).thenReturn(new Position(1,2));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(newPosition)).thenReturn(true);

        runnerMovementDisabled.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setPosition(newPosition);
        verify(monster, times(1)).setLastAction(GUI.ACTION.DOWN);
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, times(1)).getPosition();
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testMoveMonsterUpdatesUp() throws IOException {
        Position newPosition = new Position(2, 1);

        when(iceCream.getPosition()).thenReturn(new Position(1,2));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(newPosition)).thenReturn(true);

        runnerMovementDisabled.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setPosition(newPosition);
        verify(monster, times(1)).setLastAction(GUI.ACTION.UP);
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, times(1)).getPosition();
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testMoveMonsterUpdatesRight() throws IOException {
        Position newPosition = new Position(3, 2);

        when(iceCream.getPosition()).thenReturn(new Position(1,2));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(newPosition)).thenReturn(true);

        runnerMovementDisabled.step(monster, arena, 500L, 200L);

        verify(monster, times(1)).setPosition(newPosition);
        verify(monster, times(1)).setLastAction(GUI.ACTION.RIGHT);
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, times(1)).getPosition();
        verify(iceCream, never()).changeAlive();
    }
}
