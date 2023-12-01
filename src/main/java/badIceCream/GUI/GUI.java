package badIceCream.GUI;

import badIceCream.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;


public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
    void drawCharacter(int a, int b, char c, String color);

    enum ACTION {UP, RIGHT, DOWN, LEFT, SPACE, NONE, QUIT, SELECT, RESUME, PAUSE}
}
