package org.example.states;

import org.example.controller.Controller;
import org.example.controller.game.ArenaController;
import org.example.model.game.arena.Arena;
import org.example.viewer.Viewer;
import org.example.viewer.game.ArenaViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }


    @Override
    protected Viewer<Arena> getViewer() {
        return new ArenaViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}