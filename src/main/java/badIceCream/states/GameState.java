package badIceCream.states;

import badIceCream.controller.game.ArenaController;
import badIceCream.model.game.arena.Arena;
import badIceCream.viewer.Viewer;
import badIceCream.controller.Controller;
import badIceCream.viewer.game.ArenaViewer;

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