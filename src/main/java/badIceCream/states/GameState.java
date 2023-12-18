package badIceCream.states;

import badIceCream.controller.game.ArenaController;
import badIceCream.controller.game.IceCreamController;
import badIceCream.controller.menu.GameOverMenuController;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.utils.Audio;
import badIceCream.utils.AudioController;
import badIceCream.viewer.*;
import badIceCream.viewer.menu.GameOverMenuViewer;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameState extends State<Arena> {
    public GameState(Arena arena, int level) {
        super(arena, new ArenaController(arena, new IceCreamController(arena), new ArrayList<>()), new ArenaViewer(arena, new FruitViewer(), new MonsterViewer(), new WallViewer(), new HotFloorViewer(), new IceCreamViewer()), level);
    }
    public GameState(Arena arena, ArenaController controller, ArenaViewer viewer , int level){
        super(arena, controller, viewer, level);
    }
}