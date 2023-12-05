package badIceCream.controller.game;

import badIceCream.GUI.MenuGraphics;
import badIceCream.Game;
import badIceCream.controller.game.monsters.DefaultMovement;
import badIceCream.controller.game.monsters.JumperMovement;
import badIceCream.controller.game.monsters.RunnerMovementDisabled;
import badIceCream.controller.game.monsters.WallBreakerMovement;
import badIceCream.model.game.arena.Arena;
import badIceCream.GUI.GUI;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.model.menu.LevelCompletedMenu;
import badIceCream.model.menu.PauseMenu;
import badIceCream.states.*;
import badIceCream.utils.Audio;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaController extends GameController {
    private final IceCreamController iceCreamController;
    private List<MonsterController> monsterController;
    private boolean first;
    private long strawberry;

    public ArenaController(Arena arena) {
        super(arena);
        this.iceCreamController = new IceCreamController(arena);
        monsterController = new ArrayList<>();
        this.first = true;

        for (Monster m : arena.getMonsters()) {
            switch (m.getType()) {
                case 1: monsterController.add(new MonsterController(arena, new DefaultMovement(), m));
                    break;
                case 2: monsterController.add(new MonsterController(arena, new JumperMovement(), m));
                    break;
                case 3: monsterController.add(new MonsterController(arena, new RunnerMovementDisabled(), m));
                    break;
                case 4: monsterController.add(new MonsterController(arena, new WallBreakerMovement(), m));
                    break;
            }
        }
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        int fruit = iceCreamController.eatFruit();
        if (fruit != -1) {
            //new Audio("EatFruitSound.wav").playOnce();
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
                getModel().generateNewFruits(game.getState().getLevel());
            }
            else {
                game.stopAudio();
                Audio levelCompletedAudio = new Audio("LevelCompleteMenuSound.wav");
                levelCompletedAudio.playOnce();
                game.getState().increaseLevel();
                game.setState(new LevelCompletedMenuState(new LevelCompletedMenu(), game.getState().getLevel(), levelCompletedAudio), new MenuGraphics(135, 50));
            }
        }
        else if (!getModel().getIceCream().getAlive()) {
            game.stopAudio();
            Audio gameOverSound = new Audio("GameOverMenuSound.wav");
            gameOverSound.playOnce();
            game.setState(new GameOverMenuState(new GameOverMenu(), game.getState().getLevel(), gameOverSound), new MenuGraphics(135, 50));
        }
        else if (action == GUI.ACTION.PAUSE) {
            game.setAudioController("MainMenuMusic.wav");
            game.setState(new PauseMenuState(new PauseMenu(), game.getState() ,game.getState().getLevel()), new MenuGraphics(135, 50));
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