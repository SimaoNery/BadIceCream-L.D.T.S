package org.example.controller.game;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.model.game.arena.Arena;
import org.example.model.menu.MainMenu;
import org.example.states.MainMenuState;


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