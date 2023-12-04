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
                    game.setAudioController("MainMenuMusic.wav");
                    game.setState(new MainMenuState(new MainMenu(), game.getState().getLevel()), null);
                }
                if (getModel().isSelectedPlayAgain()){
                    game.setAudioController("LevelMusic.wav");
                    Arena arena = new LoaderArenaBuilder(game.getState().getLevel()).createArena();
                    game.setState(new GameState(arena, game.getState().getLevel()), new GameGraphics(arena.getWidth(), arena.getHeight()));
                }
        }
    }
}
