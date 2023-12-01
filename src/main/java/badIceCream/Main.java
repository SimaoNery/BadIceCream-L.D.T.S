package badIceCream;

import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;
import badIceCream.GUI.MenuGraphics;
import badIceCream.model.menu.GameOverMenu;
import badIceCream.model.menu.PauseMenu;
import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.states.GameOverMenuState;
import badIceCream.states.GameState;
import badIceCream.states.PauseMenuState;
import badIceCream.states.SelectLevelMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        try {
            Game game = new Game();
            game.start();
            game.setState(new SelectLevelMenuState(new SelectLevelMenu(),  1), null);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}