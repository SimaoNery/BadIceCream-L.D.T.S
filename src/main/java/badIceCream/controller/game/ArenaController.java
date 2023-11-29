package badIceCream.controller.game;

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
import badIceCream.model.menu.MainMenu;
import badIceCream.model.menu.PauseMenu;
import badIceCream.states.GameOverMenuState;
import badIceCream.states.LevelCompletedMenuState;
import badIceCream.states.MainMenuState;
import badIceCream.states.PauseMenuState;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaController extends GameController {
    private final IceCreamController iceCreamController;
    private List<MonsterController> monsterController;

    private int level;

    public ArenaController(Arena arena, int level) {
        super(arena);
        this.level = level;
        this.iceCreamController = new IceCreamController(arena);
        monsterController = new ArrayList<>();

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
        if (getModel().getFruits().isEmpty()) {
            game.setState(new LevelCompletedMenuState(new LevelCompletedMenu(), level + 1));
        }
        else if (!getModel().getIceCream().getAlive()) {
            game.setState(new GameOverMenuState(new GameOverMenu(), level));
        }
        else if (action == GUI.ACTION.PAUSE) {
            game.setState(new PauseMenuState(new PauseMenu(), game.getState(), level));
        }
        else {
            iceCreamController.step(game, action, time);
            for (MonsterController m : monsterController) {
                m.step(time);
            }
        }
    }
}