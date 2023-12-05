package badIceCream.controller;

import badIceCream.GUI.GUI;
import badIceCream.GUI.MenuGraphics;
import badIceCream.Game;
import badIceCream.controller.game.ArenaController;
import badIceCream.controller.game.IceCreamController;
import badIceCream.controller.game.MonsterController;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.fruits.BananaFruit;
import badIceCream.model.game.elements.monsters.DefaultMonster;
import badIceCream.model.game.elements.monsters.JumperMonster;
import badIceCream.model.game.elements.monsters.RunnerMonster;
import badIceCream.model.game.elements.monsters.WallBreakerMonster;
import badIceCream.states.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class ArenaControllerTest {

    private ArenaController arenaController;
    private Game game;
    private IceCreamController iceCreamController;
    private List<MonsterController> monsterControllers;

    private Arena arena;

    @BeforeEach
    void setUp() {
        Arena arena = Mockito.mock(Arena.class);
        iceCreamController = Mockito.mock(IceCreamController.class);
        monsterControllers = new ArrayList<>();
        monsterControllers.add(Mockito.mock(MonsterController.class));

        when(arena.getMonsters()).thenReturn(Arrays.asList(
                new DefaultMonster(6, 5),
                new JumperMonster(5, 4),
                new WallBreakerMonster(5, 6),
                new RunnerMonster(4, 5)
        ));
        when(arena.getFruits()).thenReturn(Arrays.asList(
                new BananaFruit(6, 5),
                new BananaFruit(5, 4),
                new BananaFruit(5, 6),
                new BananaFruit(4, 5)
        ));

        when(arena.getIceCream()).thenReturn(new IceCream(5, 5));

        this.arena = arena;

        arenaController = new ArenaController(arena, iceCreamController, monsterControllers);
        game = Mockito.mock(Game.class);
    }

    @Test
    void stepTestWin() throws IOException {


        when(arena.getFruits()).thenReturn(Collections.emptyList());
        State mockState = mock(State.class);
        when(game.getState()).thenReturn(mockState);

        Field firstField = null;
        try {
            firstField = ArenaController.class.getDeclaredField("first");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        firstField.setAccessible(true);
        try {
            firstField.set(arenaController, false);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(game, times(1)).stopAudio();
        verify(mockState, times(1)).increaseLevel();
        verify(game).setState(any(LevelCompletedMenuState.class), any(MenuGraphics.class));
    }

    @Test
    void stepTestNewFruits() throws IOException {

        when(arena.getFruits()).thenReturn(Collections.emptyList());
        State mockState = mock(State.class);
        when(game.getState()).thenReturn(mockState);


        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(arena, times(1)).generateNewFruits(anyInt());
    }

    @Test
    void stepTestEscape() throws IOException {
        State mockState = mock(State.class);
        when(game.getState()).thenReturn(mockState);

        arenaController.step(game, GUI.ACTION.PAUSE, System.currentTimeMillis());


        verify(game).setState(any(PauseMenuState.class), any(MenuGraphics.class));
        verify(game, times(1)).setAudioController("MainMenuMusic.wav");
    }

    @Test
    void stepTestGameOver() throws IOException {
        State mockState = mock(State.class);
        when(game.getState()).thenReturn(mockState);

        IceCream mockedIceCream = mock(IceCream.class);
        when(arena.getIceCream()).thenReturn(mockedIceCream);
        when(mockedIceCream.getAlive()).thenReturn(false);

        arenaController.step(game, GUI.ACTION.NONE, System.currentTimeMillis());

        verify(game).stopAudio();
        verify(game).setState(
                any(GameOverMenuState.class),
                any(MenuGraphics.class)
        );
    }

    @Test
    void testStrawberryExpiration() throws IOException {
        State mockState = mock(State.class);
        when(game.getState()).thenReturn(mockState);

        IceCream mockedIceCream = mock(IceCream.class);
        when(arena.getIceCream()).thenReturn(mockedIceCream);

        when(mockedIceCream.isStrawberryActive()).thenReturn(true);
        long currentTime = System.currentTimeMillis();


        arenaController.step(game, GUI.ACTION.UP, currentTime);

        verify(mockedIceCream).setStrawberry(false);

    }

    @Test
    void testStepEatFruit() throws IOException {
        State mockState = mock(State.class);
        when(game.getState()).thenReturn(mockState);
        IceCream mockedIceCream = mock(IceCream.class);


        arenaController = new ArenaController(arena, iceCreamController, monsterControllers);

        when(iceCreamController.eatFruit()).thenReturn(5);
        when(arenaController.getModel().getIceCream()).thenReturn(mockedIceCream);

        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(arenaController.getModel().getIceCream()).setStrawberry(true);

    }

    @Test
    void testStepDontEatStrawberry() throws IOException {
        State mockState = mock(State.class);
        when(game.getState()).thenReturn(mockState);
        IceCream mockedIceCream = mock(IceCream.class);


        arenaController = new ArenaController(arena, iceCreamController, monsterControllers);

        when(iceCreamController.eatFruit()).thenReturn(1,2,3,4);
        when(arenaController.getModel().getIceCream()).thenReturn(mockedIceCream);

        arenaController.step(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(arenaController.getModel().getIceCream(), times(0)).setStrawberry(true);

    }

    @Test
    void testStepIceCream() throws IOException {
        State mockState = mock(State.class);
        when(game.getState()).thenReturn(mockState);

        long step = System.currentTimeMillis();
        arenaController.step(game, GUI.ACTION.UP, step);

        verify(iceCreamController, times(1)).step(game, GUI.ACTION.UP, step);

    }

    @Test
    void testStepMonster() throws IOException {
        State mockState = mock(State.class);
        when(game.getState()).thenReturn(mockState);

        MonsterController mockMonsterController1 = mock(MonsterController.class);
        MonsterController mockMonsterController2 = mock(MonsterController.class);

        List<MonsterController> mockedMonsterControllers = new ArrayList<>(Arrays.asList(mockMonsterController1, mockMonsterController2));
        arenaController = new ArenaController(arena, iceCreamController, mockedMonsterControllers);

        long currentTime = System.currentTimeMillis();
        arenaController.stepMonsters(currentTime);

        verify(mockMonsterController1, times(1)).step(currentTime);
        verify(mockMonsterController2, times(1)).step(currentTime);
    }

}
