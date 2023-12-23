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

import static org.mockito.Mockito.*;

public class DefaultMovementTest {
    private DefaultMovement defaultMovement;
    @Mock
    private Arena arena;
    @Mock
    private Monster monster;
    @Mock
    private IceCream iceCream;
    @Mock
    private Position pos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        defaultMovement = new DefaultMovement();
        when(arena.getIceCream()).thenReturn(iceCream);
        when(iceCream.getPosition()).thenReturn(pos);
    }

    @Test
    void testMoveMonsterUpdatesPositionAndChecksIceCream() {
        Position newPosition = new Position(2, 2);
        when(iceCream.getAlive()).thenReturn(false);
        when(iceCream.getPosition()).thenReturn(newPosition);

        defaultMovement.moveMonster(monster, newPosition, arena);

        verify(monster, times(1)).setPosition(newPosition);
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, times(1)).getPosition();
        verify(iceCream, times(1)).changeAlive();
    }

    @Test
    void testStepDoesNotMoveMonsterBeforeInterval() throws IOException {
        long currentTime = 324L;
        long lastMovement = 100L;

        defaultMovement.step(monster, arena, currentTime, lastMovement);

        verify(monster, never()).setLastAction(any());
        verify(monster, never()).setPosition(any());
    }

    @Test
    void testStepMovesMonsterAfterInterval() throws IOException {
        when(iceCream.getPosition()).thenReturn(new Position(1,1));
        when(iceCream.isStrawberryActive()).thenReturn(true);

        long currentTime = 325L;
        long lastMovement = 100L;
        when(monster.getPosition()).thenReturn(new Position(1, 1));
        when(arena.isEmptyMonsters(any())).thenReturn(true);

        defaultMovement.step(monster, arena, currentTime, lastMovement);

        verify(monster, times(1)).setLastAction(any());
        verify(monster, times(1)).setPosition(any());
        verify(arena, times(1)).getIceCream();
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testMoveMonsterUpdatesPositionAndChecksIceCreamStrawberryOn() {
        Position newPosition = new Position(2, 2);

        when(iceCream.getPosition()).thenReturn(newPosition);
        when(iceCream.isStrawberryActive()).thenReturn(true);

        defaultMovement.moveMonster(monster, newPosition, arena);

        verify(monster, times(1)).setPosition(newPosition);
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, never()).changeAlive();
    }

    @Test
    void testMoveMonsterLocked() throws IOException {
        Position newPosition = new Position(3, 2);
        when(arena.getIceCream()).thenReturn(mock(IceCream.class));
        when(iceCream.getPosition()).thenReturn(newPosition);
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(any(Position.class))).thenReturn(false);

        defaultMovement.step(monster, arena, 325L, 100L);

        verify(monster, never()).setPosition(newPosition);
        verify(monster, never()).setLastAction(any(GUI.ACTION.class));
    }

    @Test
    void testMoveMonsterUpdatesLeft() throws IOException {
        Position newPosition = new Position(1, 2);
        when(iceCream.getPosition()).thenReturn(new Position(5,5));
        when(monster.getPosition()).thenReturn(new Position(2,2));

        when(arena.isEmptyMonsters(newPosition)).thenReturn(true);

        defaultMovement.step(monster, arena, 325L, 100L);

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

        defaultMovement.step(monster, arena, 325L, 100L);

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

        defaultMovement.step(monster, arena, 325L, 100L);

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

        defaultMovement.step(monster, arena, 325L, 100L);

        verify(monster, times(1)).setPosition(newPosition);
        verify(monster, times(1)).setLastAction(GUI.ACTION.RIGHT);
        verify(iceCream, times(1)).isStrawberryActive();
        verify(iceCream, times(1)).getPosition();
        verify(iceCream, never()).changeAlive();
    }


}
