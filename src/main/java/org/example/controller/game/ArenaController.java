package org.example.controller.game;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.model.game.arena.Arena;


import java.io.IOException;

public class ArenaController extends GameController {
    private final IceCreamController iceCreamController;
    private final MonsterController monsterController;

    public ArenaController(Arena arena) {
        super(arena);
        this.iceCreamController = new IceCreamController(arena);
        this.monsterController = new MonsterController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {

    }
}