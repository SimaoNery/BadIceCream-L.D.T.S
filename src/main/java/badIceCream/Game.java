package badIceCream;

import badIceCream.GUI.GUI;
import badIceCream.GUI.Graphics;
import badIceCream.GUI.MenuGraphics;
import badIceCream.model.menu.MainMenu;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private Graphics gui;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new Graphics(new MenuGraphics(100, 100));
        this.state = new MainMenuState(new MainMenu(), 1);
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state, GUI gui) throws IOException {
        this.state = state;
        if (gui != null) {
            this.gui.close();
            this.gui = new Graphics(gui);
            gui.refresh();
        }
    }

    public State getState() {
        return this.state;
    }

    /*
    public void start() throws IOException {
        int FPS = 4;
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
    }*/

    public void start() throws IOException {
        Thread normalThread = new Thread(() -> {
            while (state != null) {
                long startTime = System.currentTimeMillis();
                try {
                    state.step(this, gui, startTime);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                long elapsedTime = System.currentTimeMillis() - startTime;
                long sleepTime = 1000 / 60 - elapsedTime;
                try {
                    if (sleepTime > 0) Thread.sleep(sleepTime);
                } catch (InterruptedException ignored) {
                }
            }
        });

        Thread monsterThread = new Thread(() -> {
            while (state != null) {
                long startTime = System.currentTimeMillis();
                try {
                    state.stepMonsters(startTime);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                long elapsedTime = System.currentTimeMillis() - startTime;
                long sleepTime = 1000 / 2 - elapsedTime;
                try {
                    if (sleepTime > 0) Thread.sleep(sleepTime);
                } catch (InterruptedException ignored) {
                }
            }
        });

        normalThread.start();
        monsterThread.start();

        try {
            normalThread.join();
            monsterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gui.close();
    }

}