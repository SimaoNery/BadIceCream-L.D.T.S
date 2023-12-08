package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.Game;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.arena.LoaderArenaBuilder;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.model.menu.MainMenu;
import badIceCream.states.GameState;
import badIceCream.states.MainMenuState;
import badIceCream.utils.Audio;
import badIceCream.utils.AudioController;

import java.io.IOException;

public class GameOverMenuController extends MenuController<GameOverMenu> {
    private final Audio audio;

    public GameOverMenuController(GameOverMenu menu, Audio audio) {
        super(menu);
        this.audio = audio;
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
                    audio.stop();
                    game.setAudioController(new AudioController(new Audio("MainMenuMusic.wav")));
                    game.setState(new MainMenuState(new MainMenu(), game.getState().getLevel()), null);
                }
                if (getModel().isSelectedPlayAgain()){
                    audio.stop();
                    game.setAudioController(new AudioController(new Audio("LevelMusic.wav")));
                    Arena arena = new LoaderArenaBuilder(game.getState().getLevel()).createArena();
                    game.setState(new GameState(arena, game.getState().getLevel()), new GameGraphics(arena.getWidth(), arena.getHeight()));
                }
        }
    }
}
