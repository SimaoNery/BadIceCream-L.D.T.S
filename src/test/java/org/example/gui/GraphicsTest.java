package org.example.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.example.GUI.Graphics;
import org.example.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GraphicsTest {
    private Screen screen;
    private Graphics gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new Graphics(screen);
    }


    @Test
    void drawIceCream() {
        gui.drawIceCream(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "I");
    }
    @Test
    void drawStoneWall() {
        gui.drawStoneWall(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(105, 105, 105));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "#");
    }
    @Test
    void drawIceWall() {
        gui.drawIceWall(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(135, 206, 250));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "+");
    }
    @Test
    void drawDefaultMonster() {
        gui.drawDefaultMonster(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 255, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "D");
    }    @Test
    void drawJumperMonster() {
        gui.drawJumperMonster(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 51, 51));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "J");
    }
    @Test
    void drawRunnerMonster() {
        gui.drawRunnerMonster(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 102));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "R");
    }
    @Test
    void drawWallBreakerMonster() {
        gui.drawWallBreakerMonster(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 153, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "W");
    }
    @Test
    void drawAppleFruit() {
        gui.drawAppleFruit(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "A");
    }
    @Test
    void drawBananaFruit() {
        gui.drawBananaFruit(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "B");
    }
    @Test
    void drawPineappleFruit() {
        gui.drawPineappleFruit(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 102));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "N");
    }
    @Test
    void drawPepperFruit() {
        gui.drawPepperFruit(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "P");
    }
    @Test
    void drawStrawberryFruit() {
        gui.drawStrawberryFruit(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "S");
    }



    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#00FF00");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 255, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }
}
