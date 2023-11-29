package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.Game;
import badIceCream.controller.Controller;

import java.io.IOException;

public abstract class MenuController<T> extends Controller<T> {
    protected int level;
    public MenuController(T model, int level) {
        super(model);
        this.level = level;
    }

}
