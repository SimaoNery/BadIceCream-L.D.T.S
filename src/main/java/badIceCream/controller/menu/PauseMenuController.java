package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.Game;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.menu.MainMenu;
import badIceCream.model.menu.PauseMenu;
import badIceCream.states.GameState;
import badIceCream.states.MainMenuState;


import java.io.IOException;

public class PauseMenuController extends MenuController<PauseMenu> {
    private Arena arena;

    public PauseMenuController(PauseMenu menu, Arena arena) {
        super(menu);
        this.arena = arena;
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
                if (getModel().isSelectedResume()) {
                    game.setAudioController("LevelMusic.wav");
                    game.setState(new GameState(arena, game.getState().getLevel()), new GameGraphics(70, 50, null));
                }
                if (getModel().isSelectedMenu()) game.setState(new MainMenuState(new MainMenu(), game.getState().getLevel()), null);
        }
    }
}
