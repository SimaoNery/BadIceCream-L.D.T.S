package badIceCream.controller;

import badIceCream.Game;
import badIceCream.controller.game.ArenaController;
import badIceCream.controller.game.MonsterController;
import badIceCream.controller.game.StepMonsters;
import badIceCream.model.Position;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MonsterControllerTest {

    private Arena arena;
    private Game game;
    private StepMonsters step;
    private Monster monster;
    private MonsterController monsterController;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);
        step = mock(StepMonsters.class);
        monster = mock(Monster.class);
        when(monster.getPosition()).thenReturn(new Position(1,1));
        monsterController = new MonsterController(arena, step, monster);
    }


    @Test
    void testRunnerMonsterSwitchesMovement() throws IOException {
        when(monster.getType()).thenReturn(3);
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(5,5));

        when(arena.getIceCream()).thenReturn(mockedIceCream);

        monsterController = new MonsterController(arena, step, monster);

        Field lastChange = null;
        Field runnerOn = null;
        try {
            lastChange = MonsterController.class.getDeclaredField("lastChange");
            runnerOn = MonsterController.class.getDeclaredField("runnerOn");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        lastChange.setAccessible(true);
        runnerOn.setAccessible(true);
        try {
            lastChange.set(monsterController, System.currentTimeMillis());
            runnerOn.set(monsterController, false);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        monsterController.step(System.currentTimeMillis() + 30000);

        verify(monster, times(1)).startRunning();
    }

    @Test
    void testRunnerMonsterSwitchesMovementOff() throws IOException {
        when(monster.getType()).thenReturn(3);
        IceCream mockedIceCream = mock(IceCream.class);
        when(mockedIceCream.getPosition()).thenReturn(new Position(5, 5));

        when(arena.getIceCream()).thenReturn(mockedIceCream);

        monsterController = new MonsterController(arena, step, monster);

        Field lastChange = null;
        Field runnerOn = null;
        try {
            lastChange = MonsterController.class.getDeclaredField("lastChange");
            runnerOn = MonsterController.class.getDeclaredField("runnerOn");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        lastChange.setAccessible(true);
        runnerOn.setAccessible(true);
        try {
            lastChange.set(monsterController, System.currentTimeMillis());
            runnerOn.set(monsterController, true);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        monsterController.step(System.currentTimeMillis() + 30000);

        verify(monster, times(1)).stopRunning();
    }
}
