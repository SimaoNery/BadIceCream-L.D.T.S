package badIceCream.states;

import badIceCream.viewer.Viewer;
import badIceCream.controller.Controller;

public abstract class MenuState<T> extends State<T> {

    public MenuState(T menu, Controller controller, Viewer viewer, int level) {
        super(menu, controller, viewer, level);
    }

}
