package badIceCream.controller.game;

import badIceCream.Game;
import badIceCream.controller.game.monsters.*;
import badIceCream.model.game.arena.Arena;
import badIceCream.GUI.GUI;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.model.menu.LevelCompletedMenu;
import badIceCream.model.menu.PauseMenu;
import badIceCream.states.*;
import badIceCream.utils.Audio;
import badIceCream.utils.Type;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public class ArenaController extends GameController {
    private final IceCreamController iceCreamController;
    private final List<MonsterController> monsterController;
    private boolean first;
    private long strawberry;

    public ArenaController(Arena arena, IceCreamController iceCreamController, List<MonsterController> monsterController) {
        super(arena);
        this.iceCreamController = iceCreamController;
        this.monsterController = monsterController;
        this.first = true;

        for (Monster m : arena.getMonsters()) {
            switch (m.getType()) {
                case 1: monsterController.add(new MonsterController(arena, new DefaultMovement(), m));
                    break;
                case 2: monsterController.add(new MonsterController(arena, new JumperMovement(), m));
                    break;
                case 3:
                    monsterController.add(new MonsterController(arena,new RunnerMovementDisabled(), m));
                    break;
                case 4: monsterController.add(new MonsterController(arena, new WallBreakerMovement(), m));
                    break;
            }
        }
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        int fruit = iceCreamController.eatFruit();
        if (fruit != -1) {

            if (fruit == 5) {
                getModel().getIceCream().setStrawberry(true);
                strawberry = time;
            }

        }

        if (getModel().getIceCream().isStrawberryActive() && time - strawberry >= 10000) {
            getModel().getIceCream().setStrawberry(false);
        }

        if (getModel().getFruits().isEmpty()) {
            if (first) {
                first = false;
                getModel().generateNewFruits(getModel().getLevel());
            }
            else {
                if (getModel().getLevel() >= game.getState().getLevel()) {
                    game.getState().increaseLevel();
                }
                game.setState(new LevelCompletedMenuState(new LevelCompletedMenu(), game.getState().getLevel()), Type.win,140,50);
            }
        }
        else if (!getModel().getIceCream().getAlive()) {
            game.setState(new GameOverMenuState(new GameOverMenu(), game.getState().getLevel()), Type.gameOver, 140, 50);
        }
        else if (action == GUI.ACTION.PAUSE) {
            game.setState(new PauseMenuState(new PauseMenu(), (GameState) game.getState(), game.getState().getLevel()), Type.menu, 140, 50);
        }
        else {
            iceCreamController.step(game, action, time);
        }
    }
    @Override
    public void stepMonsters(long time) throws IOException {
        for (MonsterController m : monsterController) {
            m.step(time);
        }
    }
}