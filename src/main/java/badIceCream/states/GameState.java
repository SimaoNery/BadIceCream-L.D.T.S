package badIceCream.states;

import badIceCream.controller.game.ArenaController;
import badIceCream.controller.game.IceCreamController;
import badIceCream.model.game.arena.Arena;
import badIceCream.viewer.ArenaViewer;

import java.util.ArrayList;

public class GameState extends State<Arena> {
    public GameState(Arena arena, int level) {
        super(arena, new ArenaController(arena, new IceCreamController(arena), new ArrayList<>()), new ArenaViewer(arena), level);
    }
}