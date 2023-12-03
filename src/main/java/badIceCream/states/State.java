package badIceCream.states;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.Game;
import badIceCream.viewer.Viewer;
import badIceCream.controller.Controller;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;
    private int level;

    public State(T model, int level) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
        this.level = level;
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, Graphics graphics, long time) throws IOException {
        GUI.ACTION action = graphics.getNextAction();
        controller.step(game, action, time);
        viewer.draw(graphics);
    }

    public void stepMonsters(long time) throws IOException {
        controller.stepMonsters(time);
    }

    public int getLevel() {
        return level;
    }

    public int increaseLevel() {
        this.level++;
        return this.level;
    }
}