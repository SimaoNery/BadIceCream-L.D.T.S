package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.arena.LoaderArenaBuilder;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.model.menu.MainMenu;
import badIceCream.states.GameState;
import badIceCream.states.MainMenuState;
import badIceCream.utils.Audio;
import badIceCream.utils.Type;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class GameOverMenuController extends MenuController<GameOverMenu> {

    public GameOverMenuController(GameOverMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedQuitToMainMenu()) {
                    game.setState(new MainMenuState(new MainMenu(), game.getState().getLevel()), Type.menu, 140, 50);
                }
                if (getModel().isSelectedPlayAgain()){
                    Arena arena = new LoaderArenaBuilder(game.getState().getLevel()).createArena();
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
