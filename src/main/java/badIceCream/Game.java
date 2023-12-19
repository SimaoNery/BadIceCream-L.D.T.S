package badIceCream;

import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;
import badIceCream.GUI.MenuGraphics;
import badIceCream.model.menu.MainMenu;
import badIceCream.states.MainMenuState;
import badIceCream.states.State;
import badIceCream.utils.Audio;
import badIceCream.utils.AudioController;
import badIceCream.utils.Type;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private Graphics gui;
    private State state;

    public Game() throws FontFormatException, IOException {
        this.gui = new Graphics(new MenuGraphics(140, 50));
        this.state = new MainMenuState(new MainMenu(), 4);
        AudioController.playMenuMusic();
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }
    public void setState(State state, Type type, int width, int height) throws IOException {
        this.state = state;
        if (type != Type.nulo) {
            handleSound(type);
            this.gui.close();
            this.gui = this.getGraphicsForGame(type, width, height);
            this.gui.refresh();
        }
    }
    private void handleSound(Type type) {
        switch (type) {
            case menu:
                AudioController.stopGameOverMusic();
                AudioController.stopLevelCompleteMusic();
                AudioController.stopLevelMusic();
                AudioController.playMenuMusic();
                break;
            case win:
                AudioController.stopGameOverMusic();
                AudioController.stopLevelMusic();
                AudioController.stopMenuMusic();
                AudioController.playLevelCompleteMusic();
                break;
            case gameOver:
                AudioController.stopLevelMusic();
                AudioController.stopMenuMusic();
                AudioController.stopLevelCompleteMusic();
                AudioController.playGameOverMusic();
                break;
            case game:
                AudioController.stopMenuMusic();
                AudioController.stopLevelCompleteMusic();
                AudioController.stopGameOverMusic();
                AudioController.playLevelMusic();
        }
    }

    public void setAll(State state, Graphics gui) {

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
            case menu, win, gameOver -> new Graphics(new MenuGraphics(width, height));
            case game -> new Graphics(new GameGraphics(width, height));
            default -> null;
        };
    }

    public synchronized void start() throws IOException {
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