package badIceCream.states;

import badIceCream.controller.game.ArenaController;
import badIceCream.model.game.arena.Arena;
import badIceCream.viewer.Viewer;
import badIceCream.controller.Controller;
import badIceCream.viewer.game.ArenaViewer;

public class GameState extends State<Arena> {
    protected int level;
    public GameState(Arena arena, int level) {
        super(arena);
        this.level = level;
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new ArenaViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel(), level);
    }
}