package badIceCream.gui;

import badIceCream.GUI.GameGraphics;
import badIceCream.Game;
import badIceCream.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import net.jqwik.api.Property;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class GameGraphicsTest {
    private TextGraphics textGraphics;

    private GameGraphics gameGraphics;
    private Screen screen;


    @BeforeEach
    public void setUp() throws IOException {
        gameGraphics = new GameGraphics(50,50);
        Field field;
        try {
            field = GameGraphics.class.getDeclaredField("screen");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        field.setAccessible(true);
        try {
            screen = mock(Screen.class);
            field.set(gameGraphics, screen);
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        }
        textGraphics = mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(textGraphics);
        when(screen.close()).thenReturn(System.exit(0);)
    }
    @Test
    public void drawCharacter() throws IOException {
        gameGraphics.drawText(new Position(1, 1), "Hello World", "#336699");
        verify(textGraphics, times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        verify(textGraphics, Mockito.times(1)).putString(1, 1, "Hello World");
        gameGraphics.close();
    }
}
