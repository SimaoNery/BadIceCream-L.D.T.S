package badIceCream;

import badIceCream.GUI.Graphics;
import badIceCream.model.menu.MainMenu;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final badIceCream.GUI.Graphics gui;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new Graphics(20, 20);
        this.state = new MainMenuState(new MainMenu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    private void start() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {
            }
        }

        gui.close();
    }
}