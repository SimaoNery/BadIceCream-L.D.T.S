package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.model.menu.InstructionsMenu;
import badIceCream.model.menu.MainMenu;
import badIceCream.model.menu.Menu;
import badIceCream.states.MainMenuState;

import java.io.IOException;
import java.util.Objects;

public class InstructionsMenuController extends MenuController<InstructionsMenu> {
    public InstructionsMenuController(InstructionsMenu menu) {
        super(menu);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.SELECT) {
            game.setState(new MainMenuState(new MainMenu()));
        }
    }
}
