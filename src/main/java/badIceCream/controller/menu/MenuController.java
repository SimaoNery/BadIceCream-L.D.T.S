package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.controller.Controller;

import java.io.IOException;

public class MenuController<T> extends Controller<T> {

    public MenuController(T model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {};
}
