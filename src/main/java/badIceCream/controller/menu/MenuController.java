package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.controller.Controller;

import java.io.IOException;

public abstract class MenuController<T> extends Controller<T> {

    public MenuController(T model) {
        super(model);
    }

}
