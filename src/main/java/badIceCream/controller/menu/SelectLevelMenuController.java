package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.arena.LoaderArenaBuilder;
import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.states.GameState;
import badIceCream.utils.Audio;
import badIceCream.utils.Type;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SelectLevelMenuController extends MenuController<SelectLevelMenu> {
    public SelectLevelMenuController(SelectLevelMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case LEFT:
                getModel().previousEntry();
                break;
            case RIGHT:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedLevel1()){
                    Arena arena = new LoaderArenaBuilder(1).createArena();
                    try {
                        arena.setBreakWallSound(new Audio(Audio.loadMusic("BreakWallSound.wav")));
                        arena.setBuildWallSound(new Audio(Audio.loadMusic("BuildWallSound.wav")));
                    } catch (LineUnavailableException | UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    }
                    game.setState(new GameState(arena, game.getState().getLevel()), Type.game, arena.getWidth(), arena.getHeight());
                }
                if (getModel().isSelectedLevel2() && game.getState().getLevel() >= 2){
                    Arena arena = new LoaderArenaBuilder(2).createArena();
                    try {
                        arena.setBreakWallSound(new Audio(Audio.loadMusic("BreakWallSound.wav")));
                        arena.setBuildWallSound(new Audio(Audio.loadMusic("BuildWallSound.wav")));
                    } catch (LineUnavailableException | UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    }
                    game.setState(new GameState(arena, game.getState().getLevel()), Type.game, arena.getWidth(), arena.getHeight());
                }
                if (getModel().isSelectedLevel3() && game.getState().getLevel() >= 3){
                    Arena arena = new LoaderArenaBuilder(3).createArena();
                    try {
                        arena.setBreakWallSound(new Audio(Audio.loadMusic("BreakWallSound.wav")));
                        arena.setBuildWallSound(new Audio(Audio.loadMusic("BuildWallSound.wav")));
                    } catch (LineUnavailableException | UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    }
                    game.setState(new GameState(arena, game.getState().getLevel()), Type.game, arena.getWidth(), arena.getHeight());
                }
                if (getModel().isSelectedLevel4() && game.getState().getLevel() >= 4){
                    Arena arena = new LoaderArenaBuilder(4).createArena();
                    try {
                        arena.setBreakWallSound(new Audio(Audio.loadMusic("BreakWallSound.wav")));
                        arena.setBuildWallSound(new Audio(Audio.loadMusic("BuildWallSound.wav")));
                    } catch (LineUnavailableException | UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    }
                    game.setState(new GameState(arena, game.getState().getLevel()), Type.game, arena.getWidth(), arena.getHeight());
                }
                if (getModel().isSelectedLevel5() && game.getState().getLevel() >= 5){
                    Arena arena = new LoaderArenaBuilder(5).createArena();
                    try {
                        arena.setBreakWallSound(new Audio(Audio.loadMusic("BreakWallSound.wav")));
                        arena.setBuildWallSound(new Audio(Audio.loadMusic("BuildWallSound.wav")));
                    } catch (LineUnavailableException | UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    }
                    game.setState(new GameState(arena, game.getState().getLevel()), Type.game, arena.getWidth(), arena.getHeight());
                }

        }
    }
}
