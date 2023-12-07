package badIceCream.gui;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import javax.swing.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameGraphicsTest {
    private TextGraphics textGraphics;

    private GameGraphics gameGraphics;
    private Screen screen;
    private KeyStroke keyStroke;

    @BeforeEach
    public void setUp() throws IOException {
        screen = mock(Screen.class);
        textGraphics = mock(TextGraphics.class);
        keyStroke = mock(KeyStroke.class);
        when(screen.pollInput()).thenReturn(keyStroke);
        when(screen.newTextGraphics()).thenReturn(textGraphics);
        gameGraphics = new GameGraphics(10,10);
        gameGraphics.screen = screen;
    }
    @Test
    public void drawCharacter() throws IOException {
        gameGraphics.drawCharacter(1,1, 'c', "#336699");

        verify(textGraphics, times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        verify(textGraphics, times(1)).putString(1, 1, "c");
    }
    @Test
    public void drawText() throws IOException {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        gameGraphics.drawText(new Position(1,1), "test", "#336699");

        verify(textGraphics, times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        verify(textGraphics, times(1)).putString(1, 1, "test");
    }
    @Test
    public void clear() {
        gameGraphics.clear();
        verify(screen, times(1)).clear();
    }
    @Test
    public void close() throws IOException {
        gameGraphics.close();
        verify(screen, times(1)).close();
    }
    @Test
    public void refresh() throws IOException {
        gameGraphics.refresh();
        verify(screen, times(1)).refresh();
    }
    @Test
    public void getNextAction() throws IOException {
        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        GUI.ACTION action = gameGraphics.getNextAction();
        assertEquals(GUI.ACTION.UP, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        action = gameGraphics.getNextAction();
        assertEquals(GUI.ACTION.DOWN, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowLeft);
        action = gameGraphics.getNextAction();
        assertEquals(GUI.ACTION.LEFT, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowRight);
        action = gameGraphics.getNextAction();
        assertEquals(GUI.ACTION.RIGHT, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.Escape);
        action = gameGraphics.getNextAction();
        assertEquals(GUI.ACTION.PAUSE, action);

        when(keyStroke.getKeyType()).thenReturn(null);
        when(keyStroke.getCharacter()).thenReturn(' ');
        action = gameGraphics.getNextAction();
        assertEquals(GUI.ACTION.SPACE, action);

        keyStroke = null;
        action = gameGraphics.getNextAction();
        assertEquals(GUI.ACTION.SPACE, action);
    }
}
