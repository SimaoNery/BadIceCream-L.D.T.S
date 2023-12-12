package badIceCream;

import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;
import badIceCream.GUI.MenuGraphics;
import badIceCream.model.menu.MainMenu;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;
import badIceCream.utils.Type;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private Graphics gui;
    private State state;
    private Audio audio;
    private static Audio backgroundAudio;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new Graphics(new MenuGraphics(140, 50));
        this.state = new MainMenuState(new MainMenu(), 1);
        this.audio = new Audio(Audio.loadMusic("MainMenuMusic.wav"));
        audio.play();
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }
    public void setAudio(Audio audio) {
        this.audio.stop();
        this.audio = audio;
        this.audio.play();
    }

    public static void setBackgroundAudio(Audio audio) {
        backgroundAudio = audio;
    }

    public static void playBackgroundAudio() {
        backgroundAudio.playOnce();
    }

    public void stopAudio() {
        audio.stop();
    }

    public void playAudioOnce() {
        audio.playOnce();
    }

    public void setState(State state, Type type, int width, int height) throws IOException {
        this.state = state;
        if (type != Type.nulo) {
            this.gui.close();
            this.gui = this.getGraphicsForGame(type, width, height);
            this.gui.refresh();
        }
    }

    public void setAll(State state, Graphics gui, Audio audio) {
        this.audio = audio;
        this.state = state;
        this.gui = gui;
    }
    public Graphics getGui(){
        return this.gui;
    }
    public State getState() {
        return this.state;
    }

    public Graphics getGraphicsForGame(Type type, int width, int height) throws IOException {
        return switch (type) {
            case menu -> new Graphics(new MenuGraphics(width, height));
            case game -> new Graphics(new GameGraphics(width, height));
            default -> null;
        };
    }

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