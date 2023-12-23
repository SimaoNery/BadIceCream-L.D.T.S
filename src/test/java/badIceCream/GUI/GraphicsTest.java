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
import org.mockito.Spy;
import org.mockito.internal.configuration.SpyAnnotationEngine;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GraphicsTest {
    @Mock
    private GUI gui;
    @Mock
    private Position position;
    @Mock
    private Screen screen;
    @Mock
    private TextGraphics textGraphics;
    @Mock
    private KeyStroke keyStroke;
    private Graphics graphics;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        when(gui.createScreen(any())).thenReturn(screen);
        when(screen.newTextGraphics()).thenReturn(textGraphics);
        graphics = spy(new Graphics(gui));
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
    }
    @Test
    public void getNextAction() throws IOException {
        GUI.ACTION action = graphics.getNextAction();
        assertEquals(GUI.ACTION.NONE, action);

        when(screen.pollInput()).thenReturn(keyStroke);
        action = graphics.getNextAction();
        assertEquals(GUI.ACTION.NONE, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        action = graphics.getNextAction();
        assertEquals(GUI.ACTION.UP, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        action = graphics.getNextAction();
        assertEquals(GUI.ACTION.DOWN, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowLeft);
        action = graphics.getNextAction();
        assertEquals(GUI.ACTION.LEFT, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowRight);
        action = graphics.getNextAction();
        assertEquals(GUI.ACTION.RIGHT, action);

        when(keyStroke.getKeyType()).thenReturn(KeyType.Escape);
        action = graphics.getNextAction();
        assertEquals(GUI.ACTION.PAUSE, action);

        when(keyStroke.getKeyType()).thenReturn(null);
        when(keyStroke.getCharacter()).thenReturn(' ');
        action = graphics.getNextAction();
        assertEquals(GUI.ACTION.SPACE, action);
    }
    @Test
    public void clear() {
        graphics.clear();
        verify(screen,times(1)).clear();
    }
    @Test
    public void refresh() throws IOException {
        graphics.refresh();
        verify(screen,times(1)).refresh();
    }
    @Test
    public void close() throws IOException {
        graphics.close();
        verify(screen,times(1)).close();
    }
    @Test
    public void drawIceCream(){
        graphics.drawIceCream(position, GUI.ACTION.UP, true);
        verify(graphics,times(1)).drawCharacter(1, 1, '7', "#48DEFF");
        graphics.drawIceCream(position, GUI.ACTION.UP, false);
        verify(graphics,times(1)).drawCharacter(1, 1, '7', "#FFFFFF");
        graphics.drawIceCream(position, GUI.ACTION.DOWN, true);
        verify(graphics,times(1)).drawCharacter(1, 1, '8', "#48DEFF");
        graphics.drawIceCream(position, GUI.ACTION.DOWN, false);
        verify(graphics,times(1)).drawCharacter(1, 1, '8', "#FFFFFF");
        graphics.drawIceCream(position, GUI.ACTION.LEFT, true);
        verify(graphics,times(1)).drawCharacter(1, 1, ':', "#48DEFF");
        graphics.drawIceCream(position, GUI.ACTION.LEFT, false);
        verify(graphics,times(1)).drawCharacter(1, 1, ':', "#FFFFFF");
        graphics.drawIceCream(position, GUI.ACTION.RIGHT, true);
        verify(graphics,times(1)).drawCharacter(1, 1, '9', "#48DEFF");
        graphics.drawIceCream(position, GUI.ACTION.RIGHT, false);
        verify(graphics,times(1)).drawCharacter(1, 1, '9', "#FFFFFF");
    }
    @Test
    public void drawStoneWall(){
        graphics.drawStoneWall(position);
        verify(graphics,times(1)).drawCharacter(1, 1, 'G', "#696969");
    }
    @Test
    public void drawIceWall(){
        graphics.drawIceWall(position,1);
        verify(graphics,times(1)).drawCharacter(1, 1, 'F', "#87CEFA");
        graphics.drawIceWall(position,3);
        verify(graphics,times(1)).drawCharacter(1, 1, 'f', "#87CEFA");
        graphics.drawIceWall(position,4);
        verify(graphics,times(1)).drawCharacter(1, 1, 'h', "#87CEFA");
        graphics.drawIceWall(position,5);
        verify(graphics,times(1)).drawCharacter(1, 1, 'g', "#87CEFA");
        graphics.drawIceWall(position,6);
        verify(graphics,times(1)).drawCharacter(1, 1, 'i', "#87CEFA");
        graphics.drawIceWall(position,7);
        verify(graphics,times(1)).drawCharacter(1, 1, 'e', "#87CEFA");
        graphics.drawIceWall(position,8);
        verify(graphics,times(1)).drawCharacter(1, 1, 'k', "#87CEFA");
        graphics.drawIceWall(position,9);
        verify(graphics,times(1)).drawCharacter(1, 1, 'l', "#87CEFA");
        graphics.drawIceWall(position,10);
        verify(graphics,times(1)).drawCharacter(1, 1, 'n', "#87CEFA");
        graphics.drawIceWall(position,11);
        verify(graphics,times(1)).drawCharacter(1, 1, 'm', "#87CEFA");
    }
    @Test
    public void drawDefaultMonster() {
        graphics.drawDefaultMonster(position, GUI.ACTION.UP);
        verify(graphics,times(1)).drawCharacter(1, 1, '4', "#00FF00");
        graphics.drawDefaultMonster(position, GUI.ACTION.LEFT);
        verify(graphics,times(1)).drawCharacter(1, 1, '~', "#00FF00");
        graphics.drawDefaultMonster(position, GUI.ACTION.RIGHT);
        verify(graphics,times(1)).drawCharacter(1, 1, 'È', "#00FF00");
        graphics.drawDefaultMonster(position, GUI.ACTION.DOWN);
        verify(graphics,times(1)).drawCharacter(1, 1, 'Y', "#00FF00");
    }
    @Test
    public void drawJumperMonster() {
        graphics.drawJumperMonster(position, GUI.ACTION.UP);
        verify(graphics,times(1)).drawCharacter(1, 1, '/', "#FF3333");
        graphics.drawJumperMonster(position, GUI.ACTION.LEFT);
        verify(graphics,times(1)).drawCharacter(1, 1, 'y', "#FF3333");
        graphics.drawJumperMonster(position, GUI.ACTION.RIGHT);
        verify(graphics,times(1)).drawCharacter(1, 1, 'è', "#FF3333");
        graphics.drawJumperMonster(position, GUI.ACTION.DOWN);
        verify(graphics,times(1)).drawCharacter(1, 1, 'T', "#FF3333");
    }
    @Test
    public void drawRunnerMonster() {
        graphics.drawRunnerMonster(position, GUI.ACTION.UP, true);
        verify(graphics,times(1)).drawCharacter(1, 1, '3', "#FF0000");
        graphics.drawRunnerMonster(position, GUI.ACTION.UP, false);
        verify(graphics,times(1)).drawCharacter(1, 1, '1', "#FFFF66");
        graphics.drawRunnerMonster(position, GUI.ACTION.LEFT, true);
        verify(graphics,times(1)).drawCharacter(1, 1, 'X', "#FF0000");
        graphics.drawRunnerMonster(position, GUI.ACTION.LEFT, false);
        verify(graphics,times(1)).drawCharacter(1, 1, 'W', "#FFFF66");
        graphics.drawRunnerMonster(position, GUI.ACTION.RIGHT, true);
        verify(graphics,times(1)).drawCharacter(1, 1, '}', "#FF0000");
        graphics.drawRunnerMonster(position, GUI.ACTION.RIGHT, false);
        verify(graphics,times(1)).drawCharacter(1, 1, '2', "#FFFF66");
        graphics.drawRunnerMonster(position, GUI.ACTION.DOWN, true);
        verify(graphics,times(1)).drawCharacter(1, 1, '|', "#FF0000");
        graphics.drawRunnerMonster(position, GUI.ACTION.DOWN, false);
        verify(graphics,times(1)).drawCharacter(1, 1, 'V', "#FFFF66");
    }
    @Test
    public void drawWallBreakerMonster() {
        graphics.drawWallBreakerMonster(position, GUI.ACTION.UP);
        verify(graphics,times(1)).drawCharacter(1, 1, '0', "#FF99FF");
        graphics.drawWallBreakerMonster(position, GUI.ACTION.LEFT);
        verify(graphics,times(1)).drawCharacter(1, 1, 'é', "#FF99FF");
        graphics.drawWallBreakerMonster(position, GUI.ACTION.RIGHT);
        verify(graphics,times(1)).drawCharacter(1, 1, 'z', "#FF99FF");
        graphics.drawWallBreakerMonster(position, GUI.ACTION.DOWN);
        verify(graphics,times(1)).drawCharacter(1, 1, 'U', "#FF99FF");
    }
    @Test
    public void drawAppleFruit() {
        graphics.drawAppleFruit(position);
        verify(graphics,times(1)).drawCharacter(1, 1, ']', "#FF0000");
    }
    @Test
    public void drawBananaFruit() {
        graphics.drawBananaFruit(position);
        verify(graphics,times(1)).drawCharacter(1, 1, 'a', "#FFFF00");
    }
    @Test
    public void drawPineappleFruit() {
        graphics.drawPineappleFruit(position);
        verify(graphics,times(1)).drawCharacter(1, 1, '^', "#FFFF66");
    }
    @Test
    public void drawPepperFruit() {
        graphics.drawCherryFruit(position);
        verify(graphics,times(1)).drawCharacter(1, 1, '\\', "#FF0000");
    }
    @Test
    public void drawStrawberryFruit() {
        graphics.drawStrawberryFruit(position);
        verify(graphics,times(1)).drawCharacter(1, 1, '_', "#FF0000");
    }
    @Test
    public void drawHotFloor() {
        graphics.drawHotFloor(position,1);
        verify(graphics,times(1)).drawCharacter(1, 1, 'w', "#e14750");
        graphics.drawHotFloor(position,2);
        verify(graphics,times(1)).drawCharacter(1, 1, 'd', "#e14750");
        graphics.drawHotFloor(position,3);
        verify(graphics,times(1)).drawCharacter(1, 1, 'c', "#e14750");
        graphics.drawHotFloor(position,4);
        verify(graphics,times(1)).drawCharacter(1, 1, 'x', "#e14750");
        graphics.drawHotFloor(position,5);
        verify(graphics,times(1)).drawCharacter(1, 1, '%', "#e14750");
        graphics.drawHotFloor(position,6);
        verify(graphics,times(1)).drawCharacter(1, 1, '(', "#e14750");
        graphics.drawHotFloor(position,7);
        verify(graphics,times(1)).drawCharacter(1, 1, '\'', "#e14750");
        graphics.drawHotFloor(position,8);
        verify(graphics,times(1)).drawCharacter(1, 1, '&', "#e14750");
        graphics.drawHotFloor(position,9);
        verify(graphics,times(1)).drawCharacter(1, 1, ')', "#e14750");
        graphics.drawHotFloor(position,10);
        verify(graphics,times(1)).drawCharacter(1, 1, '+', "#e14750");
        graphics.drawHotFloor(position,11);
        verify(graphics,times(1)).drawCharacter(1, 1, ',', "#e14750");
        graphics.drawHotFloor(position,12);
        verify(graphics,times(1)).drawCharacter(1, 1, '*', "#e14750");
        graphics.drawHotFloor(position,13);
        verify(graphics,times(1)).drawCharacter(1, 1, '-', "#e14750");
        graphics.drawHotFloor(position,14);
        verify(graphics,times(1)).drawCharacter(1, 1, '.', "#e14750");
        graphics.drawHotFloor(position,15);
        verify(graphics,times(1)).drawCharacter(1, 1, 'S', "#e14750");
        graphics.drawHotFloor(position,16);
        verify(graphics,times(1)).drawCharacter(1, 1, 'R', "#e14750");
        graphics.drawHotFloor(position,17);
        verify(graphics,times(1)).drawCharacter(1, 1, '!', "#e14750");
        graphics.drawHotFloor(position,18);
        verify(graphics,times(1)).drawCharacter(1, 1, '#', "#e14750");
        graphics.drawHotFloor(position,19);
        verify(graphics,times(1)).drawCharacter(1, 1, '"', "#e14750");
        graphics.drawHotFloor(position,20);
        verify(graphics,times(1)).drawCharacter(1, 1, '$', "#e14750");
        graphics.drawHotFloor(position,21);
        verify(graphics,times(1)).drawCharacter(1, 1, 'C', "#e14750");
        graphics.drawHotFloor(position,22);
        verify(graphics,times(1)).drawCharacter(1, 1, '@', "#e14750");
        graphics.drawHotFloor(position,23);
        verify(graphics,times(1)).drawCharacter(1, 1, 'D', "#e14750");
        graphics.drawHotFloor(position,24);
        verify(graphics,times(1)).drawCharacter(1, 1, 'B', "#e14750");
        graphics.drawHotFloor(position,25);
        verify(graphics,times(1)).drawCharacter(1, 1, 'A', "#e14750");
        graphics.drawHotFloor(position,26);
        verify(graphics,times(1)).drawCharacter(1, 1, ';', "#e14750");
        graphics.drawHotFloor(position,27);
        verify(graphics,times(1)).drawCharacter(1, 1, '=', "#e14750");
        graphics.drawHotFloor(position,28);
        verify(graphics,times(1)).drawCharacter(1, 1, '>', "#e14750");
        graphics.drawHotFloor(position,29);
        verify(graphics,times(1)).drawCharacter(1, 1, '<', "#e14750");
        graphics.drawHotFloor(position,30);
        verify(graphics,times(1)).drawCharacter(1, 1, 'b', "#e14750");
    }
    @Test
    public void drawText() {
        String text = "string";
        graphics.drawText(position, text, "#336699");
        verify(textGraphics,times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        verify(textGraphics, times(1)).putString(1, 1, text);
    }
    @Test
    public void drawCharacters() {
        graphics.drawCharacters();
        verify(graphics, times(1)).drawCharacter(33, 15, 'Ê', "#00FF00");
        verify(graphics, times(1)).drawCharacter(33, 18, 'À', "#00FF00");
        verify(graphics, times(1)).drawCharacter(33, 21, 'Á', "#00FF00");
        verify(graphics, times(1)).drawCharacter(33, 24, 'È', "#00FF00");
        verify(graphics, times(1)).drawCharacter(33, 27, 'É', "#00FF00");
        verify(graphics, times(1)).drawCharacter(33, 30, 'Í', "#00FF00");
    }
    @Test
    public void drawCharacter() {;
        graphics.drawCharacter(1,1,'c',"#336699");
        verify(textGraphics, times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        verify(textGraphics, times(1)).putString(1, 1, "c");
    }
}
