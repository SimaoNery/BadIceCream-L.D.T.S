package badIceCream.viewer;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model){
        this.model = model;
    }
    public T getModel(){
        return model;
    }
    public void draw(Graphics gui) throws IOException{
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(Graphics gui);
}
