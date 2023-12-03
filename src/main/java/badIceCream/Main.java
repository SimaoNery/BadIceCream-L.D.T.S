package badIceCream;

import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.states.SelectLevelMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        try {
            Game game = new Game();
            game.start();
            game.setState(new SelectLevelMenuState(new SelectLevelMenu(), game.getState().getLevel()), null);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}