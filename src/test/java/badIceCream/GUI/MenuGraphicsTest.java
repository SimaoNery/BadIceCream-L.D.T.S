package badIceCream.GUI;

import badIceCream.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class MenuGraphicsTest {
    @Mock
    private TextGraphics textGraphics;

    private MenuGraphics menuGraphics;
    @Mock
    private Screen screen;
    @Mock
    private KeyStroke keyStroke;
    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        when(screen.pollInput()).thenReturn(keyStroke);
        when(screen.newTextGraphics()).thenReturn(textGraphics);
        menuGraphics = new MenuGraphics(screen);
    }
    @Test
    public void drawCharacter() throws IOException {
        menuGraphics.drawCharacter(1,1, 'c', "#336699");
        verify(textGraphics, times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        verify(textGraphics, times(1)).putString(1, 1, "c");
    }
    @Test
    public void drawText() throws IOException {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        menuGraphics.drawText(new Position(1,1), "test", "#336699");

        verify(textGraphics, times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        verify(textGraphics, times(1)).putString(1, 1, "test");
    }
    @Test
    public void clear() {
        menuGraphics.clear();
        verify(screen, times(1)).clear();
    }
    @Test
    public void close() throws IOException {
        menuGraphics.close();
        verify(screen, times(1)).close();
    }
    @Test
    public void refresh() throws IOException {
        menuGraphics.refresh();
        verify(screen, times(1)).refresh();
    }
    @Test
    public void getNextAction() throws IOException {
        GUI.ACTION action = menuGraphics.getNextAction();
        action = menuGraphics.getNextAction();
        assertEquals(GUI.ACTION.NONE, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        action = menuGraphics.getNextAction();
        assertEquals(GUI.ACTION.UP, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        action = menuGraphics.getNextAction();
        assertEquals(GUI.ACTION.DOWN, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowLeft);
        action = menuGraphics.getNextAction();
        assertEquals(GUI.ACTION.LEFT, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowRight);
        action = menuGraphics.getNextAction();
        assertEquals(GUI.ACTION.RIGHT, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.Escape);
        action = menuGraphics.getNextAction();
        assertEquals(GUI.ACTION.PAUSE, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        action = menuGraphics.getNextAction();
        assertEquals(GUI.ACTION.SELECT, action);
    }
}
