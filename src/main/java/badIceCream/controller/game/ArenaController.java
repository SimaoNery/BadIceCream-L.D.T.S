package badIceCream.controller.game;

import badIceCream.Game;
import badIceCream.model.game.arena.Arena;
import badIceCream.GUI.GUI;
import badIceCream.model.menu.MainMenu;
import badIceCream.states.MainMenuState;


import java.io.IOException;

public class ArenaController extends GameController {
    private final IceCreamController iceCreamController;
    private final MonsterControllerManager monsterControllerManager;

    public ArenaController(Arena arena) {
        super(arena);
        this.iceCreamController = new IceCreamController(arena);
        monsterControllerManager = new MonsterControllerManager(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getIceCream().getAlive())
            game.setState(new MainMenuState(new MainMenu()));
        else {
            iceCreamController.step(game, action, time);
            monsterControllerManager.step(game, action, time);
        }
    }
}