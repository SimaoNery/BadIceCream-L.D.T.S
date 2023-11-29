package badIceCream.states;

import badIceCream.viewer.Viewer;
import badIceCream.controller.Controller;

public abstract class MenuState<T> extends State<T> {
    protected int level;

    public MenuState(T menu, int level) {
        super(menu);
    }

    @Override
    abstract protected Viewer<T> getViewer();

    @Override
    abstract protected Controller<T> getController();

}
